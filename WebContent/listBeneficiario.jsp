<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="benef" class="caracol.modelo.Beneficiario" scope="page" />

<%
    ResultSet rs = benef.listar_beneficiario();

    int i = 0;

    while(rs.next()) {
%>

							<li><a data-toggle="modal" data-target=".modal-persona-<%= i %>">
									<%= rs.getString("nombre") %>
								</a>
							</li>

<%
        i++;
    }
%>