package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.fiap.healthtrack.bean.Usuario;
import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO {
	private Connection conexao;
	
	@Override
	public void cadastrar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_USUARIO (cd_usuario, nm_usuario, ds_genero, nr_altura, ds_email, ds_senha, dt_nascimento) VALUES (SQ_USUARIO.nextval, ?, ?, ?, ?, ?, ?)";
	        stmt = conexao.prepareStatement(sql);
	        stmt.setString(1, usuario.getNome());
	        stmt.setString(2, usuario.getGenero());
	        stmt.setInt(3, usuario.getAltura());
	        stmt.setString(4, usuario.getEmail());
	        stmt.setString(5, usuario.getSenha());
	        stmt.setString(6, usuario.getNascimento());
	        
	        stmt.executeUpdate();
		} catch (SQLException e) {
	        e.printStackTrace();
	        throw new DBException("Erro ao cadastrar!");
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
	public Usuario buscar(String email, String senha) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_USUARIO WHERE ds_email = ? AND ds_senha= ?");
			stmt.setString(1, email);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int codigoUsuario = rs.getInt("cd_usuario");
				String nome = rs.getString("nm_usuario");
				String genero = rs.getString("ds_genero");
				int altura = rs.getInt("nr_altura");
				String emailUser = rs.getString("ds_email");
				String senhaUser = rs.getString("ds_senha");
				String nascimento = rs.getString("dt_nascimento");
				
				usuario = new Usuario(codigoUsuario, nome, emailUser, altura, genero, nascimento, senhaUser);
			}
		} catch (SQLException e) {
	        e.printStackTrace();
	      } finally {
	        try {
	          stmt.close();
	          rs.close();
	          conexao.close();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	   }
		return usuario;
	}

	@Override
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_USUARIO WHERE ds_email = ? AND ds_senha = ?");
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			rs = stmt.executeQuery();

			if (rs.next()){
				return true;
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
		return false;
	}
}
	

	
