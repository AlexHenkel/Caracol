package caracol.controlador;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import caracol.modelo.Codigo;

/**
 * Servlet implementation class cCodigo
 */
@WebServlet("/cCodigo")
public class cCodigo extends HttpServlet {

	Codigo codigo = new Codigo();

	String msj = "";

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cCodigo() {
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
			eliminar_Codigo(request, response);
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
			registrar_Codigo(request, response);
			break;
		case "ve":
			verificar_Codigo(request, response);
			break;
		default:
			break;
		}
	}

	protected void eliminar_Codigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		codigo.setCodigo(request.getParameter("cod"));
		int valor = codigo.eliminar_codigo();
		
		if (valor == 1) {
			msj = "1"; // una eliminacion satisfactoria
		}
		else {
			msj = "2"; // error en la eliminacion
		}
		
		response.sendRedirect("codigo_list.jsp?msj=" + msj);
	}

	protected void registrar_Codigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		codigo.setCodigo(request.getParameter("codigo"));
		codigo.setPermiso(request.getParameter("permiso"));
				
		int valor = codigo.registrar_codigo();
		
		if (valor == 1) {
			msj = "5"; // una agregación satisfactoria
		}
		else {
			msj = "6"; // error en la agregacion
		}

		response.sendRedirect("codigo_list.jsp?msj=" + msj);
	}
	
	private void verificar_Codigo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		codigo.setCodigo(request.getParameter("codigo"));
		
		int v = codigo.validarCodigo();
		
		if (v == 1) {
			String p = codigo.validarPermiso();
			codigo.setPermiso(p);
			HttpSession registroOK = request.getSession();
			registroOK.setAttribute("codigo", codigo.getCodigo());
			registroOK.setAttribute("permiso", codigo.getPermiso());
			response.sendRedirect("registroV.jsp");
		}
		else {
			response.sendRedirect("registro.jsp?error=n");
		}
		
	}

}
