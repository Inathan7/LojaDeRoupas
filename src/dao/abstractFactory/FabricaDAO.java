package dao.abstractFactory;

import dao.AdminDAO;

public interface FabricaDAO {

	public AdminDAO criarAdminDAO();
}

