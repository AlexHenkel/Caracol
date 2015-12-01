package caracol.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import caracol.modelo.Periodo;

/**
 * Servlet implementation class cPeriodo
 */
@WebServlet("/cPeriodo")
public class cPeriodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Periodo periodo = new Periodo();
	
	String msj = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cPeriodo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("op");
		switch (opc) {
		case "del": 
			eliminar_Periodo(request, response);
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
			registrar_Periodo(request, response);
			break;
		case "up":
			actualizar_Periodo(request, response);
		default:
			break;
		}
	}

	private void actualizar_Periodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		periodo.setId_Periodo(Integer.parseInt(request.getParameter("periodoActual")));
		
		int v = periodo.actualizarPeriodo();
		
		if (v == 1) {
			HttpSession sessionOK = request.getSession();
			
			sessionOK.setAttribute("periodoA", request.getParameter("periodoActual"));
			
			msj = "4";
		}
		else {
			msj = "5";
		}
		
		response.sendRedirect("periodo_list.jsp?msj=" + msj);
	}

	private void registrar_Periodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String p = request.getParameter("inicioMes") + " " + request.getParameter("inicioAno") + " - " +
							request.getParameter("finMes") +  "" + request.getParameter("finAno");
		
		periodo.setPeriodo(p);
						
		int valor = periodo.registrar_periodo();
		
		if (valor == 1) {
			msj = "5"; // una agregación satisfactoria
		}
		else {
			msj = "6"; // error en la agregacion
		}

		response.sendRedirect("periodo_list.jsp?msj=" + msj);
	}
	
	private void eliminar_Periodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		periodo.setId_Periodo(Integer.parseInt(request.getParameter("per")));
		int valor = periodo.eliminar_periodo();
		
		if (valor == 1) {
			msj = "1"; // una eliminacion satisfactoria
		}
		else {
			msj = "2"; // error en la eliminacion
		}
		
		response.sendRedirect("periodo_list.jsp?msj=" + msj);
		
	}

}
