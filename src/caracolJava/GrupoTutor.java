package caracolJava;

public class GrupoTutor {
	private int id_Tutor; //FK
	private int id_Grupo; //FK
	
	GrupoTutor(int id_Tutor, int id_Grupo){
		this.id_Tutor = id_Tutor;
		this.id_Grupo = id_Grupo;
	}

	public int getId_Tutor() {
		return id_Tutor;
	}

	public void setId_Tutor(int id_Tutor) {
		this.id_Tutor = id_Tutor;
	}

	public int getId_Grupo() {
		return id_Grupo;
	}

	public void setId_Grupo(int id_Grupo) {
		this.id_Grupo = id_Grupo;
	}
	
}
