<%@page import="java.sql.ResultSet"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="curso" class="caracol.modelo.Curso" scope="page" />
<%
    ResultSet rs = curso.listar_curso();

    boolean f = true;

    while(rs.next()) {
%>

							<option value="<%= rs.getString("id_Curso") %>" <%if(f){%> selected<%}%>><%= rs.getString("nombre") %></option>
<%
		f = false;
    }
%>