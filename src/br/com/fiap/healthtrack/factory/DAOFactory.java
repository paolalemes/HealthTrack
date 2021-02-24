package br.com.fiap.healthtrack.factory;

import br.com.fiap.healthtrack.dao.AtividadeDAO;
import br.com.fiap.healthtrack.dao.BatimentosDAO;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.dao.PressaoDAO;
import br.com.fiap.healthtrack.dao.RefeicaoDAO;
import br.com.fiap.healthtrack.dao.TipoAtividadeDAO;
import br.com.fiap.healthtrack.dao.TipoRefeicaoDAO;
import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.dao.impl.OracleAtividadeDAO;
import br.com.fiap.healthtrack.dao.impl.OracleBatimentoDAO;
import br.com.fiap.healthtrack.dao.impl.OraclePesoDAO;
import br.com.fiap.healthtrack.dao.impl.OraclePressaoDAO;
import br.com.fiap.healthtrack.dao.impl.OracleRefeicaoDAO;
import br.com.fiap.healthtrack.dao.impl.OracleTipoAtividadeDAO;
import br.com.fiap.healthtrack.dao.impl.OracleTipoRefeicaoDAO;
import br.com.fiap.healthtrack.dao.impl.OracleUsuarioDAO;

public class DAOFactory {

	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	public static AtividadeDAO getAtividadeDAO() {
		return new OracleAtividadeDAO();
	}
	
	public static PressaoDAO getPressaoDAO() {
		return new OraclePressaoDAO();
	}
	
	public static BatimentosDAO getBatimentoDAO() {
		return new OracleBatimentoDAO();
	}
	
	public static RefeicaoDAO getRefeicaoDAO() {
		return new OracleRefeicaoDAO();
	}
	
	public static TipoRefeicaoDAO getTipoRefeicaoDAO() {
		return new OracleTipoRefeicaoDAO();
	}
	
	public static TipoAtividadeDAO getTipoAtividadeDAO() {
		return new OracleTipoAtividadeDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO(){
		return new OracleUsuarioDAO();
	}
}
