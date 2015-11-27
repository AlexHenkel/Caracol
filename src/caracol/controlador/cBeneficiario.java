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
		beneficiario.setNombre(request.getParameter("benefNombre"));
		beneficiario.setTelefono(request.getParameter("benefTelefono"));
		beneficiario.setEmail(request.getParameter("benefEmail"));
		beneficiario.setDireccion(request.getParameter("benefDireccion"));
		beneficiario.registrar_beneficiario();
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
