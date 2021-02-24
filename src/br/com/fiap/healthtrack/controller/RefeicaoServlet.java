package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.bean.Refeicao;
import br.com.fiap.healthtrack.bean.TipoRefeicao;
import br.com.fiap.healthtrack.dao.RefeicaoDAO;
import br.com.fiap.healthtrack.dao.TipoRefeicaoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class RefeicaoServlet
 */
@WebServlet("/refeicao")
public class RefeicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RefeicaoDAO dao;
	private TipoRefeicaoDAO tipoDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getRefeicaoDAO();
		tipoDao = DAOFactory.getTipoRefeicaoDAO();
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
			String descricao = request.getParameter("descr");
			int tipo = Integer.parseInt(request.getParameter("refeicao"));
			int calorias = Integer.parseInt(request.getParameter("kcal"));
			
			TipoRefeicao tipoRef = new TipoRefeicao();
			tipoRef.setCodTipoRefeicao(tipo);
			
			
			Refeicao refeicao = new Refeicao(codigo, 1, tipoRef, data, hora, descricao, calorias); 
			dao.atualizar(refeicao);

			request.setAttribute("msg", "Produto atualizado!");
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
			String descricao = request.getParameter("descr");
			int tipo = Integer.parseInt(request.getParameter("refeicao"));
			int calorias = Integer.parseInt(request.getParameter("kcal"));
			
			TipoRefeicao tipoRef = new TipoRefeicao();
			tipoRef.setCodTipoRefeicao(tipo);
			
			
			Refeicao refeicao = new Refeicao(1, tipoRef, data, hora, descricao, calorias); 
			dao.cadastrar(refeicao);
			
			request.setAttribute("msg", "Refeição cadastrada!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("adicionarRefeicao.jsp").forward(request, response);
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
			Refeicao refeicao = dao.buscar(id);
			request.setAttribute("refeicao", refeicao);
			request.getRequestDispatcher("edicaoRefeicao.jsp").forward(request, response);
		}
		
				
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Refeicao> lista = dao.listar();
		request.setAttribute("refeicoes", lista);
		request.getRequestDispatcher("refeicao.jsp").forward(request, response);
	}
	
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TipoRefeicao> lista = tipoDao.listar();
		request.setAttribute("categorias", lista);
		request.getRequestDispatcher("cadastro-produto.jsp").forward(request, response);
	}

}
