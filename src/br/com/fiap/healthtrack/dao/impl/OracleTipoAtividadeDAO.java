package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.bean.TipoAtividade;
import br.com.fiap.healthtrack.dao.TipoAtividadeDAO;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OracleTipoAtividadeDAO implements TipoAtividadeDAO {
	private Connection conexao;

	@Override
	public List<TipoAtividade> listar() {
		List<TipoAtividade> lista = new ArrayList<TipoAtividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_TIPO_ATIVIDADE");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("cd_tipo_atividade");
				String nome = rs.getString("ds_tipo_atividade");
				TipoAtividade categoria = new TipoAtividade(codigo,nome);
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
