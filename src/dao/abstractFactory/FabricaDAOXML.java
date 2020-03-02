package dao.abstractFactory;

import dao.AdminDAO;
import dao.AdminDAOXML;

public class FabricaDAOXML implements FabricaDAO{

	@Override
	public AdminDAO criarAdminDAO() {
		// TODO Auto-generated method stub
		return new AdminDAOXML();
	}

}
