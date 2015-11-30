package caracol.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import caracol.modelo.Curso;

/**
 * Servlet implementation class cCurso
 */
@WebServlet("/cCurso")
public class cCurso extends HttpServlet {

	Curso curso = new Curso();

	String msj = "";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("op");
		switch (opc) {
		case "del": eliminar_Curso(request, response);
			
			break;

		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("op");
		switch (opc) {
		case "in": 
			registrar_Curso(request, response);
			break;
		case "up":
			actualizar_Curso(request, response);
			break;

		default:
			break;
		}
	}

	protected void eliminar_Curso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		curso.setId_Curso(Integer.valueOf(request.getParameter("idCur")));
		int valor = curso.eliminar_curso();
		
		if (valor == 1) {
			msj = "1"; // una eliminacion satisfactoria
		}
		else {
			msj = "2"; // error en la eliminacion
		}
		
		response.sendRedirect("curso_list.jsp?msj=" + msj);
	}

	protected void registrar_Curso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		curso.setNombre(request.getParameter("courseName"));
		curso.setDescripcion(request.getParameter("courseDescription"));
		curso.setCategoria(request.getParameter("courseCategory"));
		curso.setIncubadora_social(request.getParameter("courseIncubadora"));
		curso.setEspacio_formativo(request.getParameter("courseEspacio"));
				
		int valor = curso.registrar_curso();
		
		if (valor == 1) {
			msj = "5"; // una agregación satisfactoria
		}
		else {
			msj = "6"; // error en la agregacion
		}

		response.sendRedirect("home.jsp?msj=" + msj);
	}

	protected void actualizar_Curso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombre = request.getParameter("courseName");
	    
	    String msj = "";
	    
	    if (nombre == null || nombre.trim().isEmpty()) {
	    	msj = "4";
	    }

	    else {
	    	curso.setId_Curso(Short.valueOf(request.getParameter("idCur")));
	    	curso.setNombre(request.getParameter("courseName"));
			curso.setDescripcion(request.getParameter("courseDescription"));
			curso.setCategoria(request.getParameter("courseCategory"));
			curso.setIncubadora_social(request.getParameter("courseIncubadora"));
			curso.setEspacio_formativo(request.getParameter("courseEspacio"));
			
			int v = curso.actualizar_curso();
			
			if (v == 1) {
				msj = "3";
			}
			else {
				msj = "4";
			}
	    }

		response.sendRedirect("curso_list.jsp?msj=" + msj);
	}
}
