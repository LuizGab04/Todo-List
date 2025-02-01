<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="model.JavaBeansTasks"%>
<%@ page import="java.util.ArrayList"%>
<%
String usuario = (String) session.getAttribute("sessaoEmail");
if (usuario == null) {
	response.sendRedirect("login.jsp");
} else {
}
%>
<%
ArrayList<JavaBeansTasks> lista = (ArrayList<JavaBeansTasks>) request.getAttribute("tasks");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>BEM VINDO A SUA TODOLIST</title>
</head>
<body>
	<h1>Tasks</h1>
	<a type="button" href="adicionar" class="btn btn-success">NOVO</a>
	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome da Task</th>
				<th>ID do Usuario</th>
				<th>opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getTaskName()%></td>
				<td><%=lista.get(i).getUser_id()%></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>"
					class="btn btn-primary">Editar</a> <a href="javascript: confirmar(<%=lista.get(i).getId()%>)"
					class="btn btn-danger">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="logout" class="btn btn-warning">DESLOGAR</a>
	<script src="scripts/confirmar.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>