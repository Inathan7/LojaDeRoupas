package dao;

import java.util.ArrayList;

import model.Administrador;

public interface AdminDAO {

	public void save();
	
	public ArrayList<Administrador> load();
	
	public boolean createAdminXML(Administrador admin);
	
	public void createAdmin(Administrador admin);
	
	public void deleteAdminXML();
	
	public void deleteAdmin(Administrador admin);
	
	public Administrador readAdmin();
}

