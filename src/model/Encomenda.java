package model;

public class Encomenda {
	
	private String nomeCliente;
	private String nomeRoupa;
	private String tamanhoRoupa;
	private long ID_Encomenda;
	
	public Encomenda(String nomeCliente, String nomeRoupa, String tamanhoRoupa, long ID_Encomenda) {
		this.ID_Encomenda = ID_Encomenda;
		this.nomeCliente = nomeCliente;
		this.nomeRoupa = nomeRoupa;
		this.tamanhoRoupa = tamanhoRoupa;
	}

	public long getID_Pedido() {
		return ID_Encomenda;
	}
	public void setID_Pedido(long iD_Pedido) {
		ID_Encomenda = iD_Pedido;
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
}
