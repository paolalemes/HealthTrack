package br.com.fiap.healthtrack.teste;

import java.util.List;

import br.com.fiap.healthtrack.bean.Peso;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class TestePesoDAO {

	public static void main(String[] args) {
		PesoDAO dao = DAOFactory.getPesoDAO();
		
		//Cadastrar
		
		Peso peso = new Peso(1, "21/11/2020", "00:39:00", 62);
		
		try {
			dao.cadastrar(peso);
			System.out.println("Cadastrado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		//Buscar
		peso = dao.buscar(1);
		//System.out.println(peso.getData() + " " + peso.getHora() + " " + peso.getPeso() + " " + peso.getCodigoPeso());
		
		// Atualizar
		peso.setPeso(66);
		peso.setData("10/11/20");
		
		try {
			dao.atualizar(peso);
			System.out.println("Atualizado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		//Listar
		List<Peso> lista = dao.listar();
		for (Peso item : lista) {
			System.out.println(item.getData() + " " + item.getPeso());
		}
		
		
		//Remover
		try {
			dao.remover(1);
			System.out.println("Removido!");
		} catch (DBException e) {
			e.printStackTrace();
		}	

	}

}
