package br.com.fiap.healthtrack.bean;

import java.io.Serializable;


/**
 * Classe que abstrai um peso
 * @author Paola
 * @version 1.0
 */

public class Peso extends Dado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int codigoPeso;
	private double peso;
	
	//Construtor Padrão
	public Peso() {
		
	}
	
	//Construtor de classe
	public Peso(String data, double peso) {
		super.setData(data);
		this.peso = peso;
	}
	
	public Peso(int usuario, String data, double peso) {
		super.setUsuario(usuario);
		super.setData(data);
		this.peso = peso;
	}
	
	public Peso(int codigo, int usuario, String data, double peso) {
		this.codigoPeso = codigo;
		super.setUsuario(usuario);
		super.setData(data);
		this.peso = peso;
	}
	
	public Peso(int usuario, String data, String hora, double peso) {
		super.setUsuario(usuario);
		super.setData(data);
		super.setHora(hora);
		this.peso = peso;
	}
	
	public Peso(int codigo, int usuario, String data, String hora, double peso) {
		this.setCodigoPeso(codigo);
		super.setUsuario(usuario);
		super.setData(data);
		super.setHora(hora);
		this.peso = peso;
	}
	
	
	//Métodos
	/**
	 * Consulta o peso adicionado
	 * @return peso que foi adicionado
	 */
	public double getPeso() {
		return peso;
	}
	
	/**
	 * Atribui um peso.
	 * @param peso a ser adicionado
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getCodigoPeso() {
		return codigoPeso;
	}

	public void setCodigoPeso(int codigoPeso) {
		this.codigoPeso = codigoPeso;
	}
	
	
}
