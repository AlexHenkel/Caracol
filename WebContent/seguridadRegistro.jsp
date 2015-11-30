<%@page session="true"%>
<%
	String permiso = "";
	HttpSession registroOK = request.getSession();
	if (registroOK.getAttribute("permiso") == null) {
%>
<jsp:forward page="registro.jsp">
	<jsp:param name="error" value="m" />
</jsp:forward>
<%
	}
	else {
		permiso = (String) registroOK.getAttribute("permiso");
	}
%>