package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.bean.Usuario;
import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
    
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			int altura = Integer.parseInt(request.getParameter("altura"));
			String genero = request.getParameter("genero");
			String nascimento = request.getParameter("nascimento");
			String senha = request.getParameter("senha");
			
			
			Usuario usuario = new Usuario(nome, email, altura, genero, nascimento, senha); 
			dao.cadastrar(usuario);
			
			if (dao.validarUsuario(usuario)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", email);
				session.setAttribute("nome", nome);
				
			}
			
			request.setAttribute("msg", "Usuario cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

}
