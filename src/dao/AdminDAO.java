package dao;

import java.util.ArrayList;

import model.Administrador;

public interface AdminDAO {

	public void save();
	
	public ArrayList<Administrador> load();
	
	public boolean createAdmin(Administrador administrador);
	
	public void deleteAdmin();
	
	public Administrador readAdmin();
}

