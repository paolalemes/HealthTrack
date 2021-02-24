package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.bean.TipoRefeicao;
import br.com.fiap.healthtrack.dao.TipoRefeicaoDAO;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OracleTipoRefeicaoDAO implements TipoRefeicaoDAO {
	private Connection conexao;

	@Override
	public List<TipoRefeicao> listar() {
		List<TipoRefeicao> lista = new ArrayList<TipoRefeicao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_TIPO_REFEICAO");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("cd_tipo_refeicao");
				String nome = rs.getString("ds_tipo_refeicao");
				TipoRefeicao categoria = new TipoRefeicao(codigo,nome);
				lista.add(categoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

}
