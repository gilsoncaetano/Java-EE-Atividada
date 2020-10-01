<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

 <%
 	// recebimento do conteudo JavaBeans encaminhado pelo Controller
 	String idclientes = (String) request.getAttribute("idclientes");	
 	String idendereco = (String) request.getAttribute("idendereco");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Usuario</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="frmEndereco" action="insertUsu">
	<h2>Cadastrar Endereco</h2>			
    	<table>
    		<tr>
    			<td><input type="text" name="idclientes" value="<%=idclientes %>"class="Caixa2">
    			</td>
    		</tr>
    		<tr>
    			<td><input type="text" name="tipo" placeholder="Tipo"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="logradoura" placeholder="logradoura"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="numero" placeholder="Numero"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="complemento" placeholder="Complemento"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="bairro" placeholder="Bairro"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="cep" placeholder="CEP"class="Caixa1"></td>
    		</tr>	
    	</table>
    	<input type="button" value="Cadastrar" onclick="validar()"class="Botao1">
    </form>
	<script src="validarCadastroUsu.js"></script>
</body>
</html>