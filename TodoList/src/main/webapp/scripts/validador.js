/**
 * 
 */
function validar() {
	const senha = document.querySelector("input[name='senha']").value
	const repetirSenha = document.querySelector("input[name='confirmar']").value

	if (senha === '' || repetirSenha === '') {
		Swal.fire({
			icon: "error",
			title: "Oops...",
			text: "Os campos de senha não podem estar vazios!",
		});
		return;
	}

	if (senha !== repetirSenha) {
		alert('senhas não são iguais')
		return;
	}

	let nome = formCadastro.nome.value
	let email = formCadastro.email.value

	if (nome === "") {
		alert('preencha o campo nome')
		formCadastro.nome.focus()
		return false
	} else if (email === "") {
		alert('preencha o campo email')
		formCadastro.email.focus()
		return false
	} else {
		Swal.fire({
			title: "Drag me!",
			icon: "success",
			draggable: true
		});
		document.forms["formCadastro"].submit()
	}
}
//luiz@gmail.com
function logar() {
	let email = formLogin.loginEmail.value
	let senha = formLogin.loginSenha.value

	if (email === "") {
		alert('preencha o campo email')
		formLogin.email.focus()
		return false
	} else if (senha === "") {
		alert('preencha o campo email')
		formLogin.senha.focus()
		return false
	} else {
		document.forms["formLogin"].submit()
	}
}

function novaTask() {
	const nomeTask = document.querySelector("input[name='nomeTask']").value

	if (nomeTask === "") {
		alert('preencha o campo')
		return false
	} else {
		document.forms["formNovaTask"].submit()
	}
}

function editarNovaTask() {
	const nomeTask = document.querySelector("input[name='editaNomeTask']").value

	if (nomeTask === "") {
		alert('preencha o campo')
		return false
	} else {
		Swal.fire({
			title: "Drag me!",
			icon: "success",
			draggable: true
		});
		document.forms["formEditarTask"].submit()
	}
}
