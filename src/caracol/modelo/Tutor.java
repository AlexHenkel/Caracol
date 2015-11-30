package caracol.modelo;

import java.sql.ResultSet;

public class Tutor extends Usuario {

	private int id_Tutor;
	
	public Tutor() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Tutor() {
		return id_Tutor;
	}

	public void setId_Tutor(int id_Tutor) {
		this.id_Tutor = id_Tutor;
	}

	public Tutor getTutor(Usuario u) {
		cx.con();
		
		Tutor tutor = new Tutor();
		
		String com = "SELECT * FROM Tutor AS t1 " +
						"INNER JOIN Usuario AS t2 " +
								"ON t1.email = t2.email " +
						"INNER JOIN Persona AS t3 " +
								"ON t2.email = t3.email " +
						"WHERE t1.email='" + u.getEmail() + "'";
		try {
			ResultSet rs = cx.getDatos(com);
			while (rs.next()) {
				tutor.setId_Tutor(rs.getShort("id_Tutor"));
				tutor.setEmail(rs.getString(2));
				tutor.setPassword(rs.getString("password"));
				tutor.setPermiso(rs.getShort("permiso"));
				tutor.setId_Persona(rs.getShort("id_Persona"));
				tutor.setNombre(rs.getString("nombre"));
				tutor.setTelefono(rs.getString("telefono"));
				tutor.setDireccion(rs.getString("direccion"));
			}
			cx.desconectar();
			return tutor;
		} catch (Exception e) {
			return tutor = null;
		}
	}

}
