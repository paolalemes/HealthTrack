package br.com.fiap.healthtrack.bean;

import java.io.Serializable;


/**
 * Classe que abstrai um dado 
 * @author Paola
 * @version 1.0
 */

public abstract class Dado implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int usuario;
	private String data;
	private String hora;
	private String descricao;

	
	//Construtor padrão
	public Dado() {
		
	}
	
	//Construtor de classe
	public Dado(String data, String hora, String descricao) {
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
	}

	//Metodos
	/**
	 * Consultar a data de entrada do dado 
	 * @return data do dado
	 */
	public String getData() {
		return data;
	}

	/**
	 * Atribuir uma data ao dado
	 * @param string do dado
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Consultar a hora de entrada deste dado
	 * @return hora do dado
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * Atribuir hora ao dado
	 * @param hora do dado
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	/**
	 * Consultar descrição do dado
	 * @return descricao do dado 
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Atribuir descrição ao dado 
	 * @param descricao do dado
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Consultar usuario
	 * @return usuario do dado
	 */
	public int getUsuario() {
		return usuario;
	}

	/**
	 * Atribuir usuario ao dado cadastrado 
	 * @param usuario a ser cadastrado no Dado inserido
	 */
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
