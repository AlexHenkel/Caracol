package caracol.modelo;

public class Socio {

	private int id_Socio;
	private int id_Usuario;
	
	public Socio(int id_Socio, int id_Usuario) {
		this.id_Socio = id_Socio;
		this.id_Usuario = id_Usuario;
	}

	public int getId_Socio() {
		return id_Socio;
	}

	public void setId_Socio(int id_Socio) {
		this.id_Socio = id_Socio;
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	
	

}
