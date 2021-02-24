package br.com.fiap.healthtrack.bean;

public class TipoRefeicao {
	
	private int codTipoRefeicao;
	
	private String nomeRefeicao;
	

	public TipoRefeicao() {
	
	}

	public TipoRefeicao(int codTipoRefeicao, String nomeRefeicao) {
		super();
		this.codTipoRefeicao = codTipoRefeicao;
		this.nomeRefeicao = nomeRefeicao;
	}

	public int getCodTipoRefeicao() {
		return codTipoRefeicao;
	}

	public void setCodTipoRefeicao(int codTipoRefeicao) {
		this.codTipoRefeicao = codTipoRefeicao;
	}

	public String getNomeRefeicao() {
		return nomeRefeicao;
	}

	public void setNomeRefeicao(String nomeRefeicao) {
		this.nomeRefeicao = nomeRefeicao;
	}
	

	
	
	

}
