package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.bean.Batimento;
import br.com.fiap.healthtrack.exception.DBException;

public interface BatimentosDAO {
	void cadastrar(Batimento batimento) throws DBException;
	void atualizar(Batimento batimento) throws DBException;
	void remover(int codigo) throws DBException;
	Batimento buscar(int codigo);
	List<Batimento> listar();

}
