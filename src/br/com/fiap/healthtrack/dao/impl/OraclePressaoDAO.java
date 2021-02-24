package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.bean.Pressao;
import br.com.fiap.healthtrack.dao.PressaoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OraclePressaoDAO implements PressaoDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Pressao pressao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_PRESSAO (cd_pressao, cd_usuario, dt_pressao, hr_pressao, nr_sistolica, nr_diastolica) VALUES (SQ_PRESSAO.nextval, ?, TO_DATE(?, 'DD/MM/YY'), ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pressao.getUsuario());
			stmt.setString(2, pressao.getData());
			stmt.setString(3, pressao.getHora());
			stmt.setInt(4, pressao.getSistolica());
			stmt.setInt(5, pressao.getDiastolica());
			
			
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
	public void atualizar(Pressao pressao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_HT_PRESSAO SET dt_pressao = TO_DATE(?, 'DD/MM/YY'),  hr_pressao = ?, nr_sistolica = ?,  nr_diastolica = ? WHERE cd_pressao = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, pressao.getData());
			stmt.setString(2, pressao.getHora());
			stmt.setInt(3, pressao.getSistolica());
			stmt.setInt(4, pressao.getDiastolica());
			stmt.setInt(5, pressao.getCodigoPressao());
			

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
			String sql = "DELETE FROM T_HT_PRESSAO WHERE cd_pressao = ?";
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
	public Pressao buscar(int id) {
		Pressao pressao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_PRESSAO WHERE cd_pressao = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("cd_pressao");
				int usuario = rs.getInt("cd_usuario");
				String data = rs.getString("dt_pressao");
				String hora = rs.getString("hr_pressao");
				int sistolica = rs.getInt("nr_sistolica");
				int diastolica = rs.getInt("nr_diastolica");
				
				
				pressao = new Pressao(codigo, usuario, data, hora, sistolica, diastolica);
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
		return pressao;
	}

	@Override
	public List<Pressao> listar() {
		List<Pressao> lista = new ArrayList<Pressao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_PRESSAO ORDER BY cd_pressao DESC");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("cd_pressao");
				int usuario = rs.getInt("cd_usuario");
				String data = rs.getString("dt_pressao");
				String hora = rs.getString("hr_pressao");
				int sistolica = rs.getInt("nr_sistolica");
				int diastolica = rs.getInt("nr_diastolica");
				
				Pressao pressao = new Pressao(codigo, usuario, data, hora, sistolica, diastolica);
				lista.add(pressao);
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
