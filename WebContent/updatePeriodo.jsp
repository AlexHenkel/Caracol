<%@page import="java.sql.ResultSet"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="periodo" class="caracol.modelo.Periodo" scope="page" />
<%
    ResultSet rs = periodo.listar_periodo();

    boolean f = true;

    while(rs.next()) {
%>

							<option value="<%= rs.getString("id_Periodo") %>" <%if(f){%> selected<%}%>><%= rs.getString("periodo") %></option>
<%
		f = false;
    }
%>