package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.bean.Batimento;
import br.com.fiap.healthtrack.dao.BatimentosDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OracleBatimentoDAO implements BatimentosDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Batimento batimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_BATIMENTO (cd_batimento, cd_usuario, dt_batimento, hr_batimento, nr_batimento) VALUES (SQ_BATIMENTO.nextval, ?, TO_DATE(?, 'DD/MM/YY'), ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, batimento.getUsuario());
			stmt.setString(2, batimento.getData());
			stmt.setString(3, batimento.getHora());
			stmt.setInt(4, batimento.getBatimentos());
			

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
	public void atualizar(Batimento batimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_HT_BATIMENTO SET dt_batimento = TO_DATE(?, 'DD/MM/YY'), hr_batimento = ?, nr_batimento = ? WHERE cd_batimento = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, batimento.getData());
			stmt.setString(2, batimento.getHora());
			stmt.setInt(3, batimento.getBatimentos());
			stmt.setInt(4, batimento.getCodigoBatimento());
			

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
			String sql = "DELETE FROM T_HT_BATIMENTO WHERE cd_batimento = ?";
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
	public Batimento buscar(int codigo) {
		Batimento batimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_BATIMENTO WHERE cd_batimento = ?");
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()){
				int cod = rs.getInt("cd_batimento");
				int usuario = rs.getInt("cd_usuario");
				String data = rs.getString("dt_batimento");
				String hora = rs.getString("hr_batimento");
				int batimentos = rs.getInt("nr_batimento");
				
				
				batimento = new Batimento(cod, usuario, data, hora, batimentos);
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
		return batimento;
	}

	@Override
	public List<Batimento> listar() {
		List<Batimento> lista = new ArrayList<Batimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_BATIMENTO ORDER BY cd_batimento DESC");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int cod = rs.getInt("cd_batimento");
				int usuario = rs.getInt("cd_usuario");
				String data = rs.getString("dt_batimento");
				String hora = rs.getString("hr_batimento");
				int batimentos = rs.getInt("nr_batimento");
				
				Batimento batimento = new Batimento(cod, usuario, data, hora, batimentos);
				lista.add(batimento);
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
