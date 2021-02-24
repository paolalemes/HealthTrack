package br.com.fiap.healthtrack.bean;

import java.io.Serializable;

public class Batimento extends Dado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int codigoBatimento;
	private int batimentos;
	
	//Construtor Padrão
	public Batimento() {
		
	}
	
	// Construtor de classe
	public Batimento(int codigo, int usuario, String data, String hora, int batimentos) {
		this.codigoBatimento = codigo;
		super.setUsuario(usuario);
		super.setData(data);
		super.setHora(hora);
		this.batimentos = batimentos;
	}
	
	
	public Batimento(int usuario, String data, String hora,int batimentos) {
		super.setUsuario(usuario);
		super.setData(data);
		super.setHora(hora);
		this.batimentos = batimentos;
	}
	
	//Métodos
	public int getBatimentos() {
		return batimentos;
	}

	public void setBatimentos(int batimentos) {
		this.batimentos = batimentos;
	}

	public int getCodigoBatimento() {
		return codigoBatimento;
	}

	public void setCodigoBatimento(int codigoBatimento) {
		this.codigoBatimento = codigoBatimento;
	}
	
	
	
	
	
	
	
	
	
}
	
