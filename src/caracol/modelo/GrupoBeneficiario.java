package caracol.modelo;

public class GrupoBeneficiario {
	//Atributos
	private int id_Grupo;			//PK y FK
	private int id_Beneficiario;	//PK y FK
	private int asistencias;
	private int calificacion;
	
	public GrupoBeneficiario() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Grupo() {
		return id_Grupo;
	}

	public void setId_Grupo(int id_Grupo) {
		this.id_Grupo = id_Grupo;
	}

	public int getId_Beneficiario() {
		return id_Beneficiario;
	}

	public void setId_Beneficiario(int id_Beneficiario) {
		this.id_Beneficiario = id_Beneficiario;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

}
