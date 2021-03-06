package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.bean.Peso;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OraclePesoDAO implements PesoDAO{
	
	private Connection conexao;

	@Override
	public void cadastrar(Peso peso) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_PESO (cd_peso, cd_usuario, dt_peso, hr_peso, vl_peso) VALUES (SQ_PESO.nextval, ?, TO_DATE(?, 'DD/MM/YY'), ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getUsuario());
			stmt.setString(2, peso.getData());
			stmt.setString(3, peso.getHora());
			stmt.setDouble(4, peso.getPeso());
			

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
	public void atualizar(Peso peso) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_HT_PESO SET dt_peso = TO_DATE(?, 'DD/MM/YY'), hr_peso = ?, vl_peso = ? WHERE cd_peso = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, peso.getData());
			stmt.setString(2, peso.getHora());
			stmt.setDouble(3, peso.getPeso());
			stmt.setInt(4, peso.getCodigoPeso());

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
			String sql = "DELETE FROM T_HT_PESO WHERE cd_peso = ?";
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
	public Peso buscar(int codigo) {
		Peso peso = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_PESO WHERE cd_peso = ?");
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()){
				int cod = rs.getInt("cd_peso");
				int usuario = rs.getInt("cd_usuario");
				String data = rs.getString("dt_peso");
				String hora = rs.getString("hr_peso");
				double kg = rs.getDouble("vl_peso");
				
				
				peso = new Peso(cod, usuario, data, hora, kg);
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
		return peso;
	}

	@Override
	public List<Peso> listar() {
		List<Peso> lista = new ArrayList<Peso>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_PESO ORDER BY cd_peso DESC");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int cod = rs.getInt("cd_peso");
				int usuario = rs.getInt("cd_usuario");
				String data = rs.getString("dt_peso");
				String hora = rs.getString("hr_peso");
				double kg = rs.getDouble("vl_peso");
				
				Peso peso = new Peso(cod, usuario, data, hora, kg);
				lista.add(peso);
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
