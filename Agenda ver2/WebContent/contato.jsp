<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html >
<head>
	<meta charset="utf-8">
	<title>Agenda de contato</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="frmContato" action="insert">
	<h1>Novo Contato</h1>
		<table>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome" class="caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" placeholder="Fone" class="caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="Email" class="caixa1"></td>
			</tr>
		</table>
		<input type="button" value="Adicionar" onclick="validar()" class="Botao1">
	</form>
	<script src="validador.js"></script>
</body>
</html>