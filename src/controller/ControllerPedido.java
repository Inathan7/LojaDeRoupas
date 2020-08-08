package controller;

import java.util.ArrayList;

import dao.PedidoDAO;
import dao.abstractFactory.FabricaDAO;
import dao.abstractFactory.FabricaDAOXML;
import model.Pedido;
import model.Roupa;

public class ControllerPedido {

	private FabricaDAO fabricaDAO = new FabricaDAOXML();
	private PedidoDAO pedidoDAO = fabricaDAO.criarPedidoDAO();
	
	//modifiquei a entrada do método para receber o id
	public void addPedido(long id,String email, String nome, String telefone, ArrayList<Roupa> roupas) throws Exception {
		pedidoDAO.createPedido(new Pedido(id,email, nome, telefone, roupas));
	}

	public ArrayList<Pedido> loadPedido(){
		return pedidoDAO.load("pedidos");
	}
	//adicionei esse método para que devolva a quantidade de pedido para que essa
	//lógica não esteja na view
	public int quantidadeDePedidos(){
		return pedidoDAO.load("pedidos").size();
	}

}
