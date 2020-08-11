package dao.abstractFactory;

import dao.AdminDAO;
import dao.AdminDAOJDBC;
import dao.EncomendaDAO;
import dao.EncomendaDAOJDBC;
import dao.PedidoDAO;
import dao.RoupaDAO;
import dao.RoupaDAOJDBC;

public class FabricaDAOJDBC implements FabricaDAO{
	
	@Override
	public AdminDAO criarAdminDAO() {
		return new AdminDAOJDBC();
	}

	@Override
	public RoupaDAO criarRoupaDAO() {
		return new RoupaDAOJDBC();
	}

	@Override
	public PedidoDAO criarPedidoDAO() {
		return null;
	}

	@Override
	public EncomendaDAO criarEncomendaDAO() {
		return new EncomendaDAOJDBC();
	}

}
