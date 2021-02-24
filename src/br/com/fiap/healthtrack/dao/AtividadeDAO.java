package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.bean.Atividade;
import br.com.fiap.healthtrack.exception.DBException;


public interface AtividadeDAO {
	
	void cadastrar(Atividade atividade) throws DBException;
	void atualizar(Atividade atividade) throws DBException;
	void remover(int codigo) throws DBException;
	Atividade buscar(int id);
	List<Atividade> listar();
}