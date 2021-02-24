package br.com.fiap.healthtrack.dao;



import br.com.fiap.healthtrack.bean.Usuario;
import br.com.fiap.healthtrack.exception.DBException;

public interface UsuarioDAO {
	
	void cadastrar(Usuario usuario) throws DBException;
	
	Usuario buscar(String email, String senha);
	
	boolean validarUsuario(Usuario usuario);

}
