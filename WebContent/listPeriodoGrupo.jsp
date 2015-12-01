<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="periodo" class="caracol.modelo.Periodo" scope="page" />
<%
    ResultSet res = periodo.listar_periodo();

    boolean f = true;

%>
						<form class="signup-form" action="cPeriodo" method="POST" role="form">
	                        <div class="form-hidden">
	                            <h4>Seleccion Periodo</h4>
	                            <div class="material">
	                                <select name="periodoActual" placeholder="Periodo Actual">
<%
    while(res.next()) {
%>
										<option value="<%= res.getString("id_Periodo") %>" <%if(f){%> selected<%}%>><%= res.getString("periodo") %></option>
<%
		f = false;
    }
%>
									</select>
	                            </div>
	                            <br>
	                            <input type="hidden" name="op" value="bu">
	                            <input type="submit" class="btn-fill sign-up-btn w-397" name="register" value="Buscar">
	                        </div>
	                    </form>
