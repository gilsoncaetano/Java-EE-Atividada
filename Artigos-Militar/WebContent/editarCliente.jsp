<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
 	// recebimento do conteudo JavaBeans encaminhado pelo Controller
 	String idclientes = (String) request.getAttribute("idclientes");
 	String nome = (String) request.getAttribute("nome");
 	String cpf = (String) request.getAttribute("cpf");
 	String rg = (String) request.getAttribute("rg");
 	String datanascimento = (String) request.getAttribute("datanascimento");
 	String sexo = (String) request.getAttribute("sexo");
 	String email = (String) request.getAttribute("email");
 	String telefone = (String) request.getAttribute("telefone");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Cliente</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<form name="frmvCliente" action="update2">
	
		<h2>Editar Cliente</h2>
    		<table> 
    		<tr>
    			<td><input type="text" name="idclientes" value="<%=idclientes %>" id="Caixa2" readonly ></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="nome"value="<%=nome %>" class="Caixa1" readonly></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="cpf"value="<%=cpf %>" class="Caixa1" readonly></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="rg"value="<%=rg %>" class="Caixa1" readonly></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="datanascimento" value="<%=datanascimento %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="sexo" value="<%=sexo %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="email"value="<%=email%>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="telefone"value="<%=telefone %>"class="Caixa1"></td>
    		</tr>
    	</table>
    	<input type="button" value="Salvar" onclick="validar()"class="Botao1">
    </form>
	<script src="validarCliente.js"></script>
</body>
</html>