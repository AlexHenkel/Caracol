package caracol.modelo;

public class GrupoSocio {
	private int id_Grupo; //FK
	private int id_Socio; //FK
	
	void GroupSocio(int id_Grupo, int id_Socio){
		this.id_Grupo = id_Grupo;
		this.id_Socio = id_Socio;
	}

	public int getId_Grupo() {
		return id_Grupo;
	}

	public void setId_Grupo(int id_Grupo) {
		this.id_Grupo = id_Grupo;
	}

	public int getId_Socio() {
		return id_Socio;
	}

	public void setId_Socio(int id_Socio) {
		this.id_Socio = id_Socio;
	}
}
