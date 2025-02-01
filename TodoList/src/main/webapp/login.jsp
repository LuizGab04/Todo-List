<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<h1>Página de Login</h1>
	<form name="formLogin" action="logar">
	<input type="email" class="form-control" name="loginEmail" placeholder="email">
	<input type="password" class=" form-control" name="loginSenha" placeholder="senha">
	<input type="button" class="btn btn-primary" value="login" placeholder="login" onclick="logar()">
	</form>
	
	<script src="scripts/validador.js"></script>
	
</body>
</html>