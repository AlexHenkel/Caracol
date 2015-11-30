package caracol.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador extends Usuario {
	//Atributos
	private int id_Administrador;	//PK

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Administrador() {
		return id_Administrador;
	}

	public void setId_Administrador(int id_Administrador) {
		this.id_Administrador = id_Administrador;
	}
	
	public Administrador getAdministrador(Usuario u) {
		cx.con();
		
		Administrador admin = new Administrador();
		
		String com = "SELECT * FROM Administrador AS t1 " +
						"INNER JOIN Usuario AS t2 " +
								"ON t1.email = t2.email " +
						"INNER JOIN Persona AS t3 " +
								"ON t2.email = t3.email " +
						"WHERE t1.email='" + u.getEmail() + "'";
		try {
			ResultSet rs = cx.getDatos(com);
			while (rs.next()) {
				admin.setId_Administrador(rs.getShort("id_Administrador"));
				admin.setEmail(rs.getString(2));
				admin.setPassword(rs.getString("password"));
				admin.setPermiso(rs.getInt("permiso"));
				admin.setId_Persona(rs.getShort("id_Persona"));
				admin.setNombre(rs.getString("nombre"));
				admin.setTelefono(rs.getString("telefono"));
				admin.setDireccion(rs.getString("direccion"));				
			}
			cx.desconectar();
			return admin;
		} catch (Exception e) {
			return admin = null;
		}
	}
	
	public int registrarAdministrador(Usuario usuario) {
		cx.con(); // Se abre la conexión
		
		usuario.registrar_usuario();
		
		// Se hace la consulta SQL del beneficiario
		String com = "INSERT INTO Administrador (id_Administrador, email) " +
						"VALUES (null, '" + usuario.getEmail() +"')";
				
		int res = cx.execQuery(com); // ejecuta consulta
				
		cx.desconectar();
		
		return res;
	}
}
