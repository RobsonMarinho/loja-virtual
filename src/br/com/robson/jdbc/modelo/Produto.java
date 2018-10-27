package br.com.robson.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;

	// Construtor
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[produto: %d %s %s]");
	}
	
	
	
}