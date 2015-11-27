package caracolJava;

public class Usuario {
	
	private int id_Usuario; //Key
	private int id_Persona; //PK
	private String password;
	private int permiso;

	public Usuario(int id_Usuario, int id_Persona, String password, int permiso) {
		this.id_Usuario = id_Usuario;
		this.id_Persona = id_Persona;
		this.password = password;
		this.permiso = permiso;
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public int getId_Persona() {
		return id_Persona;
	}

	public void setId_Persona(int id_Persona) {
		this.id_Persona = id_Persona;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
}
