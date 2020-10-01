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

// a linha abaixo ajusta o path ("rota", requisições eções(formulários, links, etc) )
@WebServlet(urlPatterns = { "/Controller", "/insert", "/update1", "/update2", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Criar objetos para acessar os métodos JavaBeans(Model)
	javaBeans contato = new javaBeans();
	// Criar objeto para acessar os métodos DAO(model)
	DAO dao = new DAO();

	public Controller() {
		super();

	}

	/** método pricipal do servlet (Controller) **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Trabalha com rotas
		String action = request.getServletPath();
		// teste de requisiçôes
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

	/** Método para Adicionar um novo cliente **/
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// método principal do Servlet
		// as variáveis abaixo recebem os parâmetros do formulário contato.jsp
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		// Setar as variáveis da classe JavaBeans
		contato.setNome(nome);
		contato.setFone(fone);
		contato.setEmail(email);
		// "Dar a ordem" para o DAO executar o método novoContato()
		dao.novoContato(contato);
		// redirecionar para a página index.jsp
		response.sendRedirect("index.jsp");
	}

	/** Método para Editar um contato **/
	// select do contato (update 1)
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// teste de recebimento do id
		// System.out.println(id);
		// setar a variável JavaBean (2)
		contato.setId(id);
		// invocar o método para selecionar o contato que será alterado (3)
		dao.listarContato(contato);
		// encaminha oconteúdo JavaBeans ao formulario editar.jsp (8)
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
			// setar as variáveis javaBeans com o conteúdo do formulario editar.jsp (12)
			contato.setId(request.getParameter("id"));
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			//invocar o método DAO que vai atualizar o contato no banco de dados (13)
			dao.alterarContato(contato);
			// redirecionar para a página index.jsp (16)
			response.sendRedirect("index.jsp");
			
		}

	/** Método para Excluir contato **/
	protected void excluirContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// teste de recebimento do id (1)
		//System.out.println(id);
		// setar a variável id (javaBeans) (2)
		contato.setId(id);
		// invocar o método para excluir o contato (3)
		dao.deletarContato(contato);
		// redirecionar para a página index.jsp (6) 
		response.sendRedirect("index.jsp");
	}

}
