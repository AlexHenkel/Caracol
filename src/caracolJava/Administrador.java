package caracolJava;

public class Administrador {
	//Atributos
	private int id_Administrador;	//PK
	private int id_Usuario;			//FK

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Administrador() {
		return id_Administrador;
	}

	public void setId_Administrador(int id_Administrador) {
		this.id_Administrador = id_Administrador;
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
}
