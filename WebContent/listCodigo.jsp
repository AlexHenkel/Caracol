<%@page import="java.sql.ResultSet"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="codigo" class="caracol.modelo.Codigo" scope="page" />
<%
	String opc = request.getParameter("op");

	if (opc == null) {
        opc = "";
    }

    ResultSet rs = codigo.listar_codigo();

    char c = '0';

    String p = "";

    while(rs.next()) {
    	if(rs.getString("permiso").charAt(0) != c) {
    		c = rs.getString("permiso").toUpperCase().charAt(0);
%>
							<div class="letter">
<%
			switch (c) {
				case '1':
					p = "Administrador";
					break;
				case '2':
					p = "Socio Formador";
					break;
				case '3':
					p = "Tutor";
					break;
			}
%>
								<%= p %>
							</div>
<%
		}
%>
							<div class="row">
								<div class="col-xs-12 col-sm-8 col-md-6">
									<span class="list-item"><%= rs.getString("codigo") %></span>
								</div>
								<div class="col-xs-12 col-sm-3 col-md-offset-3 col-md-3">
									<a href="cCodigo?op=del&cod=<%=rs.getString("codigo")%>" class="button-delete">Eliminar</a>
								</div>
							</div>
<%
    }
%>