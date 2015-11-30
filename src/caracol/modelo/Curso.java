package caracol.modelo;

public class Curso {
	//Atributos
	private int id_Curso;		//PK
	private String nombre;
	private String descripcion;
	private String categoria;
	private String incubadora_social;
	private String espacio_formativo;

	Conectar cx = new Conectar();
	
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getIncubadora_social() {
		return incubadora_social;
	}

	public void setIncubadora_social(String incubadora_social) {
		this.incubadora_social = incubadora_social;
	}

	public String getEspacio_formativo() {
		return espacio_formativo;
	}

	public void setEspacio_formativo(String espacio_formativo) {
		this.espacio_formativo = espacio_formativo;
	}

	public int registrar_curso() {
		cx.con(); // Se abre la conexión
		
		// Se hace la consulta SQL
		String com = "INSERT INTO CURSO (id_Curso, nombre, descripcion, incubadora_social, espacio_formativo)" +
						"VALUES (null, '" + this.getNombre() + "', '" +
									this.getDescripcion() + "', '" +
									this.getIncubadora_social() + "', '" +
									this.getEspacio_formativo() + "')";
		
		int res = cx.execQuery(com); // ejecuta consulta
		
		cx.desconectar();
		
		return res;
	}

	public int actualizar_curso(Curso curso) {
		int res = 0;
		return res;
	}
	
	public int borrar_curso(Curso curso) {
		int res = 0;
		return res;
	}

}
