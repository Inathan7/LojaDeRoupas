package controller;

import java.util.ArrayList;

import dao.EncomendaDAO;
import dao.abstractFactory.FabricaDAO;
import dao.abstractFactory.FabricaDAOXML;
import model.Encomenda;
import model.Roupa;

public class ControllerEncomenda {
	
	private FabricaDAO fabricaDAO = new FabricaDAOXML();
	private EncomendaDAO encomendaDAO = fabricaDAO.criarEncomendaDAO();
	
	private ArrayList<Encomenda> encomendas;
	
	public void addEncomenda(String nomeCliente, String nomeRoupa, String tamanhoRoupa, String telefone, String descricao, int ID_Encomenda) throws Exception {
		encomendaDAO.createEncomenda(new Encomenda(nomeCliente, nomeRoupa, tamanhoRoupa,telefone, descricao, ID_Encomenda));
	}

	public ArrayList<Encomenda> loadEncomenda(){
		return encomendaDAO.load("encomendas");
	}
	
	public int quantidadeDeEncomendas(){
		return encomendaDAO.load("encomendas").size();
	}
	
	public Encomenda searchEncomenda(int id){
		ArrayList<Encomenda> encomendas = encomendaDAO.load("encomendas");
		for(Encomenda encomenda:encomendas){
			if(id == encomenda.getID_Encomenda()){
				return encomenda;
			}
		}
		return null;
	}
	
	public int contId() {
		encomendas = loadEncomenda();
		return encomendas.size()+1;     // Essa lógica é feita para evitar o acoplamento entre camada de negócio e view.
	}

}
