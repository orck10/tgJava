<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.api.modelo.Profissional"%>
<%@page import="com.api.modelo.Crianca"%>
<%@page import="com.core.servico.ProfissionalServicoImple"%>
<%@page import="com.core.servico.TesteServicoImp"%>
<%@page import="com.core.servico.CriancaServicoImp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>

<%Profissional p = (Profissional)request.getAttribute("usuarioLogado");%>
<%Crianca c = (Crianca)request.getAttribute("crianca"); %>
<%TesteServicoImp teste = new TesteServicoImp(); %>

<%List<String> lista =  teste.resultados(c.getNome());%>

<%if(lista != null){%>

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
	border: 3px solid black;
}
</style>

<body>
	<br>
	<br>
	<div
		style="background: white; width: 80%; position: relative; left: 10%;">
		<br>
		<header>
			<h1 align="center">
				Resultado de
				<%=c.getNome()%></h1>
		</header>
		<br> <br>
		<table>
			<tr>
				<th>Tipo</th>
				<th>Pontos</th>
				<th>Resultado</th>
			</tr>
			<tr>
				<th>Padrão</th>
				<th><%=lista.get(0) %></th>
				<th><p id="p1"></p></th>
			</tr>
			<tr>
				<th>4 Movimentos</th>
				<th><%=lista.get(1) %></th>
				<th><p id="p2"></p></th>
			</tr>
			<tr>
				<th>5 Movimentos</th>
				<th><%=lista.get(2) %></th>
				<th><p id="p3"></p></th>
			</tr>
		</table>
		<br> <br>
	</div>
</body>
<script>
//scpit para mostar em forma de texto o resultado;
	var obj = {
		resultado: function(res) {
			if(res < 70){
				return "Muito Baixa";
			}else if(res >= 70 && res < 85){
				return "Baixa";
			}else if(res >= 85 && res < 115){
				return "Média";
			}else if(res >= 115 && res < 130){
				return "Alta";
			}else if(res >= 130){
				return "Muito Alta";
			}
			return "Não Valida";
		}
	}
	document.getElementById("p1").innerHTML = obj.resultado(<%=lista.get(0) %>);
	document.getElementById("p2").innerHTML = obj.resultado(<%=lista.get(1) %>);
	document.getElementById("p3").innerHTML = obj.resultado(<%=lista.get(2) %>);
</script>

</html>

<%}else{%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resusltados Teste</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body>
	<div>
		style="background: white; width: 80%; position: relative; left: 10%;">
		<br>
		<header>
			<h1 align="center">
				Não há resultado de
				<%=c.getNome()%>
			</h1>
		</header>
		<div>
			<form action="Autenticador.action" method="post">
				<input type="submit" value="Voltar">
			</form>
		</div>
	</div>
</body>
</html>
<%}%>