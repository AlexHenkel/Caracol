package caracol.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import caracol.modelo.Grupo;

/**
 * Servlet implementation class cGrupo
 */
@WebServlet("/cGrupo")
public class cGrupo extends HttpServlet {
	
	Grupo grupo = new Grupo();
	
	String msj = "";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("op");
		switch (opc) {
		case "del": eliminar_Grupo(request, response);
			
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
			System.out.println("hla");
			registrar_Grupo(request, response);
			break;
		case "up":
			actualizar_Grupo(request, response);
			break;
		case "bu":
			actualizar_Periodo(request, response);
			break;

		default:
			break;
		}
	}
	
	private void actualizar_Periodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int p = Short.valueOf(request.getParameter("periodoActual"));
		
		response.sendRedirect("grupo_list.jsp?pa=" + p);
		
		
	}

	private void registrar_Grupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		grupo.setId_Grupo(Short.valueOf(request.getParameter("idGru")));
		grupo.setId_Curso(Short.valueOf(request.getParameter("curso")));
		grupo.setCupo_benficiarios(request.getParameter("cupoB"));
		grupo.setCupo_alumnos_tec(request.getParameter("cupoA"));
		grupo.setId_Periodo(Short.valueOf(request.getParameter("periodo")));
		grupo.setHorario_alumnos_tec(request.getParameter("horarioA"));
		grupo.setHorario_benficiarios(request.getParameter("horarioB"));
		grupo.setId_Socio(Short.valueOf(request.getParameter("socio")));
				
		int valor = grupo.registrar_grupo();
		
		if (valor == 1) {
			msj = "5"; // una agregación satisfactoria
		}
		else {
			msj = "6"; // error en la agregacion
		}

		response.sendRedirect("grupo_list.jsp?msj=" + msj);
		
	}

	private void actualizar_Grupo(HttpServletRequest request, HttpServletResponse response) throws IOException {	    
	    String msj = "";
		
		grupo.setId_Grupo(Short.valueOf(request.getParameter("idGru")));
		grupo.setId_Curso(Short.valueOf(request.getParameter("curso")));
		grupo.setCupo_benficiarios(request.getParameter("cupoB"));
		grupo.setCupo_alumnos_tec(request.getParameter("cupoA"));
		grupo.setId_Periodo(Short.valueOf(request.getParameter("periodo")));
		grupo.setHorario_alumnos_tec(request.getParameter("horarioA"));
		grupo.setHorario_benficiarios(request.getParameter("horarioB"));
		grupo.setId_Socio(Short.valueOf(request.getParameter("socio")));
		
		int v = grupo.actualizar_grupo();
		
		if (v == 1) {
			msj = "3";
		}
		else {
			msj = "4";
		}

		response.sendRedirect("grupo_list.jsp?msj=" + msj);
		
	}

	private void eliminar_Grupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		grupo.setId_Grupo(Integer.valueOf(request.getParameter("idGru")));
		int valor = grupo.eliminar_grupo();
		
		if (valor == 1) {
			msj = "1"; // una eliminacion satisfactoria
		}
		else {
			msj = "2"; // error en la eliminacion
		}
		
		response.sendRedirect("grupo_list.jsp?msj=" + msj);
		
	}

}
