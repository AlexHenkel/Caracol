<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="benef" class="caracol.modelo.Beneficiario" scope="page" />

<%
    ResultSet rs = benef.listar_beneficiario();

    int i = 0;

    while(rs.next()) {
%>

	<div class="modal fade modal-persona-<%= i %>" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <h2>Datos de <%= rs.getString("nombre") %></h2>
	      <ul>
	          <li><b>Nombre:</b> <%= rs.getString("nombre") %></li>
	          <li><b>Dirección:</b> <%= rs.getString("direccion") %></li>
	          <li><b>Teléfono:</b> <%= rs.getString("telefono") %></li>
	          <li><b>Correo Electrónico</b> <%= rs.getString("email") %></li>
	      </ul>
	    </div>
	  </div>
	</div>

<%
        i++;
    }
%>