package br.com.fiap.healthtrack.teste;

import java.util.List;

import br.com.fiap.healthtrack.bean.Pressao;
import br.com.fiap.healthtrack.dao.PressaoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class TestePressaoDAO {

	public static void main(String[] args) {
		PressaoDAO dao = DAOFactory.getPressaoDAO();
		
		//Cadastrar um produto
		Pressao pressao = new Pressao(1, "21/11/2020", "00:47:00", 120, 80);
		try {
			dao.cadastrar(pressao);
			System.out.println("Cadastrado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Buscar
		pressao = dao.buscar(1);
		
		
		//atualizar
		pressao.setData("10/11/2020");
		pressao.setDiastolica(70);
		
		try {
			dao.atualizar(pressao);
			System.out.println("Atualizado!!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		//Listar os produtos
		List<Pressao> lista = dao.listar();
		for (Pressao item : lista) {
			System.out.println(item.getSistolica() + " / " + item.getDiastolica());
		}
		
		//Remover um produto
		try {
			dao.remover(1);
			System.out.println("Removido!");
		} catch (DBException e) {
			e.printStackTrace();
		}	
		
		
		
		
		
		

	}
		


}
