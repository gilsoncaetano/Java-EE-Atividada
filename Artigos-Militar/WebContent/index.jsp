<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.JavaBeans"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Artigos Militares Caça e Pesca</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h1>Artigos Militares Caça e Pesca</h1>

	<h1>Dados de Clientes</h1>
	<a href="clientes.jsp" class="Botao1">Novo Cadastro</a>
	<table id="estilo">
		<thead>
			<th>Id</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>RG</th>
			<th>Data Nascimento</th>
			<th>Sexo</th>
			<th>E-mail</th>
			<th>Telefone</th>
			<th>Acões</th>
		</thead>
		
		
		<tbody>
			<%
				DAO dao = new DAO();
			//"pedido" teste de comando de execução 
			ArrayList<JavaBeans> clientes = dao.listarClientes(); // (1) e (5)
			for (int i =0; i < clientes.size(); i++){
			%>	
			<tr>
				<td><%= clientes.get(i).getIdclientes()%></td>
				<td><%= clientes.get(i).getNome()%></td>
				<td><%= clientes.get(i).getCpf()%></td>
				<td><%= clientes.get(i).getRg()%></td>
				<td><%= clientes.get(i).getDatanascimento()%></td>
				<td><%= clientes.get(i).getSexo()%></td>
				<td><%= clientes.get(i).getEmail()%></td>
				<td><%= clientes.get(i).getTelefone()%></td>
				<!-- select -> requisição ao controller update (path) ?id (parâmetro) -->				
				<td><a href="update1?idclientes=<%= clientes.get(i).getIdclientes()%>"class="Botao1">Editar</a></td>			
				
			</tr>
			<%
			}
			%>
		</tbody>
		
	</table>

	<h1>Dados de Endereço</h1>
	<table id="estilo">
		<thead>
			<th>Id</th>
			<th>Tipo</th>
			<th>Endereço</th>
			<th>Numero</th>
			<th>Complemento</th>
			<th>Bairro</th>
			<th>CEP</th>
			<th>Acões</th>
			
		</thead>
			
			
		<tbody>
			<%
				DAO daoend = new DAO();
			//"pedido" teste de comando de execução 
			ArrayList<JavaBeans> endereco = daoend.listarEndereco(); // (1) e (5)
			for (int i =0; i < endereco.size(); i++){
			%>
		<tr>
		 	<td><%= endereco.get(i).getIdendereco()%></td>
			<td><%= endereco.get(i).getTipo()%></td>
			<td><%= endereco.get(i).getLogradoura()%></td>
			<td><%= endereco.get(i).getNumero()%></td>
			<td><%= endereco.get(i).getComplemento()%></td>
			<td><%= endereco.get(i).getBairro()%></td>
			<td><%= endereco.get(i).getCep()%></td>
			<!-- select -> requisição ao controller -->	
			<td><a href="updateEnd?idendereco=<%= endereco.get(i).getIdendereco()%>"class="Botao1">Editar</a><a href="delete2?idendereco=<%= endereco.get(i).getIdendereco()%>" id="botao2">Excluir</a></td>
		</tr>
		<%
		}
		%>
		
		<tbody>
	</table>
	
		
</body>
</html>