package br.com.fiap.healthtrack.bean;

import java.io.Serializable;

import br.com.fiap.healthtrack.util.CriptografiaUtils;

/**
 * Classe que abstrai um usu�rio
 * @author Paola
 * @version 1.0
 */

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos da classe Usu�rio
	private int codigoUsuario;
	private String nome;
	private String email;
	private int altura;
	private String genero;
	private String nascimento;
	private String senha;
	
	//Construtor padr�o
	public Usuario() {
		
	}
	
	//Construtor de classe
	
	
	public Usuario(String nome, String email, int altura, String genero, String nascimento, String senha) {
		this.nome = nome;
		this.email = email;
		this.altura = altura;
		this.genero = genero;
		this.nascimento = nascimento;
		setSenha(senha);
	}

	public Usuario(int codigoUsuario, String nome, String email, int altura, String genero, String nascimento,
			String senha) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.nome = nome;
		this.email = email;
		this.altura = altura;
		this.genero = genero;
		this.nascimento = nascimento;
		setSenha(senha);
	}

	//M�todos
	
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		setSenha(senha);
	}

	/**
	 * Consultar nome do usu�rio
	 * @return nome do usu�rio
	 */
	public String getNome() {
		return nome;
	}
	
	
	/**
	 * Atribuir nome ao usu�rio
	 * @param nome ao usuario
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * Consultar email do usu�rio
	 * @return email do usu�rio
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Atribuir email ao usu�rio
	 * @param email ao usu�rio
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Consultar altura do usu�rio
	 * @return altura do usu�rio
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * Atribuir alura ao usu�rio
	 * @param altura ao usu�rio
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * Consultar g�nero do usu�rio
	 * @return genero do usu�rio
	 */
	public String getGenero() {
		return genero;
	}
	
	
	/**
	 * Atribuir g�nero ao usu�rio
	 * @param genero do usuario
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Consultar data de nascimento do usu�rio
	 * @return nascimento do usu�rio
	 */
	public String getNascimento() {
		return nascimento;
	}

	
	/**
	 * Atribuir dada de nascimento ao usu�rio
	 * @param nascimento do usu�rio
	 */
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	
	
}
