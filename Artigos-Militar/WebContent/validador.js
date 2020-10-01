/**
 * Validação de Formulàrio
 * @author Gilson Caetano 
 */

function validar(){
	let nome = frmCliente.nome.value
	let cpf = frmCliente.cpf.value
	let rg = frmCliente.rg.value
	let datanascimento = frmCliente.datanascimento.value
	let sexo = frmCliente.sexo.value
	let email = frmCliente.email.value
	let telefone = frmCliente.telefone.value
	//let idclientes = frmCliente.idclientes.value
	
	
	if (nome == ""){
		alert('Preencha o campo Nome')
		frmCliente.nome.focus()
		return false
	}else if(cpf ==""){
		alert('Peencha o campo CPF')
		frmCliente.cpf.focus()
		return false
	}else if(rg == ""){
		alert('Preencha o campo RG')
		frmCliente.rg.focus()
		return false
	}else if(datanascimento == ""){
		alert('Preencha o campo Data Nascimento')
		frmCliente.datanascimento.focus()
		return false
	}else if(sexo == ""){
		alert('Preencha o campo Sexo')
		frmCliente.sexo.focus()
		return false
	}else if(email == ""){
		alert('Preencha o campo E-mail')
		frmCliente.email.focus()
		return false
	}else if(telefone == ""){
		alert('Preencha o campo Telefone')
		frmCliente.telefone.focus()
		return false
	}else {
		document.forms["frmCliente"].submit()
	}
	
}