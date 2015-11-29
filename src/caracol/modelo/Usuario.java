package caracol.modelo;

public class Usuario extends Persona {
	
	private int id_Usuario; //Key
	private int id_PersonaFK; //PK
	private String password;
	private int permiso;

	Conectar cx = new Conectar();

//	public Usuario(int id_Persona, String nombre, String telefono, String email, String direccion, int id_Usuario, int id_PersonaFK, String password, int permiso) {
//		super(id_Persona, nombre, telefono, email, direccion);
//		this.id_Usuario = id_Usuario;
//		this.id_PersonaFK = id_Persona;
//		this.password = password;
//		this.permiso = permiso;
//	}
	
	public Usuario() {
		
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public int getId_Persona() {
		return id_PersonaFK;
	}

	public void setId_Persona(int id_Persona) {
		this.id_PersonaFK = id_Persona;
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

	public int validarUsuario () {
		cx.con();
		
		String com = "SELECT t1.id_Persona, nombre, telefono, email, direccion, id_Usuario, password, permiso " +
				"FROM Persona AS t1 " +
				"INNER JOIN Usuario AS t2 " +
				"ON t1.id_Persona = t2.id_Persona " +
				"WHERE email='" + this.getEmail() + "' " +
				"AND password='" + this.getPassword() + "'";
		
		int res = cx.contarFilas(com);
		cx.desconectar();
		return res;
	}
}
