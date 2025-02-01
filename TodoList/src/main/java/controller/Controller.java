package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import model.DAO;
import model.JavaBeansTasks;
import model.JavaBeansUsers;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/login", "/cadastro", "/insert", "/logar", "/exibirTasks", "/logout",
		"/todos", "/novaTask", "/adicionar", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeansUsers usuario = new JavaBeansUsers();
	JavaBeansTasks task = new JavaBeansTasks();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao.testeConexao();
		String action = request.getServletPath(); // Obtém a URL chamada

		if (action.equals("/login")) {
			login(request, response);
		} else if (action.equals("/cadastro")) {
			cadastro(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else if (action.equals("/logar")) {
			validarLogin(request, response);
		} else if (action.equals("/todos")) {
			exibirTasks(request, response);
		} else if (action.equals("/logout")) {
			logout(request, response);
		} else if (action.equals("/adicionar")) {
			acharSessao(request, response);
		} else if (action.equals("/novaTask")) {
			novaTask(request, response);
		} else if (action.equals("/select")) {
			listarTasks(request, response);
		} else if (action.equals("/update")) {
			editarTasks(request, response);
		}else if (action.equals("/delete")) {
			deletarTask(request, response);
		}
	}
	//remover contato
	protected void deletarTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		task.setId(id);
		dao.deletarTask(task);
		
		response.sendRedirect("todos");
	}

	// EDITAR CONTATO
	protected void listarTasks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id
		String id = request.getParameter("id");
		task.setId(id);
		// exeecutar metodo
		dao.selecionarTask(task);
		// teste
		request.setAttribute("id", task.getId());
		request.setAttribute("editaNomeTask", task.getTaskName());
		request.setAttribute("idUser", task.getUser_id());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	protected void editarTasks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			task.setId(request.getParameter("id"));
			task.setTaskName(request.getParameter("editaNomeTask"));
			task.setUser_id(request.getParameter("idUser"));
			
			dao.alterarTask(task);
			
			response.sendRedirect("todos");
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void exibirTasks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeansTasks> lista = dao.listarTasks(request);
		request.setAttribute("tasks", lista);
		RequestDispatcher rd = request.getRequestDispatcher("todos.jsp");

		rd.forward(request, response);
	}

	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("cadastro.jsp");
	}

	protected void todos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("cadastro.jsp");
	}

	protected void novaTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		task.setTaskName(request.getParameter("nomeTask"));
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("sessaoEmail");
		Integer id = dao.seekSessao(email);

		dao.novaTask(task, id);
		response.sendRedirect("todos");
	}

	protected void acharSessao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("sessaoEmail");
		Integer id = dao.seekSessao(email);
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("novatask.jsp");
		rd.forward(request, response);
	}

	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		usuario.setName(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setPassword(request.getParameter("senha"));
		// inserir na classe DAO (banco de dados)
		dao.criarUsuario(usuario);
		// redirecionamento
		response.sendRedirect("login");

	}

	protected void validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setEmail(request.getParameter("loginEmail"));
		usuario.setPassword(request.getParameter("loginSenha"));

		if (dao.autenticarUsuario(usuario) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("sessaoEmail", usuario.getEmail());

			response.sendRedirect("todos");
		} else {
			response.sendRedirect("login");
		}
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("logout.jsp");
	}

}