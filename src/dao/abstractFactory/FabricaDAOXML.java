package dao.abstractFactory;

import dao.AdminDAO;
import dao.AdminDAOXML;
import dao.RoupaDAO;
import dao.RoupaDAOXML;

public class FabricaDAOXML implements FabricaDAO{

	@Override
	public AdminDAO criarAdminDAO() {
		return new AdminDAOXML();
	}

	@Override
	public RoupaDAO criarRoupaDAO() {
		return new RoupaDAOXML();
	}

}
