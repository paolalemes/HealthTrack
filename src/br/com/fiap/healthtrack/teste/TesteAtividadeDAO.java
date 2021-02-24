package br.com.fiap.healthtrack.teste;



import java.util.List;

import br.com.fiap.healthtrack.bean.Atividade;
import br.com.fiap.healthtrack.dao.AtividadeDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class TesteAtividadeDAO {
	public static void main(String[] args) {
		AtividadeDAO dao = DAOFactory.getAtividadeDAO();
		/*
		//Cadastrar um produto
		
		Atividade atividade = new Atividade(1, 1, "21/11/2020", "00:42:00", "corrida no parque", 300);
		try {
			dao.cadastrar(atividade);
			System.out.println("Cadastrado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Buscar
		atividade = dao.buscar(1);
		
		System.out.println(atividade.getData() + " " + atividade.getCodigoAtividade() + " " + atividade.getDescricao());
		
		
		//Atualizar
		atividade.setTipoAtividade(2);
		atividade.setData("10/11/2020");
		atividade.setDescricao("caminhada no parque");
		
		try {
			dao.atualizar(atividade);
			System.out.println("Atualizado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Listar os produtos
		List<Atividade> lista = dao.listar();
		for (Atividade item : lista) {
			System.out.println(item.getData() + " " + item.getDescricao() + " " + item.getCalorias());
		}
		
		//Remover um produto
		try {
			dao.remover(1);
			System.out.println("Removido!!");
		} catch (DBException e) {
			e.printStackTrace();
		}	
*/
		
	}
}
