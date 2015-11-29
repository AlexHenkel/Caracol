<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="benef" class="caracol.modelo.Beneficiario" scope="page" />
<jsp:useBean id="cx" class="caracol.modelo.Conectar" scope="page" />
<%
	String opc = request.getParameter("op");

    String nombre = "";
    String direccion = "";
    String telefono = "";
    String email = "";

    int idBen;
    int idPer;

    if (opc == null) {
        opc = "";
    }
    if (request.getParameter("idBen") == null) {
        idBen = 0;
    }
    else {
        idBen = Integer.valueOf(request.getParameter("idBen"));
    }
    if (request.getParameter("idPer") == null) {
        idPer = 0;
    }
    else {
        idPer = Integer.valueOf(request.getParameter("idPer")); 
    }

    benef.setId_Beneficiario(idBen);
    benef.setId_Persona(idPer);

    ResultSet rsp = benef.buscar_beneficiario();

    while (rsp.next()) {
    	idPer = rsp.getShort(1);
        nombre = rsp.getString("nombre");
        direccion = rsp.getString("direccion");
        telefono = rsp.getString("telefono");
        email = rsp.getString("email");
    }

    ResultSet rs = benef.listar_beneficiario();

    int i = 0;

    while(rs.next()) {
%>

	<div class="modal fade modal-persona-<%= i %>" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content sign-up">
	    	<h2>Datos de <%if(opc==""){%><%= rs.getString("nombre") %><%}else{%><%= nombre%><%}%></h2>
			<ul class="<%if(opc!=""){%>hidden<%}%> modal-data">
		        <li>
		        	<b>Nombre:</b> 
		          	<span class="<%if(opc!="") {%>hidden<%}%>"><%= rs.getString("nombre") %></span> 
		        </li>
		        <li>
		          	<b>Dirección:</b> 
		          	<span class="<%if(opc!="") {%>hidden<%}%>"><%= rs.getString("direccion") %></span>
		        </li>
		        <li>
		          	<b>Teléfono:</b> 
		          	<span class="<%if(opc!="") {%>hidden<%}%>"><%= rs.getString("telefono") %></span>
		        </li>
		        <li>
		          	<b>Correo Electrónico:</b>
		          	<span class="<%if(opc!="") {%>hidden<%}%>"><%= rs.getString("email") %></span>
		        </li>
		    </ul>
		    <form id="benef-edit-form" class="signup-form <%if(opc==""){%>hidden<%}%>" action="cBeneficiario" method="POST" role="form">
		    	<b>Nombre:</b> 
	          	<input class="<%if(opc=="") {%>hidden<%}%> form-input" type="text" name="benefNombre" value="<%= nombre%>">
	          	<br>
	          	<b>Dirección:</b> 
				<input class="<%if(opc=="") {%>hidden<%}%> form-input" type="text" name="benefDireccion" value="<%= direccion%>">
				<br>
				<b>Teléfono:</b>
				<input class="<%if(opc=="") {%>hidden<%}%> form-input" type="text" name="benefTelefono" value="<%= telefono%>">
				<br>
				<b>Correo Electrónico:</b>
				<input class="<%if(opc=="") {%>hidden<%}%> form-input" type="text" name="benefEmail" value="<%= email%>">
				<br>
				<%if(opc.equals("up")){%>
	      	
		      	<input type="hidden" name="idPer" value="<%=idPer%>">
		      	<input type="hidden" name="op" value="up">
	            <input type="submit" class="btn-fill sign-up-btn w-150" name="update" value="Actualizar">

		      	<%}%>
			</form>
	      	<a href="?op=up&idBen=<%=rs.getString("id_Beneficiario")%>&idPer=<%=rs.getString("id_Persona")%>" class="button-edit <%if(opc!=""){%>hidden<%}%>">Editar</a>
	      	
	    </div>
	  </div>
	</div>

<%
        i++;
    }
    cx.desconectar();
%>