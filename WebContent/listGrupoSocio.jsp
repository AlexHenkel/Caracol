<%@page import="java.sql.ResultSet"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="socio" class="caracol.modelo.Socio" scope="page" />
<%
    ResultSet rs = socio.listar_socio();

	boolean f = true;

    while(rs.next()) {
%>

							<option value="<%= rs.getString("id_Socio") %>" <%if(f){%> selected<%}%>><%= rs.getString("nombre") %></option>
<%
		f = false;
    }
%>