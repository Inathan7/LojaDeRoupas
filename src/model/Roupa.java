package model;

public class Roupa {
	
	private int id;
	private String nome;
	private float preco;
	private String tamanho;
//	private String tipo;
//	private int quantidadeEstoque;
//	private String descricacao;
	
	public Roupa() {
		// TODO Auto-generated constructor stub
	}
	
	public Roupa(String nome, float preco, String tamanho) {
		
		this.nome = nome;
		this.preco = preco;
		this.tamanho = tamanho;
		
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
