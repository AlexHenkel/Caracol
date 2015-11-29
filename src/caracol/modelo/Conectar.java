package caracol.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class Conectar {
	
	private Connection con = null;
	private Statement consulta = null;
	private ResultSet data = null;
	private String server;
	private String BD;
	private String userDB;
	private String passDB;
	
	public Conectar() {
		this.server = "127.0.0.1";
		this.BD = "Caracol";
		this.userDB = "root";
		this.passDB = "secret";
	}
	
	// Método para abrir conexión
	public void con() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + this.server + "/" + this.BD;
			this.con = DriverManager.getConnection(url, userDB, passDB);
			this.consulta = con.createStatement();
		} catch (Exception e) {
			System.out.println("Error de Conexión: " + e.getMessage());
		}
	}
	
	// Método para cerrar conexión
	public void desconectar () {
		try {
			if (con != null) {
				this.con.close();
			}
		} catch (Exception e) {
			System.out.println("Error de desconexión" + e.getMessage());
		}
	}
	
	// Método para ejecutar SQL Insert Update Delete
	public int execQuery(String com) {
		int res = 0;
		
		try {
			this.con();
			res = this.consulta.executeUpdate(com);
		} catch (Exception e) {
			System.out.println("Error de Ejecución " + e.getMessage());
		}
		
		return res;
	}
	
	// Método para ejecutar SQL Select
		public ResultSet getDatos(String com) {			
			try {
				this.con();
				this.data = this.consulta.executeQuery(com);
			} catch (Exception e) {
				System.out.println("Error de la consulta " + e.getMessage());
			}
			
			return data;
		}

}
