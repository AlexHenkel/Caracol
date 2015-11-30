package caracol.modelo;

public class Sesion {
	private String id_Sesion;
	private String email;
	private String inicio_sesion;
	private String ultimo_acceso;
	private String ip;
	private String host;
	private String servername;
	private String estado;
	
	Conectar cx = new Conectar();
	
	public Sesion() {
		
	}

	public String getId_Sesion() {
		return id_Sesion;
	}

	public void setId_Sesion(String id_Sesion) {
		this.id_Sesion = id_Sesion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInicio_sesion() {
		return inicio_sesion;
	}

	public void setInicio_sesion(String inicio_sesion) {
		this.inicio_sesion = inicio_sesion;
	}

	public String getUltimo_acceso() {
		return ultimo_acceso;
	}

	public void setUltimo_acceso(String ultimo_acceso) {
		this.ultimo_acceso = ultimo_acceso;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int buscarSesion() {
		cx.con();
		String com = "SELECT * FROM Sesion " +
						"WHERE id_Sesion='" + this.getId_Sesion() + "' " +
						"AND email='" + this.getEmail() + "'";
		int res = cx.contarFilas(com);
		cx.desconectar();
		return res;
	}
	
	public int registrarSesion() {
		cx.con();
		String com = "INSERT INTO Sesion (" +
						"id_Sesion, email, inicio_sesion, ultimo_acceso, ip, host, server_name) " +
						"VALUES ('" + this.getId_Sesion() + "', '" + this.getEmail() + "', now(), now(), '" +
						this.getIp() + "', '" + this.getHost() + "', '" + this.getServername() + "')";
		int res = cx.execQuery(com);
		cx.desconectar();
		return res;
	}
	
	public int actualizarSesion() {
		cx.con();
		String com = "UPDATE Sesion SET " +
						"ultimo_acceso=now() " +
						"WHERE id_Sesion='" + this.getId_Sesion() + "' " +
						"AND email='" + this.getEmail() + "'";
		int res = cx.execQuery(com);
		cx.desconectar();
		return res;
	}
}
