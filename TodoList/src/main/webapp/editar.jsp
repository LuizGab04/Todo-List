<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editar task</title>
</head>
<body>
	<h1>Edite a Task</h1>
	<form name="formEditarTask" action="update">
		<input type="text" name="id" placeholder="id da task" readonly value="<%out.print(request.getAttribute("id"));%>">
		<input type="text" name="editaNomeTask" placeholder="nome da task">
		<input type="text" name="idUser" placeholder="dono da task" readonly value="<%out.print(request.getAttribute("idUser"));%>">
		<input type="button" value="Salvar" placeholder="Cadastrar"
			onclick="editarNovaTask()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>