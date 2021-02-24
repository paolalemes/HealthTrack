package br.com.fiap.healthtrack.bean;

import java.io.Serializable;
/**
 * Classe que abstrai a Pressão arterial
 * @author Paola
 * @version 1.0
 */

public class Pressao extends Dado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigoPressao;
	private int sistolica;
	private int diastolica;

	//Construtor padrao
	public Pressao() {
		
	}
	
	//Construtor de classe
	public Pressao(int sistolica, int diastolica) {
		this.sistolica = sistolica;
		this.diastolica = diastolica;
	}
	
	public Pressao(int usuario, String data, String hora, int sistolica, int diastolica) {
		super.setUsuario(usuario);
		super.setData(data);
		super.setHora(hora);
		this.sistolica = sistolica;
		this.diastolica = diastolica;
	}
	
	public Pressao(int codigo, int usuario, String data, String hora, int sistolica, int diastolica) {
		this.codigoPressao = codigo;
		super.setUsuario(usuario);
		super.setData(data);
		super.setHora(hora);
		this.sistolica = sistolica;
		this.diastolica = diastolica;
	}
	
	//Metodos
	/**
	 * Consulta pressao sistólica
	 * @return sistolica a ser consultada
	 */
	public int getSistolica() {
		return sistolica;
	}
	
	/**
	 * Atrbui pressão sistólica
	 * @param sistolica a ser adicionada
	 */
	public void setSistolica(int sistolica) {
		this.sistolica = sistolica;
	}
	/**
	 * Consulta pressao diastólica
	 * @return diastolica a ser consultada
	 */
	public int getDiastolica() {
		return diastolica;
	}
	/**
	 * Atrbui pressão diastólica
	 * @param diastolica a ser adicionada
	 */
	public void setDiastolica(int diastolica) {
		this.diastolica = diastolica;
	}
	
	/**
	 * Pressão a ser consultada
	 * @return sistolica e diastolica
	 */
	public String getPressao() {
		return this.sistolica + "/" + this.diastolica;
	}

	public int getCodigoPressao() {
		return codigoPressao;
	}

	public void setCodigoPressao(int codigoPressao) {
		this.codigoPressao = codigoPressao;
	}
	
	
}
