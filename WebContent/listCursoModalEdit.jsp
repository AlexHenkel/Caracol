<%@page import="java.sql.ResultSet"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="curso" class="caracol.modelo.Curso" scope="page" />
<jsp:useBean id="cx" class="caracol.modelo.Conectar" scope="page" />
<%
	String opc = request.getParameter("op");

    String nombre = "";
    String categoria = "";
    String descripcion = "";
    String incubadora_social = "";
    String espacio_formativo = "";

    int idCur;

    if (opc == null) {
        opc = "";
    }
    if (request.getParameter("idCur") == null) {
        idCur = 0;
    }
    else {
        idCur = Integer.valueOf(request.getParameter("idCur"));
    }

    curso.setId_Curso(idCur);

    ResultSet rsp = curso.buscar_curso();

    while (rsp.next()) {
    	nombre = rsp.getString("nombre");
        categoria = rsp.getString("categoria");
        descripcion = rsp.getString("descripcion");
        incubadora_social = rsp.getString("incubadora_social");
        espacio_formativo = rsp.getString("espacio_formativo");
    }
%>
	<div class="modal fade modal-curso-edit" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content sign-up">
	    	<h2>Editar de <%= nombre %></h2>

		    <form id="curso-edit-form" class="signup-form" action="cCurso" method="POST" role="form">
		    	<b>Nombre:</b> 
	          	<input class="form-input" type="text" name="courseName" value="<%= nombre%>">
	          	<br>
	          	<b>Descripción:</b> <br>
				<textarea class="form-input" type="text" name="courseDescription"><%= descripcion%></textarea>
				<br>
				<div class="material">
                    <select name="courseCategory" placeholder="Categoría">
                        <option value="1" selected>Educación</option>
                        <option value="2">Tecnología</option>
                        <option value="3">Emprendimiento</option>
                        <option value="4">Arte</option>
                        <option value="5">Desarrollo Humano</option>
                        <option value="6">Conciencia Cívica</option>
                        <option value="7">Ciencias</option>
                        <option value="8">Idiomas</option>
                    </select>
                </div>
                <br>
				<b>Incubadora Social:</b>
				<input class="form-input" type="text" name="courseIncubadora" value="<%= incubadora_social%>">
				<br>
				<b>Espacio Formativo:</b>
				<input class="form-input" type="text" name="courseEspacio" value="<%= espacio_formativo%>">
				<br>
	      	
		      	<input type="hidden" name="idCur" value="<%=idCur%>">
		      	<input type="hidden" name="op" value="up">
	            <input type="submit" class="btn-fill sign-up-btn w-150" name="update" value="Actualizar">

			</form>	      	
	    </div>
	  </div>
	</div>

<%
    cx.desconectar();
%>