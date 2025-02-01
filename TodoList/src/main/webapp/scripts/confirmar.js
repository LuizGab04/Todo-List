function confirmar(id) {

	// Usando SweetAlert para confirmação
	Swal.fire({
		customClass: {
			confirmButton: "btn btn-danger",
			cancelButton: "btn btn-secondary"
		},
		title: 'Tem certeza?',
		text: "Você não poderá reverter essa ação!",
		icon: 'warning',
		showCancelButton: true,
		cancelButtonText: 'Cancelar',
		confirmButtonText: 'Sim, excluir!',
		reverseButtons: false
	}).then((result) => {
		// Se o usuário clicar em "Sim, excluir!"
		if (result.isConfirmed) {
			// Redirecionando para a URL de exclusão
			window.location.href = "delete?id=" + id;
		}
	});
}


