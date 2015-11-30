package caracol.modelo;

import java.util.Date;

public class Grupo {
	//Atributos
	private int id_Grupo;		//PK
	private int id_Curso;		//FK
	private int cupo_benficiarios;
	private int cupo_alumnos_tec;
	private int id_Periodo;  // FK
	private int num_grupo;
	private int horario_benficiarios;
	private int horario_alumnos_tec;
	
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

	public int getCupo_benficiarios() {
		return cupo_benficiarios;
	}

	public void setCupo_benficiarios(int cupo_benficiarios) {
		this.cupo_benficiarios = cupo_benficiarios;
	}

	public int getCupo_alumnos_tec() {
		return cupo_alumnos_tec;
	}

	public void setCupo_alumnos_tec(int cupo_alumnos_tec) {
		this.cupo_alumnos_tec = cupo_alumnos_tec;
	}

	public int getId_Periodo() {
		return id_Periodo;
	}

	public void setId_Periodo(int id_Periodo) {
		this.id_Periodo = id_Periodo;
	}

	public int getNum_grupo() {
		return num_grupo;
	}

	public void setNum_grupo(int num_grupo) {
		this.num_grupo = num_grupo;
	}

	public int getHorario_benficiarios() {
		return horario_benficiarios;
	}

	public void setHorario_benficiarios(int horario_benficiarios) {
		this.horario_benficiarios = horario_benficiarios;
	}

	public int getHorario_alumnos_tec() {
		return horario_alumnos_tec;
	}

	public void setHorario_alumnos_tec(int horario_alumnos_tec) {
		this.horario_alumnos_tec = horario_alumnos_tec;
	}

	

}
