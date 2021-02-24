package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.bean.Refeicao;
import br.com.fiap.healthtrack.bean.TipoRefeicao;
import br.com.fiap.healthtrack.dao.RefeicaoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OracleRefeicaoDAO implements RefeicaoDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Refeicao refeicao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_REFEICAO (cd_refeicao, cd_usuario, cd_tipo_refeicao, dt_refeicao, hr_refeicao, ds_descricao, nr_calorias) VALUES (SQ_REFEICAO.nextval, ?, ?, TO_DATE(?, 'DD/MM/YY'), ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, refeicao.getUsuario());
			stmt.setInt(2, refeicao.getTipoRefeicao().getCodTipoRefeicao());
			stmt.setString(3, refeicao.getData());
			stmt.setString(4, refeicao.getHora());
			stmt.setString(5, refeicao.getDescricao());
			stmt.setInt(6, refeicao.getCalorias());
			

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
	public void atualizar(Refeicao refeicao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_HT_REFEICAO SET cd_tipo_refeicao = ?, dt_refeicao = TO_DATE(?, 'DD/MM/YY'),  hr_refeicao = ?, ds_descricao = ?, nr_calorias = ? WHERE cd_refeicao = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, refeicao.getTipoRefeicao().getCodTipoRefeicao());
			stmt.setString(2, refeicao.getData());
			stmt.setString(3, refeicao.getHora());
			stmt.setString(4, refeicao.getDescricao());
			stmt.setInt(5, refeicao.getCalorias());
			stmt.setInt(6, refeicao.getCodigoRefeicao());
			

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
			String sql = "DELETE FROM T_HT_REFEICAO WHERE cd_refeicao = ?";
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
	public Refeicao buscar(int id) {
		Refeicao refeicao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_REFEICAO NATURAL JOIN T_HT_TIPO_REFEICAO WHERE cd_refeicao = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("cd_refeicao");
				int usuario = rs.getInt("cd_usuario");
				int tipo = rs.getInt("cd_tipo_refeicao");
				String data = rs.getString("dt_refeicao");
				String hora = rs.getString("hr_refeicao");
				String descricao = rs.getString("ds_descricao");
				int calorias = rs.getInt("nr_calorias");
				
				String tipoRef = rs.getString("ds_tipo_refeicao");
				
				TipoRefeicao categoria = new TipoRefeicao(tipo, tipoRef);
				
				
				refeicao = new Refeicao(codigo, usuario, categoria, data, hora, descricao, calorias);
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
		return refeicao;
	}

	@Override
	public List<Refeicao> listar() {
		List<Refeicao> lista = new ArrayList<Refeicao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_REFEICAO  NATURAL JOIN T_HT_TIPO_REFEICAO ORDER BY cd_refeicao DESC");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("cd_refeicao");
				int usuario = rs.getInt("cd_usuario");
				int tipo = rs.getInt("cd_tipo_refeicao");
				String data = rs.getString("dt_refeicao");
				String hora = rs.getString("hr_refeicao");
				String descricao = rs.getString("ds_descricao");
				int calorias = rs.getInt("nr_calorias");
				
				String tipoRef = rs.getString("ds_tipo_refeicao");
				
				TipoRefeicao categoria = new TipoRefeicao(tipo, tipoRef);
				
				
				Refeicao refeicao = new Refeicao(codigo, usuario, categoria, data, hora, descricao, calorias);
				lista.add(refeicao);
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
