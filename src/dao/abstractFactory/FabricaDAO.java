package dao.abstractFactory;

import dao.AdminDAO;
import dao.PedidoDAO;
import dao.RoupaDAO;

public interface FabricaDAO {

	public AdminDAO criarAdminDAO();
	
	public RoupaDAO criarRoupaDAO();
	
	public PedidoDAO criarPedidoDAO();
}

