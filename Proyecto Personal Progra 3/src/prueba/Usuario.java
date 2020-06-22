package prueba;

public class Usuario {
	public Usuario(String usuario, String contrasena, String dni) {
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.dni = Integer.parseInt(dni);
	}

	public String dimeUsuario() {
		return this.usuario;
	}

	public String dimeContrasena() {
		return this.contrasena;
	}

	public int dimeDni() {
		return this.dni;
	}

	private String usuario;
	private String contrasena;
	private int dni;
}
