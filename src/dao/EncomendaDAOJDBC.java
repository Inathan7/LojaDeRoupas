package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Encomenda;
import model.Roupa;
import model.iterator.IterarColecaoConcreto;
import model.iterator.Iterator;

public class EncomendaDAOJDBC implements EncomendaDAO{
	
	private Encomenda encomenda = new Encomenda();
	private ConnectionBD connectionBD;
	private ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();
	private ArrayList<Encomenda> encomendasExcluidas = new ArrayList<Encomenda>();
	private IterarColecaoConcreto iterarEncomenda = new IterarColecaoConcreto(encomendas);
	private Iterator iteratorArrayEncomenda = iterarEncomenda.criarIterator();
	
	
	public EncomendaDAOJDBC() {
		checkConnection();
	}
	
	public void checkConnection() {
		connectionBD = ConnectionBD.getInstance();
	}
	
	public void finishConnection() {
		connectionBD.closeConnection();
	}

	@Override
	public void save(String encomendaArquivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Encomenda> load(String encomendaArquivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEncomenda(Encomenda encomenda) {
		String nomeCliente = "'" + encomenda.getNomeCliente() + "'";
		String nomeRoupa = "'" + encomenda.getNomeRoupa() + "'";
		String descricao = "'" + encomenda.getDescricao() + "'";
		String tamanhoRoupa = "'" + encomenda.getTamanhoRoupa() + "'";
		String telefone = "'" + encomenda.getTelefone() + "'";
		String query = "(" + nomeCliente + ", " + ", " + nomeRoupa + ", " + tamanhoRoupa + ", " + descricao + ", " + telefone + " )";
		
		if(connectionBD.isConnectionValid()) {
			try {
				connectionBD.getConnection().executeUpdate("insert into encomenda (nomeCliente, nomeRoupa, tamanhoRoupa, descricao, telefone) values "+ query);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Encomenda> readEncomenda() {
		
		String id = "'";
		int cont = 0;
		
		while (iteratorArrayEncomenda.hasNext()) {
			Encomenda encomendaDaVez = (Encomenda) iteratorArrayEncomenda.next();
			if(encomenda.getNomeCliente().equals(encomendaDaVez.getNomeCliente())){
				id = encomendas.get(cont).getID_Encomenda() + "'";			
			}
			cont++;
		}
		
		if (connectionBD.isConnectionValid()) {
			try {
				ResultSet set = connectionBD.getConnection().executeQuery("select * from encomenda where id = " + id);
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
		return encomendas;
	}

	@Override
	public ArrayList<Encomenda> readEncomendasExcluidas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEncomenda(Encomenda encomenda) {
		
		String id = "'" + encomenda.getID_Encomenda() + "'";
		
		if (connectionBD.isConnectionValid()) {
			try {
				connectionBD.getConnection().executeUpdate("delete from encomenda where id = " + id);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	


}
