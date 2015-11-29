package caracol.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import caracol.modelo.Usuario;

/**
 * Servlet implementation class cUsuario
 */
@WebServlet("/cUsuario")
public class cUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usuario = new Usuario();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setEmail(request.getParameter("lUsuario"));
		usuario.setPassword(request.getParameter("lPass"));
		
		int v = usuario.validarUsuario();
		if (v == 1) {
			response.sendRedirect("home.jsp");
		}
		else {
			response.sendRedirect("index.jsp?error=v#login");
		}
	}

}
