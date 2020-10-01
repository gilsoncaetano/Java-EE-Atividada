package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class DAO {
	
	/*** Conexão com o banco de dados ***/
	// parametro de conexão
	// Ajusta fuzo Horario // useTimezone=true&serverTimezone=UTC
	//Connection con = null;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";
	
	//método de conexão
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
	/* CRUD - Create */
	public void novoContato(javaBeans contato) {
		//criar a quary(comando sql)
		String create = "insert into contatos (nome,fone,email) values (?,?,?)";
		try {
			//abrir conexao com o banco
			Connection con = conectar();
			//preparar a quary
			PreparedStatement pst = con.prepareStatement(create);
			//substituir os parâmetros(?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			//executar a quary (comando sql)
			pst.executeUpdate();
			//IMPORTE !!! fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/* CRUD - Read */
	//método com retorno usado a ArrayList ligado ao JavaBeans
	public ArrayList<javaBeans> listarContatos(){
		// Criar um vetor dinamico para receber as variáves, que serão armazenadas em JavaBeans
		ArrayList<javaBeans> contatos = new ArrayList<>();
		//query
		String read = "select * from contatos order by nome";
		try {
			//abrir a conexão com o banco
			Connection con = conectar();
			//Preparar a query
			PreparedStatement pst = con.prepareStatement(read);
			//Executar a query, armazenando o conteúdo no objeto rs
			ResultSet rs = pst.executeQuery();  // Processo "2"
			//Laço de repetição que será executado enquanto houver contatos
			while (rs.next()) { 
				//teste de recebimento
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(2));
				//System.out.println(rs.getString(3));
				//System.out.println(rs.getString(4));
				
				// Criar variavel local para receber os contatos  // Processo "3"
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4 );
				// "popular" (preencher) o vetor // Processo "4"
				contatos.add(new javaBeans(id,nome,fone,email));
				//con.close();
			}
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			}
		}
		/* CRUD- Update */
		// Update 1 - Método para selecionar o contato
		public void listarContato(javaBeans contato) {
			// query
			String update1 = "select * from contatos where id=?";
			try {
				// abrir a conexão
				Connection con = conectar();
				// Preparar a query
				PreparedStatement pst = con.prepareStatement(update1);
				// Substituir  o parâmetro (?) pelo conteúdo no objeto rs
				pst.setString(1, contato.getId()); //(4)
				// Executa a query, armazenando o conteúdo no objeto rs
				ResultSet rs = pst.executeQuery(); //(5)
				// Laço de repetição que será executatdo enquanto houver contatos
				while (rs.next()) {
					// teste de recebimento  // (6)
					//System.out.println(rs.getString(1));
					//System.out.println(rs.getString(2));
					//System.out.println(rs.getString(3));
					//System.out.println(rs.getString(4));
					// Setar as variáveis javaBeans com o select (banco de dados)passo (6)(7)
					contato.setId(rs.getString(1));
					contato.setNome(rs.getString(2));
					contato.setFone(rs.getString(3));
					contato.setEmail(rs.getString(4));
					//con.close();
				}
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
			// Update 2 - Método para Alterar o contato
			public void alterarContato(javaBeans contato) {
				// query
				String update2 = "update contatos set nome=?, fone=?,email=? where id=?";
				try {
					// abrir a coneção
					Connection con = conectar();
					// Prepare a query
					PreparedStatement pst = con.prepareStatement(update2);
					// substituir os parâmetros(?) pelo conteúdo javaBeans (14)
					pst.setString(1,  contato.getNome());
					pst.setString(2,  contato.getFone());
					pst.setString(3,  contato.getEmail());
					pst.setString(4,  contato.getId());
					// executa a query
					pst.executeUpdate(); //(15)
					//fechar a conexão
					con.close();
					
				} catch (Exception e) {
					System.out.println(e);					
				}					
			}


			/* CRUD  -  Delete */
			public void deletarContato(javaBeans contato) {
				//query
				String delete = "delete from contatos where id=?";
				try {
					// abrir a conexão 
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(delete);
					// substiruir o parâmetro ? pelo conteúdo javaBeans
					pst.setString(1, contato.getId()); // (4)
					// execute a query ("delelar o contato")
					pst.executeUpdate(); // (5)
					con.close();
				} catch (Exception e) {
					System.out.println(e);
			}
					
	}
}
			
		

