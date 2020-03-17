package controller;

import dao.RoupaDAO;
import dao.abstractFactory.FabricaDAO;
import dao.abstractFactory.FabricaDAOXML;
import model.Roupa;

public class ControllerRoupa {
	
	private FabricaDAO fabricaDAO = new FabricaDAOXML();
	private RoupaDAO roupaDAO = fabricaDAO.criarRoupaDAO();
	
//	public ControllerRoupa(String nome, float preco, String tamanho) {
		
//		Roupa roupa = new Roupa(nome, preco, tamanho);
		
//	}
	
	public void addRoupa(String nome, float preco, String tamanho) {
		roupaDAO.createRoupa(new Roupa(nome, preco, tamanho));
	}

}
