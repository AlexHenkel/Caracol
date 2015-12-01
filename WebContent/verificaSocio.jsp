<jsp:useBean id="socio" class="caracol.modelo.Socio" scope="page" />
<%
	int res = socio.contarSocio();
	if (res < 1) {
%>
<jsp:forward page="home.jsp">
	<jsp:param name="msj" value="9" />
</jsp:forward>
<%
	}
%>