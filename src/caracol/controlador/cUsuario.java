package caracol.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import caracol.modelo.Administrador;
import caracol.modelo.Sesion;
import caracol.modelo.Socio;
import caracol.modelo.Tutor;
import caracol.modelo.Usuario;

/**
 * Servlet implementation class cUsuario
 */
@WebServlet("/cUsuario")
public class cUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usuario = new Usuario();
	Sesion sesion = new Sesion();
       
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
		usuario.setPassword(request.getParameter("lPasse"));
		
		int v = usuario.validarUsuario();
		if (v == 1) {
			HttpSession sessionOK = request.getSession();
			
			sesion.setId_Sesion(sessionOK.getId());
			sesion.setEmail(request.getParameter("lUsuario"));
			
			if (sesion.buscarSesion() == 1) { // Busca si existe sesion con el id y con el email
				sesion.actualizarSesion(); // Si existe actualiza la fecha
			} else {
				registrarSesion(sessionOK.getId(), request, response); // Crea una nueva sesión
			}
			
			switch (usuario.validarPermiso()) {
			case 1:
				Administrador admin = new Administrador();
				
				admin = admin.getAdministrador(usuario);
				
				// Variables de sesion
				sessionOK.setAttribute("idUsuario", admin.getId_Administrador());
				sessionOK.setAttribute("email", admin.getEmail());
				sessionOK.setAttribute("password", admin.getPassword());
				sessionOK.setAttribute("permiso", admin.getPermiso());
				sessionOK.setAttribute("idPersona", admin.getId_Persona());
				sessionOK.setAttribute("nombre", admin.getNombre());
				sessionOK.setAttribute("telefono", admin.getTelefono());
				sessionOK.setAttribute("direccion", admin.getDireccion());
				sessionOK.setAttribute("ip", request.getRemoteAddr());
				
				break;
			case 2:
				Tutor tutor = new Tutor();
				
				tutor.getTutor(usuario);

				// Variables de sesion
				sessionOK.setAttribute("idUsuario", tutor.getId_Tutor());
				sessionOK.setAttribute("email", tutor.getEmail());
				sessionOK.setAttribute("password", tutor.getPassword());
				sessionOK.setAttribute("permiso", tutor.getPermiso());
				sessionOK.setAttribute("idPersona", tutor.getId_Persona());
				sessionOK.setAttribute("nombre", tutor.getNombre());
				sessionOK.setAttribute("telefono", tutor.getTelefono());
				sessionOK.setAttribute("direccion", tutor.getDireccion());
				sessionOK.setAttribute("ip", request.getRemoteAddr());
				break;
			case 3:
				Socio socio = new Socio();
				
				socio.getSocio(usuario);

				// Variables de sesion
				sessionOK.setAttribute("idUsuario", socio.getId_Socio());
				sessionOK.setAttribute("email", socio.getEmail());
				sessionOK.setAttribute("password", socio.getPassword());
				sessionOK.setAttribute("permiso", socio.getPermiso());
				sessionOK.setAttribute("idPersona", socio.getId_Persona());
				sessionOK.setAttribute("nombre", socio.getNombre());
				sessionOK.setAttribute("telefono", socio.getTelefono());
				sessionOK.setAttribute("direccion", socio.getDireccion());
				sessionOK.setAttribute("ip", request.getRemoteAddr());
			default:
				break;
			}
			
			// Direccionamos al home
			response.sendRedirect("home.jsp");
		}
		else {
			response.sendRedirect("index.jsp?error=v#login");
		}
	}
	
	protected void registrarSesion(String idSesion, HttpServletRequest request, HttpServletResponse response) {
		sesion.setId_Sesion(idSesion);
		sesion.setEmail(request.getParameter("lUsuario"));
		sesion.setIp(request.getRemoteAddr());
		sesion.setHost(request.getRemoteHost());
		sesion.setServername(request.getServerName());
		sesion.registrarSesion();
	}

}
