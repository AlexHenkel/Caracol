<%@page import="java.sql.ResultSet"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="grupo" class="caracol.modelo.Grupo" scope="page" />
<%
	String opc = request.getParameter("op");

	String periodoA = request.getParameter("pa");
	
	if(periodoA == null) {
		periodoA = (String) sesionOK.getAttribute("periodoA");
	}

	if (opc == null) {
        opc = "";
    }
%>
<%@ include file="listPeriodoGrupo.jsp" %>
							<table class="table table-hover tablesaw tablesaw-stack" data-tablesaw-mode="stack">
								<thead>
								    <th>Curso</th>
								    <th>Cupo Beneficiarios</th>
								    <th>Cupo Alumnos TEC</th>
								    <th>Periodo</th>
								    <th>Horario Beneficiarios</th>
								    <th>Horario Alumnos</th>
								    <th>Socio Formador</th>
								</thead>
								<tbody>
<%
	grupo.setId_Periodo(Integer.parseInt(periodoA));

    ResultSet rs = grupo.listar_grupoPeriodo();

    while(rs.next()) {
	
%>
									<tr>
										<td><%= rs.getString("CursoN")%></td>
										<td><%= rs.getString("cupo_beneficiarios")%></td>
										<td><%= rs.getString("cupo_alumnos_tec")%></td>
										<td><%= rs.getString("periodo")%></td>
										<td><%= rs.getString("horario_beneficiarios")%></td>
										<td><%= rs.getString("horario_alumnos_tec")%></td>
										<td><%= rs.getString("SocioN")%></td>
									</tr>					                                                           
<%
    }
%>
								</tbody>
							</table>