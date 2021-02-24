package br.com.fiap.healthtrack.bean;

import java.io.Serializable;

import br.com.fiap.healthtrack.util.CriptografiaUtils;

/**
 * Classe que abstrai um usuário
 * @author Paola
 * @version 1.0
 */

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos da classe Usuário
	private int codigoUsuario;
	private String nome;
	private String email;
	private int altura;
	private String genero;
	private String nascimento;
	private String senha;
	
	//Construtor padrão
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

	//Métodos
	
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		setSenha(senha);
	}

	/**
	 * Consultar nome do usuário
	 * @return nome do usuário
	 */
	public String getNome() {
		return nome;
	}
	
	
	/**
	 * Atribuir nome ao usuário
	 * @param nome ao usuario
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * Consultar email do usuário
	 * @return email do usuário
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Atribuir email ao usuário
	 * @param email ao usuário
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Consultar altura do usuário
	 * @return altura do usuário
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * Atribuir alura ao usuário
	 * @param altura ao usuário
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * Consultar gênero do usuário
	 * @return genero do usuário
	 */
	public String getGenero() {
		return genero;
	}
	
	
	/**
	 * Atribuir gênero ao usuário
	 * @param genero do usuario
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Consultar data de nascimento do usuário
	 * @return nascimento do usuário
	 */
	public String getNascimento() {
		return nascimento;
	}

	
	/**
	 * Atribuir dada de nascimento ao usuário
	 * @param nascimento do usuário
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
