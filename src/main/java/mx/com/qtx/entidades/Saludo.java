package mx.com.qtx.entidades;

public class Saludo {
	private String saludo;
	private String nombre;
	
	public Saludo(String saludo, String nombre) {
		super();
		this.saludo = saludo;
		this.nombre = nombre;
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
