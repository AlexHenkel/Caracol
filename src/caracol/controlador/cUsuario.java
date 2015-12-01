package caracol.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import caracol.modelo.Administrador;
import caracol.modelo.Periodo;
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
	
	String msj = "";
       
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
		String opc = request.getParameter("op");
		switch (opc) {
		case "in": 
			registro(request, response);
			break;
		case "re":
			login(request, response);
			break;
		default:
			break;
		}
	}
	
	private void registro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession registroOK = request.getSession();
		
		int permiso = Integer.parseInt((String) registroOK.getAttribute("permiso"));
		
		usuario.setNombre(request.getParameter("uNombre"));
		usuario.setDireccion(request.getParameter("uDireccion"));
		usuario.setTelefono(request.getParameter("uTelefono"));
		usuario.setEmail(request.getParameter("uEmail"));
		usuario.setPassword(request.getParameter("uPasse"));
		usuario.setPermiso(permiso);
				
		int emailv = usuario.validarEmail();
		
		int r = 0;
		
		if (emailv == 0) {
			switch (permiso) {
			case 1:
				Administrador administrador = new Administrador();
				r = administrador.registrarAdministrador(usuario);
				break;
			case 2:
				Socio socio = new Socio();
				r = socio.registrarSocio(usuario);
				break;
			case 3:
				Tutor tutor = new Tutor();
				r = tutor.registrarTutor(usuario);
				break;
			default:
				break;
			}
			if (r == 1) {
				HttpSession sessionOK = request.getSession();
				
				// Variables de sesion
				sessionOK.setAttribute("email", usuario.getEmail());
				sessionOK.setAttribute("password", usuario.getPassword());
				sessionOK.setAttribute("permiso", usuario.getPermiso());
				sessionOK.setAttribute("nombre", usuario.getNombre());
				sessionOK.setAttribute("telefono", usuario.getTelefono());
				sessionOK.setAttribute("direccion", usuario.getDireccion());
				sessionOK.setAttribute("ip", request.getRemoteAddr());
				
				Periodo periodo = new Periodo();
				sessionOK.setAttribute("periodoA", periodo.validarPeriodoActual());
				
				msj = "7";
				response.sendRedirect("home.jsp?msj=" + msj);
			}
			else {
				msj = "1";
				response.sendRedirect("registroV.jsp?msj=" + msj);
			}
		} else {
			response.sendRedirect("registroV.jsp?msj=2");
		}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
				sessionOK.setAttribute("email", admin.getEmail());
				sessionOK.setAttribute("password", admin.getPassword());
				sessionOK.setAttribute("permiso", admin.getPermiso());
				sessionOK.setAttribute("nombre", admin.getNombre());
				sessionOK.setAttribute("telefono", admin.getTelefono());
				sessionOK.setAttribute("direccion", admin.getDireccion());
				sessionOK.setAttribute("ip", request.getRemoteAddr());
				
				break;
			case 2:
				Tutor tutor = new Tutor();
				
				tutor.getTutor(usuario);

				// Variables de sesion
				sessionOK.setAttribute("email", tutor.getEmail());
				sessionOK.setAttribute("password", tutor.getPassword());
				sessionOK.setAttribute("permiso", tutor.getPermiso());
				sessionOK.setAttribute("nombre", tutor.getNombre());
				sessionOK.setAttribute("telefono", tutor.getTelefono());
				sessionOK.setAttribute("direccion", tutor.getDireccion());
				sessionOK.setAttribute("ip", request.getRemoteAddr());
				break;
			case 3:
				Socio socio = new Socio();
				
				socio.getSocio(usuario);

				// Variables de sesion
				sessionOK.setAttribute("email", socio.getEmail());
				sessionOK.setAttribute("password", socio.getPassword());
				sessionOK.setAttribute("permiso", socio.getPermiso());
				sessionOK.setAttribute("nombre", socio.getNombre());
				sessionOK.setAttribute("telefono", socio.getTelefono());
				sessionOK.setAttribute("direccion", socio.getDireccion());
				sessionOK.setAttribute("ip", request.getRemoteAddr());
			default:
				break;
			}
			
			Periodo periodo = new Periodo();
			sessionOK.setAttribute("periodoA", periodo.validarPeriodoActual());
						
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
