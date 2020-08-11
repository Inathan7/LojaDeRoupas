package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Administrador;

public class AdminDAOXML implements AdminDAO {

	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	private File arquivo;
	private ArrayList<Administrador> admin = new ArrayList<Administrador>();
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		arquivo = new File("admin.xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(admin);
		try {
			arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Administrador> load() {
		arquivo = new File("admin.xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (ArrayList<Administrador>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Administrador>();
	}

	@Override
	public boolean createAdminXML(Administrador administrador) {
		// TODO Auto-generated method stub
		admin = load();
		if (admin.isEmpty()) {
			admin.add(administrador);
			save();
			return true;
		}
		return false;
		
	}

	@Override
	public void deleteAdminXML() {
		// TODO Auto-generated method stub
		admin = load();
		admin.remove(0);
	}

	@Override
	public Administrador readAdmin() {
		// TODO Auto-generated method stub
		admin = load();
		if (admin.isEmpty())
			return null;
		return admin.get(0);
	}

	@Override
	public void createAdmin(Administrador admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdmin(Administrador admin) {
		// TODO Auto-generated method stub
		
	}
}
