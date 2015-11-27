package caracolJava;

public class Persona {
	
	private int id_Persona; //PK
	private String nombre;
	private String telefono;
	private String email;
	private String direccion;
	
	Persona(int id_Persona, String nombre, String telefono, String email, String direccion){
		this.id_Persona = id_Persona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}

	public int getId_Persona() {
		return id_Persona;
	}

	public void setId_Persona(int id_Persona) {
		this.id_Persona = id_Persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
