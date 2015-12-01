<%@page import="java.sql.ResultSet"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="periodo" class="caracol.modelo.Periodo" scope="page" />
<%
	String opc = request.getParameter("op");

	if (opc == null) {
        opc = "";
    }

    ResultSet rs = periodo.listar_periodo();

    char c = '0';

    String p = "";

    while(rs.next()) {
%>
							<div class="row">
								<div class="col-xs-12 col-sm-8 col-md-6">
									<span class="list-item"><%= rs.getString("periodo") %></span>
								</div>
								<div class="col-xs-12 col-sm-3 col-md-offset-3 col-md-3">
									<a href="cCodigo?op=del&per=<%=rs.getString("id_Periodo")%>" class="button-delete">Eliminar</a>
								</div>
							</div>
<%
    }
%>