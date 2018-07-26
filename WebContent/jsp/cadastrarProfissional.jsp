<%@page import="com.api.modelo.Profissional" %>
<%@page import="com.core.servico.ProfissionalServicoImple" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Cadastrar Profissional</title>
        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../assets/css/main.css" />
		<noscript><link rel="stylesheet" href="../assets/css/noscript.css" /></noscript>
    </head>
	
	<body>
		<article id="contact" class="panel">
					<header>
						<h2>Adicionar usuário</h2>
					</header>
					
					<form action="../Cadastra.action" method="post">
						<div>
							<div class="row">
								<div class="6u 12u$(mobile)">
									<input type="text" name="nome" placeholder="Nome" />
								</div>
								
								<div class="6u$ 12u$(mobile)">
									<input type="text" name="email" placeholder="E-mail" />
								</div>
								
								<div class="12u$">
									<input type="password" name="senha" placeholder="Senha" />
								</div>
								
								<div class="12u$">
									<input type="submit" value="Cadastrar" />
								</div>
							</div>
						</div>
					</form>
					<form class="baseForm" action="../Sair.action" method="get">
						<input type="submit" value="Sair" class="submitButton">  
					</form>
				</article>
	</body>
</html>