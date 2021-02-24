package br.com.fiap.healthtrack.bean;

public class TipoAtividade {
	
	private int codTipoAtividade;
	
	public TipoAtividade() {
		
	}

	private String nomeAtividade;
	
	

	public TipoAtividade(int codTipoAtividade, String nomeAtividade) {
		super();
		this.codTipoAtividade = codTipoAtividade;
		this.nomeAtividade = nomeAtividade;
	}

	public int getCodTipoAtividade() {
		return codTipoAtividade;
	}

	public void setCodTipoAtividade(int codTipoAtividade) {
		this.codTipoAtividade = codTipoAtividade;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	
	

}
