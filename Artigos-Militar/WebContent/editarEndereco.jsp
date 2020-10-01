<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
	//recebimento do conteudo JavaBeans encaminhado pelo Controller
 	String idendereco = (String) request.getAttribute("idendereco");
 	String tipo = (String) request.getAttribute("tipo");
 	String logradoura = (String) request.getAttribute("logradoura");
 	String numero = (String) request.getAttribute("numero");
 	String complemento = (String) request.getAttribute("complemento");
 	String bairro = (String) request.getAttribute("bairro");
 	String cep = (String) request.getAttribute("cep");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Endereço</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="frmEndereco" action="updateEnd2">
	<h2>Editar Endereco</h2>
		<table>
			<tr>
    			<td><input type="text" name="idendereco" value="<%=idendereco %>" id="Caixa2"readonly></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="tipo" value="<%=tipo %>" class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="logradoura" value="<%=logradoura %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="numero" value="<%=numero %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="complemento" value="<%=complemento %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="bairro" value="<%=bairro %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="cep" value="<%=cep %>"class="Caixa1"></td>
    		</tr>		   		
    	</table>
    	<input type="button" value="Salvar" onclick="validar()"class="Botao1">
    </form>
	<script src="validarEndereco.js"></script>
</body>
</html>