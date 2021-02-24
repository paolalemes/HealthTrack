package br.com.fiap.healthtrack.bean;

import java.io.Serializable;

/**
 * Classe que abstrai uma refeição
 * @author Paola
 * @version 1.0
 */

public class Refeicao extends Dado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigoRefeicao;
	private TipoRefeicao tipoRefeicao;
	private int calorias;
	
	//construtor padrao
	public Refeicao() {
		
	}
	
	//Contrutor de classe
	public Refeicao(TipoRefeicao tipo, int calorias) {
		this.tipoRefeicao = tipo;
		this.calorias = calorias;
	}
	
	public Refeicao(int codigoRefeicao, int usuario, TipoRefeicao tipoRefeicao, String data, String hora, String descricao, int calorias) {
		this.codigoRefeicao = codigoRefeicao;
		super.setUsuario(usuario);
		this.tipoRefeicao = tipoRefeicao;
		super.setData(data);
		super.setHora(hora);
		super.setDescricao(descricao);
		this.calorias = calorias;
	}
	
	public Refeicao(int usuario, TipoRefeicao tipoRefeicao, String data, String hora, String descricao, int calorias) {
		super.setUsuario(usuario);
		this.tipoRefeicao = tipoRefeicao;
		super.setData(data);
		super.setHora(hora);
		super.setDescricao(descricao);
		this.calorias = calorias;
	}
	
	
	//Metodos
	/**
	 * Consulta o tipo de refeição
	 * @return tipoRefeicao adicionada
	 */
	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}
	
	/**
	 * Atribui um tipo de refeição
	 * @param tipoRefeicao a ser adicionada
	 */
	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}
	
	/**
	 * Consulta a quantidade de calorias da refeição
	 * @return calorias da refeição
	 */
	public int getCalorias() {
		return calorias;
	}
	
	/**
	 * Atribui a quantidade de calorias da refeição
	 * @param calorias consumidas na refeição
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public int getCodigoRefeicao() {
		return codigoRefeicao;
	}

	public void setCodigoRefeicao(int codigoRefeicao) {
		this.codigoRefeicao = codigoRefeicao;
	}
	
	
	
	
}
