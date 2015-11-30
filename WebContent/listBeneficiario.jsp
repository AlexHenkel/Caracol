<%@page import="java.sql.ResultSet"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="benef" class="caracol.modelo.Beneficiario" scope="page" />
<%
	String opc = request.getParameter("op");

	if (opc == null) {
        opc = "";
    }

    ResultSet rs = benef.listar_beneficiario();

    int i = 0;

    char c = '0';

    while(rs.next()) {
    	if(rs.getString("nombre").toUpperCase().charAt(0) != c) {
    		c = rs.getString("nombre").toUpperCase().charAt(0);
%>
							<div class="letter">
								<%= c %>
							</div>
<%
		}
%>
							<div class="row" id="b-<%= i %>">
								<div class="col-xs-12 col-sm-8 col-md-6">
									<a data-toggle="modal" data-target=".modal-persona-<%= i %>">
										<%= rs.getString("nombre") %>
									</a>
								</div>
								<div class="col-xs-12 col-sm-3 col-md-offset-3 col-md-3">
									<a href="cBeneficiario?op=del&idBen=<%=rs.getString("id_Beneficiario")%>&idPer=<%=rs.getString("id_Persona")%>" class="button-delete">Eliminar</a>
								</div>
								
							</div>
<%
        i++;
    }
%>