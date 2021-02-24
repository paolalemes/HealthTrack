package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.bean.Refeicao;
import br.com.fiap.healthtrack.exception.DBException;

public interface RefeicaoDAO {
	
	void cadastrar(Refeicao produto) throws DBException;
	void atualizar(Refeicao produto) throws DBException;
	void remover(int codigo) throws DBException;
	Refeicao buscar(int id);
	List<Refeicao> listar();

}
