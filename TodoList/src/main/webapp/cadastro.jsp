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
	<h1>Agenda de Contatos</h1>
	<form name="formCadastro" action="insert">
		<input type="text" class="form-control" name="nome" placeholder="Nome">
		<input type="email" class="form-control" name="email"
			placeholder="Email"> <input type="password"
			class="form-control" name="senha" placeholder="Senha"> <input
			type="password" class="form-control" name="confirmar"
			placeholder="Cofirmar Senha"> <input type="button"
			value="Cadastrar" class="btn btn-primary" placeholder="Cadastrar"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>