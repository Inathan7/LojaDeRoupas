package controller.facade;

import dao.AdminDAO;
import dao.abstractFactory.FabricaDAO;
import dao.abstractFactory.FabricaDAOXML;
import model.Administrador;
import model.Email;

public class FacadeAdministracao {

	private Email email = new Email();
	private FabricaDAO fabricaDAO = new FabricaDAOXML();
	private AdminDAO adminJDBC = fabricaDAO.criarAdminDAO();

	public boolean adicionarAdministrador(Administrador admin){
		//return central.adicionarAdministrador(admin);
		return adminJDBC.createAdminXML(admin);
	}

	public void excluirAdministrador(){
		//central.excluirAdministrador();	 
		adminJDBC.deleteAdminXML();
	}

	public Administrador getAdministrador(){
		//return central.getAdministrador();
		return adminJDBC.readAdmin();
	}

	public boolean enviarEmailComAnexo(String nome,String destino,String assunto,String msg,String arquivo){
		return email.enviarComAnexo(nome, destino, assunto, msg, arquivo); 
	}
	public boolean enviarEmail(String destino,String assunto,String msg){
		return email.enviarEmail(destino, assunto, msg);
	}
}
