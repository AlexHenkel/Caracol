package caracol.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Codigo {
	private String codigo;
	private String permiso;

	Conectar cx = new Conectar();
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPermiso() {
		return permiso;
	}
	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	
	public int registrar_codigo() {
		cx.con(); // Se abre la conexión
		
		// Se hace la consulta SQL
		String com = "INSERT INTO Codigo (codigo, permiso)" +
						"VALUES ('" + this.getCodigo() + "', '" +
									this.getPermiso() + "')";
		
		System.out.println(com);
		int res = cx.execQuery(com); // ejecuta consulta
		
		cx.desconectar();
		
		return res;
	}

	public ResultSet buscar_codigo() {
		String com = "SELECT * " +
						"FROM Codigo " +
						"WHERE codigo='" + this.getCodigo() + "'";
		
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}
	
	public int validarCodigo() {
		cx.con();
		
		String com = "SELECT * " +
				"FROM Codigo " +
				"WHERE codigo='" + this.getCodigo() + "'";
		
		int res = cx.contarFilas(com);
		cx.desconectar();
		return res;
	}
	
	public String validarPermiso() {
		cx.con();
		
		String com = "SELECT permiso " +
						"FROM Codigo " +
						"WHERE codigo='" + this.getCodigo() + "'";
		String permiso = "";		
		try {
			ResultSet rs = cx.getDatos(com);
			while (rs.next()) {
				permiso = rs.getString("permiso");
			}
			cx.desconectar();
		} catch (Exception e) {

		}
		
		return permiso;
	}
	
	public int eliminar_codigo() {
		cx.con();
		
		// Hacer delete de beneficiario
		String com = "DELETE FROM Codigo WHERE codigo='" + this.getCodigo() + "'"; 
		
		int res = cx.execQuery(com);

		cx.desconectar();
				
		return res;
	}
	
	public ResultSet listar_codigo() {
		String com = "SELECT * " +
						"FROM Codigo " +
						"ORDER BY permiso";
		
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}
	
}
