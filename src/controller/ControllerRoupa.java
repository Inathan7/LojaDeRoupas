package controller;

import java.util.ArrayList;

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
	
	public void addRoupa(String nome, float preco, String tamanho,int id) {
		roupaDAO.createRoupa(new Roupa(nome, preco, tamanho,id));
	}
	
	public ArrayList<Roupa> loadRoupa(){
		return roupaDAO.load("roupas");
	}
	/*
	 * Adicionei o método de pesquisa para encontrar a roupa que o cliente escolheu
	 * na TelaListarRoupa.
	 */
	public Roupa searchRoupa(int id){
		ArrayList<Roupa> roupas = roupaDAO.load("roupas");
		for(Roupa roupa:roupas){
			if(id == roupa.getId()){
				return roupa;
			}
		}
		return null;
	}

}
