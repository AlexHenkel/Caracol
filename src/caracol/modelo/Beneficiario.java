package caracol.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Beneficiario extends Persona{
	//Atributos
	private int id_Beneficiario;	//PK
	private int id_Persona;			//FK
	
	Conectar cx = new Conectar();
	
	public Beneficiario() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId_Beneficiario() {
		return id_Beneficiario;
	}

	public void setId_Beneficiario(int id_Beneficiario) {
		this.id_Beneficiario = id_Beneficiario;
	}

	public int getId_Persona() {
		return id_Persona;
	}

	public void setId_Persona(int id_Persona) {
		this.id_Persona = id_Persona;
	}
	
	public int registrar_beneficiario() {
		cx.con(); // Se abre la conexión
		
		this.registrar_persona();
				
		String com1 = "SELECT id_Persona FROM PERSONA " +
						"ORDER BY id_Persona DESC " +
						"LIMIT 1";
		
		ResultSet rSet = cx.getDatos(com1);
		
		short index = 0;
		
		try {
			while (rSet.next()) {
				index = rSet.getShort(1);
			}
		} catch (SQLException e) {
			System.out.println("Error de Ejecución " + e.getMessage());
		}
		
		// Se hace la consulta SQL del beneficiario
		String com = "INSERT INTO BENEFICIARIO (id_Beneficiario, id_Persona) " +
						"VALUES (null, " + index +")";
		
		int res = cx.execQuery(com); // ejecuta consulta
		
		System.out.println("sale benef");
		
		cx.desconectar();
		
		return res;
	}

	public int actualizar_beneficiario(Curso curso) {
		int res = 0;
		return res;
	}
	
	public int eliminar_beneficiario() {
		cx.con();
		
		// Hacer delete de beneficiario
		String com = "DELETE FROM BENEFICIARIO WHERE id_Beneficiario='" + this.getId_Beneficiario() + "'"; 
		
		int res = cx.execQuery(com);
		
		if (res == 1) {
			res = this.eliminar_persona();
		}
				
		return res;
	}
	
	public ResultSet listar_beneficiario() {
		String com = "SELECT t1.id_Persona, nombre, telefono, email, direccion, id_Beneficiario " +
						"FROM Persona AS t1 " +
						"INNER JOIN Beneficiario AS t2 " +
						"ON t1.id_Persona = t2.id_Persona " +
						"ORDER BY nombre";
		
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}
}
