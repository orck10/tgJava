<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.api.modelo.Profissional" %>
<%@page import="com.api.modelo.Crianca" %>
<%@page import="com.core.servico.ProfissionalServicoImple" %>
<%@page import="com.core.servico.CriancaServicoImp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>

<%Profissional p = (Profissional)request.getAttribute("usuarioLogado");%>
<%Crianca c = (Crianca)request.getAttribute("crianca"); %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Resusltados Teste</title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	
	<style>
		table {
		    border-collapse: collapse;
		    margin-left: 10%;
		    width: 80%;
		}
		
		table, td, th {
		    border: 3px solid black ;
		}
	</style>
	
	<body>
		<br>
		<br>
		<div style="background:white; width:80%;position: relative; left: 10%;">
			<br>
			<header>
				<h1 align="center">Resultado de <%=c.getNome()%></h1>
			</header>
			<br>
			<br>
				<table>
					<tr>
						<th>
							Pontos
						</th>
						<th>
							Resultado
						</th>
					</tr>
					<tr>
						<th>
							180
						</th>
						<th>
							Muito Alto
						</th>
					</tr>
				</table>
			<br>
			<br>
		</div>
	</body>
</html>