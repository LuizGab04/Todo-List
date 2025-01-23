<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="/TodoListApp/css/styleMobile.css"
	media="screen and (max-width: 768px)">
<link rel="stylesheet" type="text/css" href="/TodoListApp/css/style.css"
	media="all">
<meta charset="UTF-8">
<title>TODO-List</title>
</head>
<body>
	<header>
		<div class="container text-center">
			<div class="row" id="container-header">
				<div class="col" id="nome-todolist">
					<p>
						<strong>TODO-List</strong>
					</p>
				</div>
				<div class="col" id="frase-header">
					<p>
						<strong>Transforme suas ideias em ação!</strong>
					</p>
				</div>
			</div>
		</div>
	</header>
	<main>
		<div id="container-main">
			<div id="frase-main">
				<h1>Organize seu dia de forma simples e eficaz.</h1>
				<p>Crie, gerencie e conclua suas tarefas com facilidade</p>
			</div>
			<div id="botoes-cadastro">
				<a href="register.jsp" class="btn btn-primary">Cadastrar</a> <a
					href="login.jsp" class="btn btn-primary">Login</a>
			</div>
		</div>
	</main>
	<footer>
		<div id="container-footer">
			<div id="criador">
				<p>Criador: Luiz Gabriel Furtado Silva</p>
			</div>
			<div id="links">
				<a id="insta" href="https://www.instagram.com/_luiz.g__/"
					target="_blank"><i class="px-1 bi bi-instagram"></i></a> <a
					id="linke"
					href="https://www.linkedin.com/in/luiz-gabriel-4b38a726a/"
					target="_blank"><i class="px-1 bi bi-linkedin"></i></a>
			</div>
		</div>
	</footer>
</body>
</html>