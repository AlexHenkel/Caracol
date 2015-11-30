<%@page session="true"%>
<%
	String usuario = "";
	HttpSession sesionOK = request.getSession();
	if (sesionOK.getAttribute("email") == null) {
%>
<jsp:forward page="index.jsp">
	<jsp:param name="error" value="m" />
</jsp:forward>
<%
	}
	else {
		usuario = (String) sesionOK.getAttribute("email");
	}
%>