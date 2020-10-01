package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/*** Conexão com banco de dados ***/
	// Parâmetros de conexão
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/dbclubetiro?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "";

	// Método de conexão
		//Passo "5" ***/
		private Connection conectar() {
			Connection con = null;
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			return con;
		}
		/*** CRUD ***/
		/* CRUD - Create cliente */
		public void novoCliente(JavaBeans cliente) {
			// Criar a query (comando sql)
			String create = "insert into clientes(nome, cpf, rg,datanascimento, sexo, email, telefone) values (?,?,?,?,?,?,?)";
			try {
				//Abrir conexão com Banco
				Connection con = conectar();
				// Prepara a query
				PreparedStatement pst = con.prepareStatement(create);
				//substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
				pst.setString(1, cliente.getNome());
				pst.setString(2, cliente.getCpf());
				pst.setString(3, cliente.getRg());
				pst.setString(4, cliente.getDatanascimento());
				pst.setString(5, cliente.getSexo());
				pst.setString(6, cliente.getEmail());
				pst.setString(7, cliente.getTelefone());
				//Executa a query (comando sql)
				pst.executeUpdate();
				// IMPORTANTE !!! fecha a conexão com banco de dados
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		/* CRUD - Create Endereço*/
		public void novoEndereco(JavaBeans endereco) {
			// Criar a query (comando sql)
			String create = "insert into endereco(tipo, logradoura, numero, complemento,bairro, cep, idclientes) values (?,?,?,?,?,?,?)";
			try {
				//Abrir conexão com Banco
				Connection con = conectar();
				// Prepara a query
				PreparedStatement pst = con.prepareStatement(create);
				//substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
				
				pst.setString(1, endereco.getTipo());
				pst.setString(2, endereco.getLogradoura());
				pst.setString(3, endereco.getNumero());
				pst.setString(4, endereco.getComplemento());
				pst.setString(5, endereco.getBairro());
				pst.setString(6, endereco.getCep());
				pst.setString(7, endereco.getIdclientes());
								
				//Executa a query (comando sql)
				pst.executeUpdate();
				// IMPORTANTE !!! fecha a conexão com banco de dados
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/*  CRUD - Read cliente*/
		// método com retorno usando oArryList ligado ao JavaBeans
		public ArrayList<JavaBeans> listarClientes(){
			// criar um vetor dinamico para receber as variaveis, que serão armazenada em JavaBeans 
			 ArrayList<JavaBeans> clientes = new ArrayList<>();
			//query
			String read = "select \r\n" + 
					"cl.idclientes,\r\n" + 
					"cl.nome,\r\n" + 
					"cl.cpf,\r\n" + 
					"cl.rg,\r\n" + 
					"cl.datanascimento,\r\n" + 
					"cl.sexo,\r\n" + 
					"cl.email,\r\n" + 
					"cl.telefone,\r\n" +
					"en.tipo,\r\n" + 
					"en.logradoura,\r\n" + 
					"en.numero,\r\n" + 
					"en.complemento,\r\n" + 
					"en.bairro,\r\n" + 
					"en.cep\r\n" + 
					"from clientes cl inner join endereco en on cl.idclientes = en.idclientes\r\n" + 
					"where en.idendereco =idendereco order by nome";
			try {
				//abrir a conexão
				Connection con = conectar();
				// Prepara a query
				 PreparedStatement pst = con.prepareStatement(read);
				 //Executar a query
				 ResultSet rs = pst.executeQuery(); // (2)
				 // Laço de repetição que sera executado enquanto houver clientes
				 while (rs.next()){
					 
					 // criar variaveis locais para receber os conteudos // (3)
					 String idclientes = rs.getString(1);
					 String nome = rs.getString(2);
					 String cpf = rs.getString(3);
					 String rg = rs.getString(4);
					 String datanascimento = rs.getString(5);
					 String sexo = rs.getString(6);
					 String email = rs.getString(7);
					 String telefone = rs.getString(8);
					 				 
					 // "popular" (preencher) o vetor // (4)
					 clientes.add(new JavaBeans (idclientes,nome,cpf,rg,datanascimento,sexo,email,telefone));
					//fechar a conexão
					//con.close();
				 }
				 return clientes;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		/*  CRUD - Read Endereco*/
		// método com retorno usando oArryList ligado ao JavaBeans
			public ArrayList<JavaBeans> listarEndereco(){
				// criar um vetor dinamico para receber as variaveis, que serão armazenada em JavaBeans 
				 ArrayList<JavaBeans> endereco = new ArrayList<>();
				//query
				String read = "select \r\n" + 
						"en.idendereco,\r\n" + 
						"en.tipo,\r\n" + 
						"en.logradoura,\r\n" + 
						"en.numero,\r\n" + 
						"en.complemento,\r\n" + 
						"en.bairro,\r\n" + 
						"en.cep,\r\n" + 
						"cl.idclientes,\r\n" + 
						"cl.nome,\r\n" + 
						"cl.cpf,\r\n" + 
						"cl.rg,\r\n" + 
						"cl.datanascimento,\r\n" + 
						"cl.sexo,\r\n" + 
						"cl.email,\r\n" + 
						"cl.telefone\r\n" + 
						"from clientes cl inner join endereco en on cl.idclientes = en.idclientes\r\n" + 
						"where en.idendereco =idendereco order by nome";
				try {
					//abrir a conexão
					Connection con = conectar();
					// Prepara a query
					 PreparedStatement pst = con.prepareStatement(read);
					 //Executar a query
					 ResultSet rs = pst.executeQuery(); // (2)
					 // Laço de repetição que sera executado enquanto houver clientes
					 while (rs.next()){
						 					
						 // criar variaveis locais para receber os conteudos // (3)
						 
						 String tipo = rs.getString(2);
						 String logradoura = rs.getString(3);
						 String numero = rs.getString(4);
						 String complemento = rs.getString(5);
						 String bairro = rs.getString(6);
						 String cep = rs.getString(7);
						 String idendereco = rs.getString(1);
						 
										 
						 // "popular" (preencher) o vetor // (4)
						 endereco.add(new JavaBeans (idendereco,tipo,logradoura,numero,complemento,bairro,cep));
						//fechar a conexão
						//con.close();
					 }
					 return endereco;
				} catch (Exception e) {
					System.out.println(e);
					return null;
				}
			}
			
		
	
	/* CRUD - update */
	// Update 1 Método para selecionar o cliente
	public void listarCliente(JavaBeans cliente) {
		// query 
		String update1 = "select * from clientes where idclientes=?";	
		try {
			//abrindo conexão
			Connection con = conectar();
			// preparar a query
			PreparedStatement pst = con.prepareStatement(update1);
			// Subistituir o parâmetro (?) pelo conteúdo idclientes (JavaBeans)
			pst.setString(1, cliente.getIdclientes());
			// Executar a query, armazenando o conteúdo no objeto rs
			ResultSet rs = pst.executeQuery();
			// Laço de repeção que será executado enquanto houver contatos
			while (rs.next()) {
				// teste de recebimento 
				//System.out.println(rs.getString(1));
				//setar as variáveis JavaBeans com o select
				cliente.setIdclientes(rs.getString(1));
				cliente.setNome(rs.getString(2)); 
				cliente.setCpf(rs.getString(3));
				cliente.setRg(rs.getString(4));
				cliente.setDatanascimento(rs.getString(5));
				cliente.setSexo(rs.getString(6));
				cliente.setEmail(rs.getString(7));
				cliente.setTelefone(rs.getString(8));				
				//fechar a conexão
				//con.close();
			}			
			
		} catch (Exception e) {
			
		}
	}
	// Update 2 Método para alterar cliente
		public void alterarCliente(JavaBeans cliente) {
			// query 
			String update2 = "update clientes set nome=?,cpf=?,rg=?,datanascimento=?,sexo=?,email=?,telefone=? where idclientes=?";	
			try {
				//abrindo conexão
				Connection con = conectar();
				// preparar a query
				PreparedStatement pst = con.prepareStatement(update2);
				// substituir os parâmetros (?) pelo contéudo JavaBeans
				pst.setString(1, cliente.getNome());
				pst.setString(2, cliente.getCpf());
				pst.setString(3, cliente.getRg());
				pst.setString(4, cliente.getDatanascimento());
				pst.setString(5, cliente.getSexo());
				pst.setString(6, cliente.getEmail());
				pst.setString(7, cliente.getTelefone());
				pst.setString(8, cliente.getIdclientes());
				//execute a conexão
				pst.executeUpdate();
				//fechar a conexão
				con.close();
			} catch (Exception e) {
				//System.out.println(e);
		}
	}
	
	/* CRUD updateEnde */
	// método para selecionar endereço
	public void listarEnd(JavaBeans endereco) {
		
		String updateEnd = "select * from endereco where idendereco=?";
		try {
			Connection con = conectar();			
			PreparedStatement pst = con.prepareStatement(updateEnd);
			pst.setString(1, endereco.getIdendereco());
			ResultSet rs = pst.executeQuery();			
			while (rs.next()) {
				// teste de recebimento 
				//System.out.println(rs.getString(1));
				//setar as variáveis JavaBeans com o select
				endereco.setIdendereco(rs.getString(1));
				endereco.setTipo(rs.getString(2)); 
				endereco.setLogradoura(rs.getString(3));
				endereco.setNumero(rs.getString(4));
				endereco.setComplemento(rs.getString(5));
				endereco.setBairro(rs.getString(6));
				endereco.setCep(rs.getString(7));				
				//fechar a conexão
				//con.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// método para Alterar endereço
		public void alterarEndereco(JavaBeans endereco) {		
			String updateEnd2 = "update endereco set tipo=?,logradoura=?,numero=?,complemento=?,bairro=?,cep=? where idendereco=?";
			try {
				// Abrir a conexão
				Connection con = conectar();
				// preparar a query
				PreparedStatement pst = con.prepareStatement(updateEnd2);
				// substituir os parâmetros (?) pelo contéudo JavaBeans
				pst.setString(1, endereco.getTipo());
				pst.setString(2, endereco.getLogradoura());
				pst.setString(3, endereco.getNumero());
				pst.setString(4, endereco.getComplemento());
				pst.setString(5, endereco.getBairro());
				pst.setString(6, endereco.getCep());
				pst.setString(7, endereco.getIdendereco());
				//execute a conexão
				pst.executeUpdate();
				//fechar a conexão
				con.close();			
		}catch (Exception e) {
			System.out.println(e);
	}
}
	

	/*CRUD - Delete*/
	// Método para deletar Clientes
		public void deletarCliente(JavaBeans cliente) {
			//query
			String delete = "delete from clientes where idclientes=?";
			try {
				//abrir a conexão
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				//substituir o parâmetro ? pelo conteúdo JavaBeans
				pst.setString(1, cliente.getIdclientes());
				// executar a query ("deletar o cliente")
				pst.executeUpdate();
				con.close();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/*CRUD - Delete*/
		// Método para deletar endereco
			public void deletarEndereco(JavaBeans endereco) {
				//query
				String delete2 = "delete from endereco where idendereco=?";
				try {
					//abrir a conexão
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(delete2);
					//substituir o parâmetro ? pelo conteúdo JavaBeans
					pst.setString(1, endereco.getIdendereco());
					// executar a query ("deletar o endereco")
					pst.executeUpdate();
					con.close();
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		
			
	public void listarCadastroUsu(JavaBeans endereco) {
		String delete = "select * from endereco order by idendereco desc limit 0,?";
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1,endereco.getIdendereco());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				// teste de recebimento 
				System.out.println(rs.getString(1));
				//setar as variáveis JavaBeans com o select
				endereco.setIdendereco(rs.getString(1));
				//fechar a conexão
				con.close();
			}
			
		} catch (Exception e) {
			
		}
	}
	
	public void listarCadastroCli(JavaBeans cliente) {
		String delete = "select * from clientes order by idclientes desc limit 0,?";
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cliente.getIdclientes());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				// teste de recebimento 
				//System.out.println(rs.getString(1));
				//setar as variáveis JavaBeans com o select
				cliente.setIdclientes(rs.getString(1));
				System.out.println(rs.getString(1));
				
				//fechar a conexão
				con.close();				
			}
			
		} catch (Exception e) {
			
		}
	}
	
	

	
}

















