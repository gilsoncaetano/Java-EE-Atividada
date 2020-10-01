package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

// a linha abaixo ajusta o path ("rotas", requisi��es e a��es (formul�rios, links, etc) )
@WebServlet(urlPatterns = {"/Controller","/insert","/update1","/update2","/delete","/delete1","/delete2","/updateEnd","/updateEnd2","/updateUsu","/updateUsu2","/insertUsu"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //Criar objeto para acessar os m�todos javaBeans (Model)
		JavaBeans cliente = new JavaBeans();
		JavaBeans endereco = new JavaBeans();
		
		
		//Criar objeto para acessa os m�todos DAO(model)
		DAO dao = new DAO();
		DAO daoend = new DAO();
	
			
		
		
   
    public Controller() {
        super();
        
    }

	/** M�todo pricipal do Select (Controller) **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// Trabalhar com rotas
		String action = request.getServletPath();
		// teste de requerisi��es
		//System.out.println(action);
		//encaminhamento 
		if (action.contentEquals("/insert")) {
			novoCliente(request,response);
		}else if (action.contentEquals("/update1")) {
			editarCliente(request,response);
		}else if (action.contentEquals("/update2")) {
			editarCliente2(request,response);
		}else if (action.contentEquals("/delete")) {
			excluirCliente(request,response);
		}else if (action.contentEquals("/delete1")) {
			//excluirUsuario(request,response);
		}else if (action.contentEquals("/delete2")) {
			excluirEndereco(request,response);
		}else if (action.contentEquals("/updateEnd")) {
			editarEndereco(request,response);
		}else if (action.contentEquals("/updateEnd2")) {
			editarEndereco2(request,response);
		}else if (action.contentEquals("/updateUsu")) {
			//editarUsuario(request,response);
		}else if (action.contentEquals("/updateUsu2")) {
		//	editarUsuario2(request,response);
		}else if (action.contentEquals("/insertUsu")) {
			novoEndereco(request,response);
		}
		
	}
	
	/** M�todo para Adiciona um Novo cliente**/
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// M�todo Pricipal do Servle
				/*** Passo "4" ***/
				// As Vari�ves abaixo recebem ps par�metros do formul�rio contato.jsp
				String nome = request.getParameter("nome");
				String cpf = request.getParameter("cpf");
				String rg = request.getParameter("rg");
				String datanascimento = request.getParameter("datanascimento");
				String sexo = request.getParameter("sexo");
				String email = request.getParameter("email");
				String telefone = request.getParameter("telefone");						
				//String usuario = request.getParameter("usuario");
				//String senha = request.getParameter("senha");
				//String foto = request.getParameter("foto");
				// As linhas abaixo exiber em texto simples o conte�do das vari�veis
				// As linha a baixo comentada e para executa o teste para ver se o controlhe esta resebendo os dados 
				//response.getWriter().append(nome);
				//response.getWriter().append(cpf);					
				//*** Passo "4" ***/
				// Star as vari�veis da classe JavaBeans
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setRg(rg);
				cliente.setDatanascimento(datanascimento);
				cliente.setSexo(sexo);
				cliente.setEmail(email);
				cliente.setTelefone(telefone);		
				
				//usuariocli.setIdendereco(idendereco);
				//usuariocli.setIdclientes(idclientes);
				//usuariocli.setUsuario(usuario);
				//usuariocli.setSenha(senha);
				//usuariocli.setFoto(foto);
				//*** Passo "4" ***/
				// "Dar a ordem para o DAO executa o m�todo novoClientes()"
				dao.novoCliente(cliente);
								
				//daousu.novoUsuario(usuariocli);
				//redirecionar para p�gina index.jsp
				RequestDispatcher rd = request.getRequestDispatcher("cadastrarUsuario.jsp");
				rd.forward(request, response);
				//response.sendRedirect("cadastrarUsuario.jsp");	
	}
	
	
	/** M�todo para cadastrar um Novo usuario**/
	protected void novoEndereco(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String tipo = request.getParameter("tipo");
		String logradoura = request.getParameter("logradoura");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String idclientes = request.getParameter("idclientes");
		endereco.setTipo(tipo);
		endereco.setLogradoura(logradoura);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setIdclientes(idclientes);
		// "Dar a ordem para o DAO executa o m�todo novoClientes()"
		daoend.novoEndereco(endereco);
		response.sendRedirect("index.jsp");
		
	}
	

	
	
	/** M�todo para Editar Cliente**/
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// Teste de recebimento do id
		String idclientes = request.getParameter("idclientes");
		// setra a variavel JavaBeans
		cliente.setIdclientes(idclientes);
		//Invocar o m�todo para selecionar o contato que ser� alterado
		dao.listarCliente(cliente);
		// encaminhar o conte�do JavaBeans ao formulario
		request.setAttribute("idclientes", cliente.getIdclientes());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("cpf", cliente.getCpf());
		request.setAttribute("rg", cliente.getRg());
		request.setAttribute("datanascimento", cliente.getDatanascimento());
		request.setAttribute("sexo", cliente.getSexo());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("telefone", cliente.getTelefone());
		// executa o encaminhamento
		RequestDispatcher rd = request.getRequestDispatcher("editarCliente.jsp");
		rd.forward(request, response);
		
	}
	
	/** M�todo para Editar Cliente2**/
	protected void editarCliente2(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//setar as variaveis JavaBean com o formulario do formulario 
		cliente.setIdclientes(request.getParameter("idclientes"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setRg(request.getParameter("rg"));
		cliente.setDatanascimento(request.getParameter("datanascimento"));
		cliente.setSexo(request.getParameter("sexo"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTelefone(request.getParameter("telefone"));
		//invocar o m�todo que vai atualizar cliente no banco de dados 
		dao.alterarCliente(cliente);
		//redirecionar para p�gina index.jsp
		response.sendRedirect("index.jsp");	
	}
	
	/** M�todo para Editar Endere�o**/
	protected void editarEndereco(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String idendereco = request.getParameter("idendereco");
		endereco.setIdendereco(idendereco);
		daoend.listarEnd(endereco);
		// encaminhar o conte�do JavaBeans ao formulario
		request.setAttribute("idendereco", endereco.getIdendereco());
		request.setAttribute("tipo", endereco.getTipo());
		request.setAttribute("logradoura", endereco.getLogradoura());
		request.setAttribute("numero", endereco.getNumero());
		request.setAttribute("complemento", endereco.getComplemento());
		request.setAttribute("bairro", endereco.getBairro());
		request.setAttribute("cep", endereco.getCep());
		// executa o encaminhamento
		RequestDispatcher rd = request.getRequestDispatcher("editarEndereco.jsp");
		rd.forward(request, response);
		
	}
	
	/** M�todo para Editar Endere�o 2**/
	protected void editarEndereco2(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		endereco.setIdendereco(request.getParameter("idendereco"));
		endereco.setTipo(request.getParameter("tipo"));
		endereco.setLogradoura(request.getParameter("logradoura"));
		endereco.setNumero(request.getParameter("numero"));
		endereco.setComplemento(request.getParameter("complemento"));
		endereco.setBairro(request.getParameter("bairro"));
		endereco.setCep(request.getParameter("cep"));
		//invocar o m�todo que vai atualizar cliente no banco de dados 
		daoend.alterarEndereco(endereco);
		//redirecionar para p�gina index.jsp
		response.sendRedirect("index.jsp");	
	}
	
	
	/** M�todo para Excluir Cliente**/
	protected void excluirCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String idclientes = request.getParameter("idclientes");
		cliente.setIdclientes(idclientes);
		dao.deletarCliente(cliente);
		response.sendRedirect("index.jsp");
	}
	
	/** M�todo para Excluir endereco**/
	protected void excluirEndereco(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String idendereco = request.getParameter("idendereco");
		endereco.setIdendereco(idendereco);
		daoend.deletarEndereco(endereco);
		response.sendRedirect("index.jsp");
	}
	
	
}


























