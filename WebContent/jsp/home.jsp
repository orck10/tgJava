<%@page import="com.api.modelo.Profissional"%>
<%@page import="com.api.modelo.Crianca"%>
<%@page import="com.api.modelo.Teste"%>
<%@page import="com.core.servico.ProfissionalServicoImple"%>
<%@page import="com.core.servico.CriancaServicoImp"%>
<%@page import="com.core.servico.TesteServicoImp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>

<html>
<head>
<title>Home Page</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>

<body>
	<!-- Wrapper-->
	<div id="wrapper">
		<!-- Nav -->
		<nav id="nav">
			<a href="#me" class="icon fa-home active"><span>Home</span></a> <a
				href="#work" class="icon fa-list-alt"><span>Clientes</span></a> <a
				href="#contact" class="icon fa-plus-circle"><span>Adicionar</span></a>
		</nav>

		<!-- Main -->
		<div id="main">
			<!-- Me -->
			<article id="me" class="panel">
				<header>
					<h1>Olá</h1>
					<p>
						<%Profissional p = (Profissional)request.getAttribute("usuarioLogado"); %>
						<%= p.getNome() %>
					</p>
				</header>

				<form class="baseForm" action="Sair.action" method="get">
					<input type="submit" value="Sair" class="submitButton">
				</form>
			</article>

			<!-- Work -->
			<article id="work" class="panel">
				<header>
					<h2>Clientes</h2>
				</header>

				<p>Lista de clientes.</p>

				<section>
					<div class="row">
						<div class="4u 12u$(mobile)">
							<%TesteServicoImp servico = new TesteServicoImp();%>
							<%CriancaServicoImp c1 = new CriancaServicoImp(); %>
							<%for(Teste t: servico.findProficinal(p.getProfId())){ %>
							<%Crianca c = new Crianca(); %>
							<%c = c1.findById(t.getCriancaId());%>
							<div>
								<form action="TelaDeCliente.action" method="post"
									name="subCli<%=c.getId()%>">
									<input type="hidden" name="id" value=<%=c.getId()%>> <input
										type="hidden" name="prof" value=<%=p.getNome()%>>
								</form>
							</div>
							<a href="javascript:document.subCli<%=c.getId()%>.submit()">Nome:<%=c.getNome()%></a>
							<form action="RemoverCrianca.action" method="post">
								<input name="nomeUsuario" type="hidden" value="<%=p.getNome()%>" />
								<input name="id" type="hidden" value="<%=c.getId().toString()%>" />
								<input type="submit" value="Deletar <%=c.getNome()%>"
									class="submitButton">
							</form>
							<%}%>
						</div>
					</div>
				</section>
			</article>

			<!-- Contact -->
			<article id="contact" class="panel">
				<header>
					<h2>Adicionar Clientes</h2>
				</header>

				<form action="CadastrarCrianca.action" method="post">
					<div>
						<div>
							<input name="nomeUsuario" type="hidden" value="<%=p.getNome()%>" />
							<input name="idUser" type="hidden" value="<%=p.getProfId()%>">
							<div>
								<input type="text" name="nome" placeholder="Nome" />
							</div>
							<br /> <br />
							<div>
								Data de Nascimento <br /> <input type="date" name="nasc"
									placeholder="Nascimento" />
							</div>
							<br />
							<div>
								<input type="radio" name="sexo" value="m">Masculino <input
									type="radio" name="sexo" value="f">Feminino
							</div>
							<br />
							<div>
								<input type="submit" value="Cadastrar" />
							</div>
						</div>
					</div>
				</form>

			</article>
		</div>

		<!-- Footer -->
		<div id="footer">
			<ul class="copyright">
		</div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/skel-viewport.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
</body>
</html>