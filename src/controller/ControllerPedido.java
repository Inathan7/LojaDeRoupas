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

	public void addPedido(String email, String nome, String telefone, ArrayList<Roupa> roupas) {
		pedidoDAO.createPedido(new Pedido(email, nome, telefone, roupas));
	}

	public ArrayList<Pedido> loadPedido(){
		return pedidoDAO.load("pedidos");
	}

}
