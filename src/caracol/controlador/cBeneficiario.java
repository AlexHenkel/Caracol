package caracol.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import caracol.modelo.Beneficiario;

/**
 * Servlet implementation class cBeneficiario
 */
@WebServlet("/cBeneficiario")
public class cBeneficiario extends HttpServlet {
	
	Beneficiario beneficiario = new Beneficiario();
	
	private static final long serialVersionUID = 1L;
	
	String msj = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cBeneficiario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("op");
		switch (opc) {
		case "del": eliminar_Beneficiario(request, response);
			
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
			registrar_Beneficiario(request, response);
			break;
		case "up": 
			actualizar_Beneficiario(request, response);
			break;

		default:
			break;
		}
	}
	
	protected void eliminar_Beneficiario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		beneficiario.setId_Beneficiario(Integer.valueOf(request.getParameter("idBen")));
		beneficiario.setId_Persona(Integer.valueOf(request.getParameter("idPer")));
		int valor = beneficiario.eliminar_beneficiario();
		
		if (valor == 1) {
			msj = "1"; // una eliminacion satisfactoria
		}
		else {
			msj = "2"; // error en la eliminacion
		}
		
		response.sendRedirect("benef_list.jsp?msj=" + msj);
	}

	protected void registrar_Beneficiario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("benefNombre");
	    String telefono = request.getParameter("benefTelefono");
	    String email = request.getParameter("benefEmail");
	    String direccion = request.getParameter("benefDireccion");
	    
		beneficiario.setNombre(nombre);
		beneficiario.setTelefono(telefono);
		beneficiario.setEmail(email);
		beneficiario.setDireccion(direccion);

		int valor = beneficiario.registrar_beneficiario();

		if (valor == 1) {
			msj = "1"; // una eliminacion satisfactoria
		}
		else {
			msj = "2"; // error en la eliminacion
		}

		response.sendRedirect("home.jsp?msj=" + msj);
	}

	protected void actualizar_Beneficiario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombre = request.getParameter("benefNombre");

	    String msj = "";
	    
	    if (nombre == null || nombre.trim().isEmpty()) {
	    	msj = "4";
	    }

	    else {
	    	beneficiario.setId_Persona(Short.valueOf(request.getParameter("idPer")));
			beneficiario.setNombre(request.getParameter("benefNombre"));
			beneficiario.setTelefono(request.getParameter("benefTelefono"));
			beneficiario.setEmail(request.getParameter("benefEmail"));
			beneficiario.setDireccion(request.getParameter("benefDireccion"));

			int v = beneficiario.actualizar_beneficiario();
			
			if (v == 1) {
				msj = "3";
			}
			else {
				msj = "4";
			}
	    }

		response.sendRedirect("benef_list.jsp?msj=" + msj);
	}

}
