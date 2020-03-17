package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Roupa;
import model.iterator.IterarColecaoConcreto;
import model.iterator.Iterator;

public class RoupaDAOJDBC implements RoupaDAO{
	
	private Roupa roupa = new Roupa();
	private ConnectionBD connectionBD;
	private ArrayList<Roupa> roupas = new ArrayList<Roupa>();
	private ArrayList<Roupa> roupasExcluidas = new ArrayList<Roupa>();
	private IterarColecaoConcreto iterarRoupa = new IterarColecaoConcreto(roupas);
	private Iterator iteratorArrayRoupa = iterarRoupa.criarIterator();
	
	
	public RoupaDAOJDBC() {
		checkConnection();
	}
	
	public void checkConnection() {
		connectionBD = ConnectionBD.getInstance();
	}
	
	public void finishConnection() {
		connectionBD.closeConnection();
	}

	@Override
	public void save(String tapiocaArquivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Roupa> load(String roupaArquivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createRoupa(Roupa roupa) {
		String nome = "'" + roupa.getNome() + "'";
		String preco = "'" + roupa.getPreco() + "'";
//		String descricao = "'" + roupa.getDescricacao() + "'";
		String tamanho = "'" + roupa.getTamanho() + "'";
//		String quantEstoque = "'" + roupa.getQuantidadeEstoque() + "'";
		String query = "(" + nome + ", " + ", " + preco + ", " + tamanho;
		
		if(connectionBD.isConnectionValid()) {
			try {
				connectionBD.getConnection().executeUpdate("insert into roupa (nome, descricao, preco, quantidadeEstoque) values "+ query);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Roupa> readRoupa() {
		
		String id = "'";
		int cont = 0;
		
		while (iteratorArrayRoupa.hasNext()) {
			Roupa roupaDaVez = (Roupa) iteratorArrayRoupa.next();
			if(roupa.getNome().equals(roupaDaVez.getNome())){
				id = roupas.get(cont).getId() + "'";			
			}
			cont++;
		}
		
		if (connectionBD.isConnectionValid()) {
			try {
				ResultSet set = connectionBD.getConnection().executeQuery("select * from produto where id = " + id);
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
		return roupas;
	}

	@Override
	public ArrayList<Roupa> readRoupasExcluidas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoupa(Roupa roupa) {
		
		String id = "'" + roupa.getId() + "'";
		
		if (connectionBD.isConnectionValid()) {
			try {
				connectionBD.getConnection().executeUpdate("delete from produto where id = " + id);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	


}
