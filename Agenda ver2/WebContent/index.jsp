<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.javaBeans"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="contato.jsp" class="Botao1">Novo contato</a>
	<table id="estilo">
		<thead>
			<th>Id</th>
			<th>Nome</th>
			<th>Fone</th>
			<th>E-mail</th>
			<th>Ações</th>
		</thead>
		<tbody>
		
		<%
		//objeto dao criado para acessar os métodos da classe DAO
		DAO dao = new DAO();
		//teste de comando de execução
		ArrayList<javaBeans> contatos = dao.listarContatos(); // Processo "1" Tambem e Passo "5" pedir Para executa o metodo
		//laço for para percorrer o ArrayList
		for (int i =0; i < contatos.size(); i++) {	
		%>
		
		<tr>
			<td><%=contatos.get(i).getId()%></td>
			<td><%=contatos.get(i).getNome()%></td>
			<td><%=contatos.get(i).getFone()%></td>
			<td><%=contatos.get(i).getEmail()%></td>
			<!-- select(1) -> requisição ao Controller -->
			<td><a href="update1?id=<%=contatos.get(i).getId()%>" class="Botao1"> Editar </a><a href="delete?id=<%=contatos.get(i).getId()%>" id="botao2"> Excluir </a></td>
			
		</tr>
		
		<%
		}
	    %>
		</tbody>
	</table>
	

</body>
</html>