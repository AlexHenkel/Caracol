package caracol.modelo;

import java.sql.ResultSet;

public class Socio extends Usuario{

	private int id_Socio;
	
	public Socio() {
		
	}

	public int getId_Socio() {
		return id_Socio;
	}

	public void setId_Socio(int id_Socio) {
		this.id_Socio = id_Socio;
	}

	public Socio getSocio(Usuario u) {
		cx.con();
		
		Socio socio = new Socio();
		
		String com = "SELECT * FROM Socio AS t1 " +
						"INNER JOIN Usuario AS t2 " +
								"ON t1.email = t2.email " +
						"INNER JOIN Persona AS t3 " +
								"ON t2.email = t3.email " +
						"WHERE t1.email='" + u.getEmail() + "'";
		try {
			ResultSet rs = cx.getDatos(com);
			while (rs.next()) {
				socio.setId_Socio(rs.getShort("id_Socio"));
				socio.setEmail(rs.getString(2));
				socio.setPassword(rs.getString("password"));
				socio.setPermiso(rs.getInt("permiso"));
				socio.setId_Persona(rs.getShort("id_Persona"));
				socio.setNombre(rs.getString("nombre"));
				socio.setTelefono(rs.getString("telefono"));
				socio.setDireccion(rs.getString("direccion"));
			}
			cx.desconectar();
			return socio;
		} catch (Exception e) {
			return socio = null;
		}
	}
	
	public int registrarSocio(Usuario usuario) {
		cx.con(); // Se abre la conexión
		
		usuario.registrar_usuario();
		
		// Se hace la consulta SQL del beneficiario
		String com = "INSERT INTO Socio (id_Socio, email) " +
						"VALUES (null, '" + usuario.getEmail() +"')";
		
		int res = cx.execQuery(com); // ejecuta consulta
				
		cx.desconectar();
		
		return res;
	}
}
