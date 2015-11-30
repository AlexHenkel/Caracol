<%@ page session="true"%>
<%
	HttpSession sesionOK = request.getSession();
	sesionOK.invalidate();
	response.sendRedirect("index.jsp");
%>