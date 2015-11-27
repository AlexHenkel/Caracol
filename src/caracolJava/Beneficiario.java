package caracolJava;

public class Beneficiario {
	//Atributos
	private int id_Beneficiario;	//PK
	private int id_Persona;			//FK
	
	public Beneficiario() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId_Beneficiario() {
		return id_Beneficiario;
	}

	public void setId_Beneficiario(int id_Beneficiario) {
		this.id_Beneficiario = id_Beneficiario;
	}

	public int getId_Persona() {
		return id_Persona;
	}

	public void setId_Persona(int id_Persona) {
		this.id_Persona = id_Persona;
	}
}
