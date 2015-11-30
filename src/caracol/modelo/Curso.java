package caracol.modelo;

import java.sql.ResultSet;

public class Curso {
	//Atributos
	private int id_Curso;		//PK
	private String nombre;
	private String descripcion;
	private String categoria;
	private String incubadora_social;
	private String espacio_formativo;
	
	private int educacion = 1;
	private int tecnologia = 2;
	private int emprendimiento = 3;
	private int arte = 4;
	private int desarrollo_humano = 5;
	private int civica = 6;
	private int ciencias = 7;
	private int idiomas =8; 

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
		String com = "INSERT INTO CURSO (id_Curso, nombre, categoria, descripcion, incubadora_social, espacio_formativo)" +
						"VALUES (null, '" + this.getNombre() + "', '" +
									this.getCategoria() + "', '" +
									this.getDescripcion() + "', '" +
									this.getIncubadora_social() + "', '" +
									this.getEspacio_formativo() + "')";
		
		int res = cx.execQuery(com); // ejecuta consulta
		
		cx.desconectar();
		
		return res;
	}

	public int actualizar_curso() {
		cx.con();
		String com = "UPDATE Curso SET " +
						"nombre='" + this.getNombre() + "'," +
						"descripcion='" + this.getDescripcion() + "'," +
						"categoria='" + this.getCategoria() + "'," +
						"incubadora_social='" + this.getIncubadora_social() + "', " +
						"espacio_formativo='" + this.getEspacio_formativo() + "' " +
						"WHERE id_Curso='" + this.getId_Curso() + "'";
		int res = cx.execQuery(com);
		cx.desconectar();
		return res;
	}

	public ResultSet buscar_curso() {
		String com = "SELECT * " +
						"FROM Curso " +
						"WHERE id_Curso='" + this.getId_Curso() + "'";
		
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}
	
	public int eliminar_curso() {
		cx.con();
		
		// Hacer delete de beneficiario
		String com = "DELETE FROM Curso WHERE id_Curso='" + this.getId_Curso() + "'"; 
		
		int res = cx.execQuery(com);

		cx.desconectar();
				
		return res;
	}
	
	public ResultSet listar_curso() {
		String com = "SELECT * " +
						"FROM Curso " +
						"ORDER BY categoria, nombre";
		
		ResultSet rs = cx.getDatos(com);
		
		return rs;
	}

	public String nombreCategoria(int categoria) {
		switch (categoria) {
			case 1:
				return "Educación";
			case 2:
				return "Tecnología";
			case 3:
				return "Emprendimiento";
			case 4:
				return "Arte";
			case 5:
				return "Desarrollo Humano";
			case 6:
				return "Conciencia Cívica";
			case 7:
				return "Ciencias";
			case 8:
				return "Idiomas";
			default:
				return "";
		}
	}
}
