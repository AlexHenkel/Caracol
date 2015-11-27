package caracol.modelo;

public class Curso {
	//Atributos
	private int id_Curso;		//PK
	private String nombre;
	private String descripcion;
	private String ubicacion;

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
	
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public int registrar_curso(Curso curso) {
		cx.con(); // Se abre la conexión
		
		// Se hace la consulta SQL
		String com = "INSERT INTO CURSO (id_Curso, nombre, descripcion, ubicacion)" +
						"VALUES (null, '" + curso.getNombre() + "', '" +
									curso.getDescripcion() + "', '" +
									curso.getUbicacion() + "')";
		
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
