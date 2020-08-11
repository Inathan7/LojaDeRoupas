package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Administrador;
import model.iterator.IterarColecaoConcreto;
import model.iterator.Iterator;

public class AdminDAOJDBC implements AdminDAO{
	
	private Administrador admin = new Administrador();
	private ConnectionBD connectionBD;
	private ArrayList<Administrador> admins = new ArrayList<Administrador>();
	private ArrayList<Administrador> adminsExcluidos = new ArrayList<Administrador>();
	private IterarColecaoConcreto iterarAdmin = new IterarColecaoConcreto(admins);
	private Iterator iteratorArrayAdmin = iterarAdmin.criarIterator();
	
	
	public AdminDAOJDBC() {
		checkConnection();
	}
	
	public void checkConnection() {
		connectionBD = ConnectionBD.getInstance();
	}
	
	public void finishConnection() {
		connectionBD.closeConnection();
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Administrador> load() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAdmin(Administrador admin) {
		String nome = "'" + admin.getNome() + "'";
		String email = "'" + admin.getEmail() + "'";
		String senha = "'" + admin.getSenha() + "'";
		String sexo = "'" + admin.getSexo() + "'";
		String query = "(" + nome + ", " + ", " + email + ", " + senha + ", " + sexo + " )";
		
		if(connectionBD.isConnectionValid()) {
			try {
				connectionBD.getConnection().executeUpdate("insert into admin (nome, email, senha, sexo) values "+ query);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Administrador readAdmin() {
		
		return null;
	}


	@Override
	public void deleteAdmin(Administrador admin) {
		
		String nome = "'" + admin.getNome() + "'";
		
		if (connectionBD.isConnectionValid()) {
			try {
				connectionBD.getConnection().executeUpdate("delete from admin where nome = " + nome);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public boolean createAdminXML(Administrador admin) {
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public void deleteAdminXML() {
		// TODO Auto-generated method stub
		
	}

	


}
