<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="curso" class="caracol.modelo.Curso" scope="page" />
<%
    ResultSet rs = curso.listar_curso();

    int cat = 0; // Contador de categoria

    while(rs.next()) {
    	if(rs.getInt("categoria") != cat) {
    		cat = rs.getInt("categoria");
    		if(cat != 1) {
%>
		</div>
	  </div>
	</div>
<%
			}
%>
	<div class="modal fade modal-curso-<%= cat %>" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content sign-up">
	    	<h2>Cursos de <%= curso.nombreCategoria(cat) %></h2>
<%
		}
%>
			<ul class="modal-data cursos-list">
		        <li class="item-title">
		          	<h4><%= rs.getString("nombre") %></h4> 
		        </li>
		        <li class="item-description">
		          	<span>
		          		<i><%= rs.getString("descripcion") %></i>
		          	</span> 
		        </li>
		        <li class="">
		        	<b>Incubadora Social:</b> 
		          	<span><%= rs.getString("incubadora_social") %></span> 
		        </li>
		        <li class="">
		        	<b>Espacio Formativo:</b> 
		          	<span><%= rs.getString("espacio_formativo") %></span> 
		        </li>
		    </ul>
<%
	}
%>
		</div>
	  </div>
	</div>
