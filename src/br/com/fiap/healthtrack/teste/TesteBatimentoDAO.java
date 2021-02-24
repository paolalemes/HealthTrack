package br.com.fiap.healthtrack.teste;

import java.util.List;

import br.com.fiap.healthtrack.bean.Batimento;
import br.com.fiap.healthtrack.dao.BatimentosDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class TesteBatimentoDAO {

	public static void main(String[] args) {
		BatimentosDAO dao = DAOFactory.getBatimentoDAO();
		
		//Cadastrar um produto
		Batimento batimento = new Batimento(1, "21/11/2020", "00:45:00", 85);
		try {
			dao.cadastrar(batimento);
			System.out.println("Cadastrado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Buscar
		batimento = dao.buscar(1);
		
		//Atualizar
		batimento.setData("10/11/2020");
		batimento.setBatimentos(100);
		try {
			dao.atualizar(batimento);
			System.out.println("Atualizado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		//Listar os produtos
		List<Batimento> lista = dao.listar();
		for (Batimento item : lista) {
			System.out.println(item.getData()+ " " + item.getBatimentos());
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
