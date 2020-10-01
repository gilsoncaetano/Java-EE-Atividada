<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%
	//recebimento do conteúdo javaBeans encaminhado pelo (controller)
	String id = (String) request.getAttribute("id");
	String nome = (String) request.getAttribute("nome");
	String fone = (String) request.getAttribute("fone");
	String email = (String) request.getAttribute("email");
%>
<link rel="stylesheet" href="style.css">
<title>Agenda de contatos</title>
</head>
<body>
	<form name="frmContato" action="update2"><!-- (11) -->
	<h1>Editra Contato</h1>
		<table>
			<tr>
				<td><input type="text" name="id" value="<%=id %>" readonly id="caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" value="<%=nome %>" class="caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" value="<%=fone %>" class="caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" value="<%=email %>" class="caixa1"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" onclick="validar()" class="Botao1"><!-- (9) e (10) -->
	</form>
	<script src="validador.js"></script>

</body>
</html>