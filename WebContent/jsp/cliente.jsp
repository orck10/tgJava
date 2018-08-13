<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.api.modelo.Profissional" %>
<%@page import="com.api.modelo.Crianca" %>
<%@page import="com.core.servico.ProfissionalServicoImple" %>
<%@page import="com.core.servico.CriancaServicoImp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>

<%Profissional p = (Profissional)request.getAttribute("usuarioLogado");%>
<%Crianca c = (Crianca)request.getAttribute("cri"); %>

<html>
	<head>
		<title>Cliente</title>
        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
    </head>
	
	<body>
		<br>
		<br>
		<div style="background:white; width:80%;position: relative; left: 10%;">
			<br>
			<header>
				<h1 align="center">Cliente</h1>
			</header>
			<div>
				<form action="ResultadosTeste.action" method="post" align="center">
		        	<input name="nomeUsuario" type="hidden" value="<%=p.getNome()%>" />
		            <input name="id" type="hidden" value="<%=c.getId().toString()%>" />
		            <input type="submit" value="Resultados de <%=c.getNome()%>" class="submitButton">  
		    	</form>
			</div>
			<br/>
			<form action="AtualicarCliente.action" method="post">
						<div>
							<div align="center">
								<input name="nomeUsuario" type="hidden" value="<%=p.getNome()%>" />
								<input name="id" type="hidden" value="<%=c.getId()%>">
								<div class="6u$ 12u$(mobile) cell">
									<input type="text" name="nome" placeholder="Nome" value="<%=c.getNome()%>"/>
								</div>
								<br/>
								<div class="6u$ 12u$(mobile) cell">
									Data de Nascimento
									<br>
									<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");%>
									<input type="date" name="nasc" placeholder="Nascimento" value="<%=sdf.format(c.getCriancaNasc().getTime())%>"/>
								</div>
								<br/>
								<div class="6u$ 12u$(mobile) cell">
									<input type="radio" name="sexo" value="m" <%if(c.getCriancaSexo().equals("m")){%>checked<%}%>>Masculino
									<input type="radio" name="sexo" value="f"<%if(c.getCriancaSexo().equals("f")){%>checked<%}%>>Feminino
								</div>
								<br/>
								<div class="6u$ 12u$(mobile) cell">
									<input type="submit" value="Atualizar" />
								</div>
								<br/>
							</div>
						</div>
			</form>
		</div>
	</body>
	<script>
	</script>
</html>