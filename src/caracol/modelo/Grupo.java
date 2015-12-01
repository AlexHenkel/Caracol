package caracol.modelo;

import java.sql.ResultSet;
import java.util.Date;

public class Grupo {
	//Atributos
	private int id_Grupo;		//PK
	private int id_Curso;		//FK
	private String cupo_benficiarios;
	private String cupo_alumnos_tec;
	private int id_Periodo;  // FK
	private String horario_benficiarios;
	private String horario_alumnos_tec;
	private int id_Socio;
	
	Conectar cx = new Conectar();
	
	public Grupo() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Grupo() {
		return id_Grupo;
	}

	public void setId_Grupo(int id_Grupo) {
		this.id_Grupo = id_Grupo;
	}

	public int getId_Curso() {
		return id_Curso;
	}

	public void setId_Curso(int id_Curso) {
		this.id_Curso = id_Curso;
	}

	public String getCupo_benficiarios() {
		return cupo_benficiarios;
	}

	public void setCupo_benficiarios(String cupo_benficiarios) {
		this.cupo_benficiarios = cupo_benficiarios;
	}

	public String getCupo_alumnos_tec() {
		return cupo_alumnos_tec;
	}

	public void setCupo_alumnos_tec(String cupo_alumnos_tec) {
		this.cupo_alumnos_tec = cupo_alumnos_tec;
	}

	public int getId_Periodo() {
		return id_Periodo;
	}

	public void setId_Periodo(int id_Periodo) {
		this.id_Periodo = id_Periodo;
	}

	public String getHorario_benficiarios() {
		return horario_benficiarios;
	}

	public void setHorario_benficiarios(String horario_benficiarios) {
		this.horario_benficiarios = horario_benficiarios;
	}

	public String getHorario_alumnos_tec() {
		return horario_alumnos_tec;
	}

	public void setHorario_alumnos_tec(String horario_alumnos_tec) {
		this.horario_alumnos_tec = horario_alumnos_tec;
	}

	public int getId_Socio() {
		return id_Socio;
	}

	public void setId_Socio(int id_Socio) {
		this.id_Socio = id_Socio;
	}

	public ResultSet listar_grupo() {
		String com = "SELECT * " + 
						"FROM Grupo AS t1 " +
						"INNER JOIN Socio AS t2 " +
								"ON t1.id_Socio = t2.id_Socio " +
						"INNER JOIN Curso AS t3 " +
								"ON t1.id_Curso = t3.id_Curso " +
						"INNER JOIN Periodo AS t4 " +
								"ON t1.id_Periodo = t2.id_Periodo";
				
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}
	
	public ResultSet listar_grupoPeriodo() {
		String com = "SELECT t3.nombre as CursoN, cupo_beneficiarios, cupo_alumnos_tec, periodo, horario_alumnos_tec, horario_beneficiarios, t5.nombre as SocioN " +
					    "FROM Grupo AS t1 " +
						"INNER JOIN Periodo AS t2 " +
							"ON t1.id_Periodo = t2.id_Periodo " +
						"INNER JOIN Curso AS t3 " +
							"ON t1.id_Curso = t3.id_Curso " +
						"INNER JOIN Socio AS t4 " +
							"ON t4.id_Socio = t1.id_Socio " +
						"INNER JOIN Persona AS t5 " +
							"ON t4.email = t5.email " +
						"WHERE t1.id_Periodo='" + this.getId_Periodo() + "'";
				
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}
	
	public int eliminar_grupo() {
		cx.con();
		
		// Hacer delete de beneficiario
		String com = "DELETE FROM Grupo WHERE id_Grupo='" + this.getId_Grupo() + "'"; 
		
		int res = cx.execQuery(com);

		cx.desconectar();
				
		return res;
	}
	
	public int actualizar_grupo() {
		cx.con();
		String com = "UPDATE Persona SET " +
						"id_curso='" + this.getId_Curso() + "'," +
						"cupo_beneficiarios='" + this.getCupo_benficiarios() + "'," +
						"cupo_alumnos_tec='" + this.getCupo_alumnos_tec() + "'," +
						"id_Periodo='" + this.getId_Periodo() + "'," +
						"horario_alumnos_tec='" + this.getHorario_alumnos_tec() + "'," +
						"horario_beneficiarios='" + this.getHorario_benficiarios() + "'," +
						"id_socio='" + this.getId_Socio() + "' " +
						"WHERE id_Grupo='" + this.getId_Grupo() + "'";
		int res = cx.execQuery(com);
		cx.desconectar();
		return res;
	}
	
	public int registrar_grupo() {
		cx.con(); // Se abre la conexión
		
		// Se hace la consulta SQL
		String com = "INSERT INTO CURSO (id_Grupo, id_Curso, cupo_beneficiarios, cupo_alumnos_tec, id_Periodo, horario_alumnos_tec, horario_beneficiarios, id_socio)" +
						"VALUES (null, '" + this.getId_Curso() + "', '" +
									this.getCupo_benficiarios() + "', '" +
									this.getCupo_alumnos_tec() + "', '" +
									this.getId_Periodo() + "', '" +
									this.getHorario_alumnos_tec() + "', '" +
									this.getHorario_benficiarios() + "', '" +
									this.getId_Socio() + "')";
		
		int res = cx.execQuery(com); // ejecuta consulta
		
		cx.desconectar();
		
		return res;
	}
}
