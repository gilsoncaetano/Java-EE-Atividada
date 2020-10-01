<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
//recebimento do conteudo JavaBeans encaminhado pelo Controller
	String idusuario = (String) request.getAttribute("idusuario");
	String usuario = (String) request.getAttribute("usuario");
	String senha = (String) request.getAttribute("senha");
	String foto = (String) request.getAttribute("foto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Usuario</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="frmUsuario" action="updateUsu2">
	<h2>Editar Usuario</h2>
			<table>
    		<tr>
    			<td><input type="text" name="idusuario" value="<%=idusuario %>" id="Caixa2"readonly></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="usuario" value="<%=usuario %>"readonly class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="senha"value="<%=senha %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="foto" value="<%=foto %>"class="Caixa1"></td>
    		</tr>
    		
    	</table>
    	<input type="button" value="Salvar" onclick="validar()"class="Botao1">
    </form>
	<script src="validarUsuario.js"></script>
</body>
</html>