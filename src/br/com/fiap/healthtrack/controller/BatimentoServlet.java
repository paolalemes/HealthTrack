package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.bean.Batimento;
import br.com.fiap.healthtrack.dao.BatimentosDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class BatimentoServlet
 */
@WebServlet("/batimentos")
public class BatimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	BatimentosDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getBatimentoDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
    	
    	switch (acao) {
    	case "cadastrar":
    		cadastrar(request, response);
    		break;
    	case "editar":
    		editar(request,response);
    		break;
    	case "excluir":
    		excluir(request, response);
    		break;
    	}
	}
    
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codigo = Integer.parseInt(request.getParameter("codigo"));
    	try {
    		dao.remover(codigo);
    		request.setAttribute("msg", "Peso removido!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao remover");
    	}
    	listar(request,response);
    }
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String data = request.getParameter("dt");
			String hora = request.getParameter("hr");
			int batimentos = Integer.parseInt(request.getParameter("bpm"));
			
			
			Batimento batimento = new Batimento(codigo, 1, data, hora, batimentos); 
			dao.atualizar(batimento);

			request.setAttribute("msg", "Batimento atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String data = request.getParameter("dt");
			String hora = request.getParameter("hr");
			int batimentos = Integer.parseInt(request.getParameter("bpm"));
			
			
			Batimento batimento = new Batimento(1, data, hora, batimentos); 
			dao.cadastrar(batimento);
			
			request.setAttribute("msg", "Batimento cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("adicionarBatimentos.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);	
			break;
		case "abrir-form-edicao":
			int id = Integer.parseInt(request.getParameter("codigo"));
			Batimento batimento = dao.buscar(id);
			request.setAttribute("batimento", batimento);
			request.getRequestDispatcher("edicaoBatimento.jsp").forward(request, response);
		}
			
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Batimento> lista = dao.listar();
		request.setAttribute("batimentos", lista);
		request.getRequestDispatcher("batimentos.jsp").forward(request, response);
	}

}
