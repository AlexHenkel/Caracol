package caracol.modelo;

import java.sql.ResultSet;

public class Periodo {
	private int id_Periodo;
	private String periodo;
	private String estado;
	
	Conectar cx = new Conectar();
	
	public int getId_Periodo() {
		return id_Periodo;
	}
	
	public void setId_Periodo(int id_Periodo) {
		this.id_Periodo = id_Periodo;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int registrar_periodo() {
		cx.con(); // Se abre la conexión
		
		// Se hace la consulta SQL
		String com = "INSERT INTO Periodo (id_Periodo, periodo, estado)" +
						"VALUES (null, '" + this.getPeriodo() + "', '0')";
		
		int res = cx.execQuery(com); // ejecuta consulta
		
		cx.desconectar();
		
		return res;
	}

	public ResultSet buscar_periodo() {
		String com = "SELECT * " +
						"FROM Periodo " +
						"WHERE id_Periodo='" + this.getId_Periodo() + "'";
		
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}
	
	public int eliminar_periodo() {
		cx.con();
		
		if (this.contar_periodo() > 1) {
			// Hacer delete de beneficiario
			String com = "DELETE FROM Periodo WHERE id_Periodo='" + this.getPeriodo() + "'"; 
			
			int res = cx.execQuery(com);

			cx.desconectar();
					
			return res;
		}
		return 0;
	}
	
	public ResultSet listar_periodo() {
		String com = "SELECT * " +
						"FROM Periodo " +
						"ORDER BY id_Periodo DESC";
		
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}
	
	public int contar_periodo() {
		String com = "SELECT * " +
						"FROM Periodo";
		
		int res = cx.contarFilas(com);
		
		return res;
	}

	public int actualizarPeriodo() {
		cx.con();
		
		String com = "UPDATE PeriodoActual SET " +
				"id_Periodo='" + this.getId_Periodo() + "'";
		
		int res = cx.execQuery(com);
		
		cx.desconectar();
		return res;
	}
	
	public String validarPeriodoActual() {
		cx.con();
		
		String com = "SELECT * " +
						"FROM PeriodoActual";
		String periodo = "";		
		try {
			ResultSet rs = cx.getDatos(com);
			while (rs.next()) {
				periodo = rs.getString(1);
			}
			cx.desconectar();
		} catch (Exception e) {

		}
		
		return periodo;
	}
}
