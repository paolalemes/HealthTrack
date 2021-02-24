package br.com.fiap.healthtrack.teste;

import java.util.List;

import br.com.fiap.healthtrack.bean.TipoAtividade;
import br.com.fiap.healthtrack.dao.TipoAtividadeDAO;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class TesteTipoAtividadeDAO {

	public static void main(String[] args) {
		TipoAtividadeDAO dao = DAOFactory.getTipoAtividadeDAO();
		
		List<TipoAtividade> lista = dao.listar();
		for(TipoAtividade tipo : lista) {
			System.out.println(tipo.getCodTipoAtividade() + " - " + tipo.getNomeAtividade());
		}
		
		

	}

}
