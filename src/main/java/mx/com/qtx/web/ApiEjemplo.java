package mx.com.qtx.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import mx.com.qtx.entidades.Saludo;

@RestController
public class ApiEjemplo {
	
	private static Logger log = LoggerFactory.getLogger(ApiEjemplo.class);
	
	@GetMapping(path="/saludo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Buenas tardes";
	}
	
	@GetMapping(path="/saludo/{nombre}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludarA(@PathVariable String nombre) {
		
		return "Buenas tardes " + nombre + " !!";
	}

	@GetMapping(path="/saludo/{nombre}/{n}", produces = MediaType.TEXT_PLAIN_VALUE)
	String saludarAnVeces(@PathVariable String nombre, @PathVariable int n) {	
		String saludo = "";
		for(int i=0; i<n; i++) {
			saludo += "Buenas tardes " + nombre + ", ";
		}
		return saludo;
	}
	
	@GetMapping(path="/saludo/json/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Saludo generarSaludo(@PathVariable String nombre) {
		Saludo saludo = new Saludo("Hola",nombre);
		
		return saludo;
	
	}
	@GetMapping(path="/saludos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Saludo> generarSaludos() {
		List<Saludo> listSaludos = new ArrayList<>();
		listSaludos.add(new Saludo("Hola","Betty"));
		listSaludos.add(new Saludo("Buenos días","Jaime"));
		listSaludos.add(new Saludo("Buenas tardes","Pedro"));
		listSaludos.add(new Saludo("Buenas noches","Lorena"));
		
		return listSaludos;
	
	}
	
	@GetMapping(path = "/saludo/xml/{nombre}",  
			produces = { MediaType.APPLICATION_XML_VALUE, 
					     MediaType.APPLICATION_JSON_VALUE})
	public Saludo generarSaludoXml(@PathVariable String nombre) {
		Saludo saludo = new Saludo("Vientos!",nombre);
		
		return saludo;
	
	}
	
	@GetMapping(path="/saludo/broma/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Saludo> generarSaludoRE(@PathVariable String nombre) {
		Saludo saludo = new Saludo("Hola",nombre);
		
		ResponseEntity<Saludo> response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
				                                        .body(saludo);
		return response;	
	}
	
	@PostMapping(path = "/saludo", consumes = MediaType.APPLICATION_JSON_VALUE, 
			                       produces = MediaType.APPLICATION_XML_VALUE)
	public Saludo insertarSaludo(@RequestBody Saludo miSaludo) {
		System.out.println("saludo recibido:" + miSaludo);
		return miSaludo;
	}

	@PostMapping(path = "/saludo2", consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_XML_VALUE)
	public Saludo insertarSaludoB(HttpEntity<Saludo> miSaludo, HttpServletRequest req) {
		System.out.println("saludo recibido:" + miSaludo);
		System.out.println(miSaludo.getHeaders().getAccept());
		System.out.println("servlet path: " + req.getServletPath());
		
		return miSaludo.getBody();
	}
	@ExceptionHandler
	public ResponseEntity<ErrorApi> manejarErrorDeTipoArgumento(MethodArgumentTypeMismatchException matmEx, HttpServletRequest req) {
		ErrorApi error = new ErrorApi(matmEx.getName(), 
				                      matmEx.getValue().toString(),
				                      "Error en el tipo de valor enviado. Debe ser un número",
				                      req.getServletPath());
		
		log.error("Petición con formato erróneo:" + error.toString());
		return new ResponseEntity<ErrorApi>(error, HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@ExceptionHandler
	public String manejarError(Exception ex) {
		String error = ex.getClass().getName() + ":" + ex.getMessage();
		return error;		
	}

}
