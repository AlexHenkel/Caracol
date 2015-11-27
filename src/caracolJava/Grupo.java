package caracolJava;

import java.util.Date;

public class Grupo {
	//Atributos
	private int id_Grupo;		//PK
	private int id_Curso;		//FK
	private int cupo;
	private Date fecha_inicio;
	private Date fecha_final;
	private int num_grupo;
	
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

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}

	public int getNum_grupo() {
		return num_grupo;
	}

	public void setNum_grupo(int num_grupo) {
		this.num_grupo = num_grupo;
	}

}
