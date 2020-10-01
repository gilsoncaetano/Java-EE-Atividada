/**
 * Validação de Formulàrio
 * @author Gilson Caetano 
 */

function validar(){
	let senha = frmUsuario.senha.value
	let foto = frmUsuario.foto.value
	
	if(senha == ""){
		alert('Preencha o campo Senha')
		frmUsuario.senha.focus()
		return false
	}else if(foto == ""){
		alert('Preencha o campo foto')
		frmUsuario.foto.focus()
		return false
	}else {
		document.forms["frmUsuario"].submit()
	}
	
}