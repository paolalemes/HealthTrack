package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import br.com.fiap.healthtrack.bean.Atividade;
import br.com.fiap.healthtrack.bean.TipoAtividade;
import br.com.fiap.healthtrack.dao.AtividadeDAO;
import br.com.fiap.healthtrack.dao.TipoAtividadeDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class AtividadeServlet
 */
@WebServlet("/atividade")
public class AtividadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AtividadeDAO dao;
    private TipoAtividadeDAO tipoDao;
    
    @Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getAtividadeDAO();
		tipoDao = DAOFactory.getTipoAtividadeDAO();
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
    		request.setAttribute("msg", "Atividade removida!");
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
			int tipo = Integer.parseInt(request.getParameter("atividade"));
			int calorias = Integer.parseInt(request.getParameter("kcal"));
			
			TipoAtividade tipoAtiv = new TipoAtividade();
			tipoAtiv.setCodTipoAtividade(tipo);
			
			
			Atividade atividade = new Atividade(codigo, 1, tipoAtiv, data, hora, descricao, calorias);
			dao.atualizar(atividade);

			request.setAttribute("msg", "Atividade atualizada!");
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
			int tipo = Integer.parseInt(request.getParameter("atividade"));
			int calorias = Integer.parseInt(request.getParameter("kcal"));
			
			TipoAtividade tipoAtiv = new TipoAtividade();
			tipoAtiv.setCodTipoAtividade(tipo);
			
			Atividade atividade = new Atividade(1, tipoAtiv, data, hora, descricao, calorias);
			
			dao.cadastrar(atividade);
			
			request.setAttribute("msg", "Atividade cadastrada!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("adicionarAtividade.jsp").forward(request, response);
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
			Atividade atividade = dao.buscar(id);
			request.setAttribute("atividade", atividade);
			request.getRequestDispatcher("edicaoAtividade.jsp").forward(request, response);
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
			break;
		}
    	
    		
    }

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Atividade> lista = dao.listar();
		request.setAttribute("atividades", lista);
		request.getRequestDispatcher("atividadeFisica.jsp").forward(request, response);
	}
	
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TipoAtividade> lista = tipoDao.listar();
		request.setAttribute("categorias", lista);
		request.getRequestDispatcher("adicionarAtividade.jsp").forward(request, response);
	}
    
    
    
}
