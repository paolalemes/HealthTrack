package br.com.fiap.healthtrack.teste;


import java.util.List;

import br.com.fiap.healthtrack.bean.Refeicao;
import br.com.fiap.healthtrack.dao.RefeicaoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class TesteRefeicaoDAO {
	public static void main(String[] args) {
		/*
		RefeicaoDAO dao = DAOFactory.getRefeicaoDAO();
		
		//Cadastrar um produto
		Refeicao refeicao = new Refeicao(1, 1, "21/11/2020", "00:52:00", "leite com nescau", 90);
		
		try {
			dao.cadastrar(refeicao);
			System.out.println("Cadastrado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Buscar
		refeicao = dao.buscar(1);
		
		//Atualizar
		refeicao.setData("10/11/2020");
		refeicao.setCalorias(100);
		
		try {
			dao.atualizar(refeicao);
			System.out.println("Atualizado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		//Listar os produtos
		List<Refeicao> lista = dao.listar();
		for (Refeicao item : lista) {
			System.out.println(item.getData() + " " + item.getDescricao() + " " + item.getCalorias());
		}
		
		//Remover um produto
		try {
			dao.remover(1);
			System.out.println("Removido!!");
		} catch (DBException e) {
			e.printStackTrace();
		}	*/
	}
}
