package caracol.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario extends Persona {
	
	private String password;
	private int permiso;

	Conectar cx = new Conectar();
	
	public Usuario() {
		
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

	public int validarUsuario() {
		cx.con();
		
		String com = "SELECT t1.email, password " +
				"FROM Persona AS t1 " +
				"INNER JOIN Usuario AS t2 " +
				"ON t1.email = t2.email " +
				"WHERE t1.email='" + this.getEmail() + "' " +
				"AND password='" + this.getPassword() + "'";
		
		int res = cx.contarFilas(com);
		cx.desconectar();
		return res;
	}
	
	public int validarPermiso() {
		cx.con();
		
		String com = "SELECT permiso " +
						"FROM Usuario " +
						"WHERE email='" + this.getEmail() + "'";
		int permiso = 0;		
		try {
			ResultSet rs = cx.getDatos(com);
			while (rs.next()) {
				permiso = rs.getInt("permiso");
			}
			cx.desconectar();
		} catch (Exception e) {

		}
		
		return permiso;
	}
	
	public int validarEmail() {
		cx.con();
		
		String com = "SELECT email " +
				"FROM Persona " +
				"WHERE email='" + this.getEmail() + "'";
		
		int res = cx.contarFilas(com);
		cx.desconectar();
		return res;
	}
	
	public int registrar_usuario() {
		cx.con(); // Se abre la conexión
		
		this.registrar_persona();
		
		// Se hace la consulta SQL del beneficiario
		String com = "INSERT INTO Usuario (email, password, permiso) " +
						"VALUES ('" + this.getEmail() + "', '" + 
									this.getPassword() +"', '" +
									this.getPermiso() + "')";
				
		int res = cx.execQuery(com); // ejecuta consulta
				
		cx.desconectar();
		
		return res;
	}
}
