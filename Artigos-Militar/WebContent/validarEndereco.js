/**
 * Validação de Formulàrio de endereço
 * @author Gilson Caetano 
 */

function validar(){
	let tipo = frmEndereco.tipo.value
	let logradoura = frmEndereco.logradoura.value
	let numero = frmEndereco.numero.value
	let complemento = frmEndereco.complemento.value
	let bairro = frmEndereco.bairro.value
	let cep = frmEndereco.cep.value
		
	if(tipo == ""){
		alert('Preencha o campo Tipo')
		frmEndereco.tipo.focus()
		return false
	}else if(logradoura == ""){
		alert('Preencha o campo Logradoura')
		frmEndereco.logradoura.focus()
		return false
	}else if(numero == ""){
		alert('Preencha o campo Numero')
		frmEndereco.numero.focus()
		return false
	}else if(complemento == ""){
		alert('Preencha o campo Complemento')
		frmEndereco.complemento.focus()
		return false
	}else if(bairro == ""){
		alert('Preencha o campo bairro')
		frmEndereco.bairro.focus()
		return false
	}else if(cep == ""){
		alert('Preencha o campo Cep')
		frmEndereco.cep.focus()
		return false
	}else {
		document.forms["frmEndereco"].submit()
	}
	
}