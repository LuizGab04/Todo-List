package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class DAO {
	// Módulo de conexão
	// Parâmetros de conexão
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/db_todolist?useTimezone=true&serverTimezone=UTC";
	private final String user = "root";
	private final String password = "12345";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			// Carregar o driver JDBC
			Class.forName(driver);
			// Estabelecer a conexão
			con = DriverManager.getConnection(url, user, password);
			// System.out.println("Conexão bem-sucedida: " + con);
			return con;
		} catch (Exception e) {
			System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
			return null;
		}
	}

	// Teste de conexão
	public void testeConexao() {
		Connection con = null;
		try {
			con = conectar();
			if (con != null) {
				// System.out.println("Conexão com o banco de dados realizada com sucesso!");
			} else {
				System.out.println("Falha na conexão com o banco de dados!");
			}
		} catch (Exception e) {
			System.err.println("Erro ao testar conexão: " + e.getMessage());
		} finally {
			// Garantir o fechamento da conexão
		}
	}

	public Integer seekSessao(String email) {
		String procurar = "SELECT id_users FROM users WHERE email = ?";
		Integer id = null;
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(procurar);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				id = rs.getInt("id_users");
			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("oi" + e);
		}
		return id;
	}

	// CRUD CREATE
	public void novaTask(JavaBeansTasks task, Integer id) {
		String createTask = "INSERT INTO todo (taskName, user_id) VALUES (?,?)";
		try {
			// abre a conexao
			Connection con = conectar();
			// prepara a query para a execucao no BD
			PreparedStatement pst = con.prepareStatement(createTask);
			// substituir os paremetros
			pst.setString(1, task.getTaskName());
			pst.setObject(2, id);

			// executar a query
			pst.executeUpdate();
			// encerrar
			con.close();
		} catch (Exception e) {
			System.out.println("oi2222" + e);
		}
	}

	public void criarUsuario(JavaBeansUsers usuario) {
		String create = "INSERT INTO users (name, email, password) VALUES (?,?,?)";
		try {
			// abre a conexao
			Connection con = conectar();
			// prepara a query para a execucao no BD
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os paremetros
			pst.setString(1, usuario.getName());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getPassword());
			// executar a query
			pst.executeUpdate();
			// encerrar
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Método para autenticar o usuário
	public JavaBeansUsers autenticarUsuario(JavaBeansUsers usuario) {
		String busca = "SELECT * FROM users WHERE email = ? AND password = ?"; // Query de autenticação

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(busca);

			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());

			ResultSet rs = pst.executeQuery();

			// Verifica se encontrou o usuário
			if (rs.next()) {
				// Debug: verificar se o nome está vindo correto do banco
				System.out.println("Usuário encontrado: ");
			} else {
				System.out.println("Nenhum usuário encontrado com esse email e senha.");
			}

			// Fechando recursos
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return usuario; // Retorna o objeto ou null caso o login falhe
	}

	// CRUD READ
	public ArrayList<JavaBeansTasks> listarTasks(HttpServletRequest request) {
		ArrayList<JavaBeansTasks> tasks = new ArrayList<>();
		String read = "SELECT * FROM todo LEFT JOIN users ON todo.user_id = users.id_users WHERE users.email = ?";
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("sessaoEmail");

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (!rs.isBeforeFirst()) { // Verifica se há registros no ResultSet
				System.out.println("Nenhuma tarefa encontrada para o usuário: " + email);
			}
			while (rs.next()) {
				String id = rs.getString(1);
				String taskName = rs.getString(2);
				String user_id = rs.getString(3);

				tasks.add(new JavaBeansTasks(id, taskName, user_id));
			}
			return tasks;
		} catch (Exception e) {
			System.out.println("Erro ao listar usuários: " + e.getMessage());
			return null; // Retorna a lista vazia em caso de erro
		}
	}

	// CRUD UPDATE
	public void selecionarTask(JavaBeansTasks task) {
		String editarBuscarTask = "SELECT * FROM todo where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(editarBuscarTask);
			pst.setString(1, task.getId());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				task.setId(rs.getString(1));
				task.setTaskName(rs.getString(2));
				task.setUser_id(rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	// alterar contato
	public void alterarTask(JavaBeansTasks task) {
		String editarTask = "UPDATE todo SET taskName = ? WHERE id = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(editarTask);
			pst.setString(1, task.getTaskName());
			pst.setString(2, task.getId());

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//CRUD DELETE
	public void deletarTask(JavaBeansTasks task) {
		String delete = "DELETE FROM todo WHERE id = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, task.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}