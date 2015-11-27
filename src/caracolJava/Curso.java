package caracolJava;

public class Curso {
	//Atributos
	private int id_Curso;		//PK
	private String nombre;
	private String descripcion;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Curso() {
		return id_Curso;
	}

	public void setId_Curso(int id_Curso) {
		this.id_Curso = id_Curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
