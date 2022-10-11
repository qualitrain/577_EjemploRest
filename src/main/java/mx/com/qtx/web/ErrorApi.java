package mx.com.qtx.web;

public class ErrorApi {
	private String nombre;
	private String valor;
	private String mensaje;
	private String url;
	
	public ErrorApi(String nombre, String valor, String mensaje, String url) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.mensaje = mensaje;
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ErrorApi [nombre=" + nombre + ", valor=" + valor + ", mensaje=" + mensaje + ", url=" + url + "]";
	}

	

}
