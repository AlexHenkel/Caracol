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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		curso.setNombre(request.getParameter("courseName"));
		curso.setDescripcion(request.getParameter("courseDescription"));
		curso.setIncubadora_social(request.getParameter("courseIncubadora"));
		curso.setEspacio_formativo(request.getParameter("courseEspacio"));
		curso.registrar_curso();
		response.sendRedirect("home.jsp");
	}

}
