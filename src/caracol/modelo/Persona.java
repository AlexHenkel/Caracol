package caracol.modelo;

public class Persona {
	
	private int id_Persona; //PK
	protected String nombre;
	protected String telefono;
	protected String email;
	protected String direccion;
	
	Conectar cx = new Conectar();
	
	public Persona(){
		
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
	
	public int registrar_persona() {
		cx.con(); // Se abre la conexión
				
		// Se hace la consulta SQL
		String com = "INSERT INTO PERSONA (id_Persona, nombre, telefono, email, direccion)" +
						"VALUES (null, '" + this.getNombre() + "', '" +
									this.getTelefono() + "', '" +
									this.getEmail() + "', '" +
									this.getDireccion() + "')";
		
		int res = cx.execQuery(com); // ejecuta consulta
				
		cx.desconectar();
		
		return res;
	}
	
	public int eliminar_persona() {
		cx.con();
		String com = "DELETE FROM Persona WHERE id_Persona='" + this.getId_Persona() + "'";
		int res = cx.execQuery(com);
		return res;
	}

}
