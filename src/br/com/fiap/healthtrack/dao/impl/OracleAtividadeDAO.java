package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.bean.Atividade;
import br.com.fiap.healthtrack.bean.TipoAtividade;
import br.com.fiap.healthtrack.dao.AtividadeDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OracleAtividadeDAO implements AtividadeDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_ATIVIDADE (cd_atividade, cd_usuario, cd_tipo_atividade, dt_atividade, hr_atividade, ds_descricao, nr_calorias) VALUES (SQ_ATIVIDADE.nextval, ?, ?, TO_DATE(?, 'DD/MM/YY'), ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, atividade.getUsuario());
			stmt.setInt(2, atividade.getTipoAtividade().getCodTipoAtividade());
			stmt.setString(3, atividade.getData());
			stmt.setString(4, atividade.getHora());
			stmt.setString(5, atividade.getDescricao());
			stmt.setInt(6, atividade.getCalorias());
			

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void atualizar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_HT_ATIVIDADE SET cd_tipo_atividade = ?, dt_atividade = TO_DATE(?, 'DD/MM/YY'), hr_atividade = ?, ds_descricao = ?, nr_calorias = ? WHERE cd_atividade = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, atividade.getTipoAtividade().getCodTipoAtividade());
			stmt.setString(2, atividade.getData());
			stmt.setString(3, atividade.getHora());
			stmt.setString(4, atividade.getDescricao());
			stmt.setInt(5, atividade.getCalorias());
			stmt.setInt(6, atividade.getCodigoAtividade());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_HT_ATIVIDADE WHERE cd_atividade = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Atividade buscar(int id) {
		Atividade atividade = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_ATIVIDADE NATURAL JOIN T_HT_TIPO_ATIVIDADE WHERE cd_atividade = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("cd_atividade");
				int usuario = rs.getInt("cd_usuario");
				int tipo = rs.getInt("cd_tipo_atividade");
				String data = rs.getString("dt_atividade");
				String hora = rs.getString("hr_atividade");
				String descricao = rs.getString("ds_descricao");
				int calorias = rs.getInt("nr_calorias");
				
				String tipoAtiv = rs.getString("ds_tipo_atividade");
				
				TipoAtividade categoria = new TipoAtividade(tipo, tipoAtiv);
				
				atividade = new Atividade(codigo, usuario, categoria, data, hora, descricao, calorias);
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
		return atividade;
	}

	@Override
	public List<Atividade> listar() {
		List<Atividade> lista = new ArrayList<Atividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_ATIVIDADE NATURAL JOIN T_HT_TIPO_ATIVIDADE ORDER BY cd_atividade DESC");
			rs = stmt.executeQuery();

			
			while (rs.next()) {
				int codigo = rs.getInt("cd_atividade");
				int usuario = rs.getInt("cd_usuario");
				int tipo = rs.getInt("cd_tipo_atividade");
				String data = rs.getString("dt_atividade");
				String hora = rs.getString("hr_atividade");
				String descricao = rs.getString("ds_descricao");
				int calorias = rs.getInt("nr_calorias");
				
				String tipoAtiv = rs.getString("ds_tipo_atividade");
				
				TipoAtividade categoria = new TipoAtividade(tipo, tipoAtiv);
				
				Atividade atividade = new Atividade(codigo, usuario, categoria, data, hora, descricao, calorias);
				lista.add(atividade);
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
