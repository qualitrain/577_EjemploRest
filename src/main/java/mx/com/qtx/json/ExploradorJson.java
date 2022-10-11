package mx.com.qtx.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

public class ExploradorJson {

	public static void main(String[] args) {
//		probarCreacionJson();
		probarCreacionJsonAnidado();
//		probarCreacionArregloJson();
//		probarParseoJson();
		probarLeerJson();
	}
	
	public static void probarCreacionJson() {
		System.out.println("\nprobarCreacionJson");
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("nombre", "Gustavo Valle")
		       .add("especialidad", "Pediatra")
		       .add("edad", 45)
		       .add("esSoltero", false);
		JsonObject doctorJson = builder.build();
		
		System.out.println(doctorJson);
	}

	public static void probarCreacionJsonAnidado() {
		System.out.println("\nprobarCreacionJsonAnidado");
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("nombre", "Gustavo Valle")
		       .add("especialidad", "Pediatra")
		       .add("edad", 45)
		       .add("esSoltero", false);
		
		JsonObjectBuilder builderConsultorio = Json.createObjectBuilder();
		builderConsultorio.add("hospital", "Torre Médica Sur")
		                  .add("piso", 3)
		                  .add("num", 129);
		
		builder.add("consultorio", builderConsultorio.build());
		
		JsonObject doctorJson = builder.build();
		
		String nombreDr = doctorJson.getString("nombre");
		System.out.println("El dr se llama " + nombreDr);
		
		System.out.println(doctorJson);
	}
	
	public static void probarCreacionArregloJson() {
		System.out.println("\nprobarCreacionArregloJson");
		
		JsonArrayBuilder builderArr = Json.createArrayBuilder();
		builderArr.add("perro")
		          .add("cocodrilo")
		          .add("correcaminos")
		          .add("coyote");
		
		JsonArray arrJson = builderArr.build();
		
		System.out.println(arrJson);
		
		
		String[] equipos = {"Santos","Chivas","América","Pumas"};
		
		List<String> listEquipos = Arrays.asList(equipos);
		
		JsonArrayBuilder builderArr2 = Json.createArrayBuilder(listEquipos);
		JsonArray arrEquipos = builderArr2.build();
		
		System.out.println(arrEquipos);
	}

	 
	public static void probarParseoJson() {
		System.out.println("\nprobarParseoJson");
		String cadJson="{\"nombre\":\"Gustavo Valle\",\"especialidad\":\"Pediatra\",\"edad\":45,\"esSoltero\""
				+ ":false,\"consultorio\":{\"hospital\":\"Torre Médica Sur\",\"piso\":3,\"num\":129}}";
		
		JsonReader lectorJson = Json.createReader(new StringReader(cadJson));
		JsonObject drJson = lectorJson.readObject();
		
		JsonObject consultorio = drJson.getJsonObject("consultorio");
		System.out.println("El consultorio del dr: " + consultorio);
	}

	public static void probarLeerJson() {
		System.out.println("\nprobarParseoJson");
		String cadJson="{\"nombre\":\"Gustavo Valle\",\"especialidad\":\"Pediatra\",\"edad\":45,\"esSoltero\""
				+ ":false,\"consultorio\":{\"hospital\":\"Torre Médica Sur\",\"piso\":3,\"num\":129}}";
		
		JsonObject consultorio= null;
		JsonObject drJson=null;
		
		try( JsonReader lectorJson = Json.createReader(new FileReader("archivo.json")) ) {
		   drJson = lectorJson.readObject();
		}
		catch(FileNotFoundException fnex) {
			fnex.printStackTrace();
		}
		
		consultorio = drJson.getJsonObject("consultorio");
		System.out.println("El consultorio del dr: " + consultorio);
	}

}
