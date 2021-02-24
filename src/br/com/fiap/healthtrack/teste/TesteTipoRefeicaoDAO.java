package br.com.fiap.healthtrack.teste;

import java.util.List;

import br.com.fiap.healthtrack.bean.TipoRefeicao;
import br.com.fiap.healthtrack.dao.TipoRefeicaoDAO;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class TesteTipoRefeicaoDAO {
	
	public static void main(String[] args) {
		TipoRefeicaoDAO dao = DAOFactory.getTipoRefeicaoDAO();
		
		List<TipoRefeicao> lista = dao.listar();
		for(TipoRefeicao tipo: lista) {
			System.out.println(tipo.getCodTipoRefeicao() + " - " + tipo.getNomeRefeicao());
		}
		
		
		
	}
}
