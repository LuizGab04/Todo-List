<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Criar task</title>
</head>
<body>
	<h1>Crie uma Task</h1>
	<form name="formNovaTask" action="novaTask">
		<input type="text" class=" form-control" name="nomeTask"
			placeholder="nome da task"> <input type="button"
			class="btn btn-success" value="Adicionar" placeholder="Cadastrar"
			onclick="novaTask()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>