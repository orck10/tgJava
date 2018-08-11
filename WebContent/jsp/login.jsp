<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String contexto = request.getContextPath();
    if (!contexto.equals(""))
        contexto = contexto + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">
        <title>Tg Torre</title>
    </head>
    <body>
    	<center><table>
	        <form class="baseForm" action="Autenticador.action" method="post">
	            <label class="formLabel">
	                Nome de Usuário:
	                <br/>
	                <input name="nomeUsuario" type="text" required class="formInput formTextInput">
	                <br/>
	            </label>
	            <label class="formLabel">
	                Senha:
	                <br/>
	                <input name="senha" type="password" required class="formInput formTextInput">
	                <br/>
	                <br/>
	           </label>
	                <input type="submit" value="Entrar" class="submitButton">
	        </form>
	        <br/>
	        <br/>
	        <a href="jsp/cadastrarProfissional.jsp">Cadastar Profissional</a>
        </table></center>     
    </body>
</html>
