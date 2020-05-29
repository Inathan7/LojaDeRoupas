package model;

public class Encomenda {
	
	private String nomeCliente;
	private String nomeRoupa;
	private String tamanhoRoupa;
	private String telefone;
	private String descricao;
	private int ID_Encomenda;
	
	public Encomenda(String nomeCliente, String nomeRoupa, String tamanhoRoupa, String telefone, String descricao, int ID_Encomenda) {
		this.ID_Encomenda = ID_Encomenda;
		this.nomeCliente = nomeCliente;
		this.nomeRoupa = nomeRoupa;
		this.tamanhoRoupa = tamanhoRoupa;
		this.telefone = telefone;
		this.descricao = descricao;
	}

	public int getID_Encomenda() {
		return ID_Encomenda;
	}
	public void setID_Encomenda(int ID_Encomenda) {
		this.ID_Encomenda = ID_Encomenda;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeRoupa() {
		return nomeRoupa;
	}
	public void setNomeRoupa(String nomeRoupa) {
		this.nomeRoupa = nomeRoupa;
	}
	public String getTamanhoRoupa() {
		return tamanhoRoupa;
	}
	public void setTamanhoRoupa(String tamanhoRoupa) {
		this.tamanhoRoupa = tamanhoRoupa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
