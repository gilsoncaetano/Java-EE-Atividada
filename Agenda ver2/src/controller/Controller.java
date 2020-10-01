package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.javaBeans;

// a linha abaixo ajusta o path ("rota", requisi��es e��es(formul�rios, links, etc) )
@WebServlet(urlPatterns = { "/Controller", "/insert", "/update1", "/update2", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Criar objetos para acessar os m�todos JavaBeans(Model)
	javaBeans contato = new javaBeans();
	// Criar objeto para acessar os m�todos DAO(model)
	DAO dao = new DAO();

	public Controller() {
		super();

	}

	/** m�todo pricipal do servlet (Controller) **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Trabalha com rotas
		String action = request.getServletPath();
		// teste de requisi��es
		// System.out.println(action);
		// encaminhamento
		if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.contentEquals("/update1")) {
			editarContato(request, response);
		} else if (action.contentEquals("/update2")) {
			editarContato2(request, response);
		} else if (action.contentEquals("/delete")) {
			excluirContato(request, response);
		}

	}

	/** M�todo para Adicionar um novo cliente **/
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// m�todo principal do Servlet
		// as vari�veis abaixo recebem os par�metros do formul�rio contato.jsp
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		// Setar as vari�veis da classe JavaBeans
		contato.setNome(nome);
		contato.setFone(fone);
		contato.setEmail(email);
		// "Dar a ordem" para o DAO executar o m�todo novoContato()
		dao.novoContato(contato);
		// redirecionar para a p�gina index.jsp
		response.sendRedirect("index.jsp");
	}

	/** M�todo para Editar um contato **/
	// select do contato (update 1)
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// teste de recebimento do id
		// System.out.println(id);
		// setar a vari�vel JavaBean (2)
		contato.setId(id);
		// invocar o m�todo para selecionar o contato que ser� alterado (3)
		dao.listarContato(contato);
		// encaminha oconte�do JavaBeans ao formulario editar.jsp (8)
		request.setAttribute("id", contato.getId());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		// executar encaminhamento
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		

	}
	// update do contato (update 2)
		protected void editarContato2(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// setar as vari�veis javaBeans com o conte�do do formulario editar.jsp (12)
			contato.setId(request.getParameter("id"));
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			//invocar o m�todo DAO que vai atualizar o contato no banco de dados (13)
			dao.alterarContato(contato);
			// redirecionar para a p�gina index.jsp (16)
			response.sendRedirect("index.jsp");
			
		}

	/** M�todo para Excluir contato **/
	protected void excluirContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// teste de recebimento do id (1)
		//System.out.println(id);
		// setar a vari�vel id (javaBeans) (2)
		contato.setId(id);
		// invocar o m�todo para excluir o contato (3)
		dao.deletarContato(contato);
		// redirecionar para a p�gina index.jsp (6) 
		response.sendRedirect("index.jsp");
	}

}
