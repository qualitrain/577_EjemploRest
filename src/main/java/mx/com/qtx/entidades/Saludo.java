package mx.com.qtx.entidades;

public class Saludo {
	private String saludo;
	private String nombre;
	private String log;
	
	public Saludo(String saludo, String nombre, String log) {
		super();
		this.saludo = saludo;
		this.nombre = nombre;
		this.log = log;
	}

	public Saludo(String saludo, String nombre) {
		super();
		this.saludo = saludo;
		this.nombre = nombre;
	}

	public String getLog() {
		return log;
	}
	
	public void setLog(String log) {
		this.log = log;
	}
	
	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Saludo [saludo=" + saludo + ", nombre=" + nombre + "]";
	}

	
}
