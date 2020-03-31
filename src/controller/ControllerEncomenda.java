package controller;

import java.util.ArrayList;

import dao.EncomendaDAO;
import dao.abstractFactory.FabricaDAO;
import dao.abstractFactory.FabricaDAOXML;
import model.Encomenda;

public class ControllerEncomenda {
	
	private FabricaDAO fabricaDAO = new FabricaDAOXML();
	private EncomendaDAO encomendaDAO = fabricaDAO.criarEncomendaDAO();
	
	public void addEncomenda(String nomeCliente, String nomeRoupa, String tamanhoRoupa, long ID_Encomenda) {
		encomendaDAO.createEncomenda(new Encomenda(nomeCliente, nomeRoupa, tamanhoRoupa, ID_Encomenda));
	}

	public ArrayList<Encomenda> loadEncomenda(){
		return encomendaDAO.load("encomendas");
	}
	
	public int quantidadeDeEncomendas(){
		return encomendaDAO.load("encomendas").size();
	}

}
