/**
 * Validação de Formulàrio de cliente
 * @author Gilson Caetano 
 */

function validar(){
	let datanascimento = frmvCliente.datanascimento.value
	let sexo = frmvCliente.sexo.value
	let email = frmvCliente.email.value
	let telefone = frmvCliente.telefone.value
	
	if(datanascimento == ""){
		alert('Preencha o campo Data Nascimento')
		frmvCliente.datanascimento.focus()
		return false
	}else if(sexo == ""){
		alert('Preencha o campo Sexo')
		frmvCliente.sexo.focus()
		return false
	}else if(email == ""){
		alert('Preencha o campo E-mail')
		frmvCliente.email.focus()
		return false
	}else if(telefone == ""){
		alert('Preencha o campo Telefone')
		frmvCliente.telefone.focus()
		return false
	}else {
		document.forms["frmvCliente"].submit()
	}
	
}