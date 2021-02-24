package br.com.fiap.healthtrack.bean;

import java.io.Serializable;

/**
 * Classe que abstrai uma atividade fisica
 * @author Paola
 * @version 1.0
 */

public class Atividade extends Dado implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigoAtividade;
	private TipoAtividade tipoAtividade;
	private int calorias;
	
	//Construtor padrao
	public Atividade() {
		
	}
	
	//Construtor de classe
	public Atividade(TipoAtividade tipo, int calorias) {
		this.tipoAtividade = tipo;
		this.calorias = calorias;
	}
	
	public Atividade(int usuario, TipoAtividade tipoAtividade, String data, String hora, String descricao, int calorias) {
		super.setUsuario(usuario);
		this.tipoAtividade = tipoAtividade;
		super.setData(data);
		super.setHora(hora);
		super.setDescricao(descricao);
		this.calorias = calorias;
	}
	
	public Atividade(int codigoAtividade, int usuario, TipoAtividade tipoAtividade, String data, String hora, String descricao, int calorias) {
		this.codigoAtividade = codigoAtividade;
		super.setUsuario(usuario);
		this.tipoAtividade = tipoAtividade;
		super.setData(data);
		super.setHora(hora);
		super.setDescricao(descricao);
		this.calorias = calorias;
	}
	
	
	
	//Metodos
	/**
	 * Consultar codigo da atividade
	 * @return codigoAtividade
	 */
	public int getCodigoAtividade() {
		return codigoAtividade;
	}

	
	/**
	 * Atribuir codigo da atividade
	 * @param codigoAtividade
	 */
	public void setCodigoAtividade(int codigoAtividade) {
		this.codigoAtividade = codigoAtividade;
	}
	
	
	/**
	 * Consultar o tipo de atividade
	 * @return tipo da Atividade
	 */
	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}
	
	/**
	 * Atribui o tipo de atividade realizada
	 * @param tipoAtividade que o usuario exerceu
	 */
	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	
	/**
	 * Consulta a quantidade de calorias da atividade realizada
	 * @return calorias da atividade
	 */
	public int getCalorias() {
		return calorias;
	}
	
	/**
	 * Atribui calorias a atividade realizada
	 * @param calorias da atividade
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	
	
	
	
}
