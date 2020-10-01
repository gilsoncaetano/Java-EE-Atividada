<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
//recebimento do conteudo JavaBeans encaminhado pelo Controller
	//String idclientes = (String) request.getAttribute("idclientes");
	//String idendereco = (String) request.getAttribute("idclientes");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Clube de Tiro Caça e Pesca</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<form name="frmCliente" action="insert">
	
		<h2>Novo Cliente</h2>
    	<table> 
    		<tr>
    			<td><input type="text" name="nome" placeholder="Nome" class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="cpf" placeholder="CPF"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="rg" placeholder="RG"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="datanascimento" placeholder="Data Nascimento"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="sexo" placeholder="Sexo"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="email" placeholder="E-Mail"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="telefone" placeholder="Telefone"class="Caixa1"></td>
    		</tr>
    	</table>
    	      	
    	<input type="button" value="Cadastrar" onclick="validar()"class="Botao1">
        	
    </form>
		
	<script src="validador.js" ></script>
</body>
</html>