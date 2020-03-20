package dao;

import java.util.ArrayList;
import model.Pedido;

public interface PedidoDAO {
	
	public void save(String pedidoArquivo);

	public ArrayList<Pedido> load(String pedidoArquivo);

	public void createPedido(Pedido pedido);

	public ArrayList<Pedido> readPedido();

	public ArrayList<Pedido> readPedidosExcluidos();

	public void deletePedido(Pedido pedido);

}
