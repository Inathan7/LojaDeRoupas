package dao;

import java.util.ArrayList;

import model.Encomenda;

public interface EncomendaDAO {
	
	public void save(String encomendaArquivo);

	public ArrayList<Encomenda> load(String encomendaArquivo);

	public void createEncomenda(Encomenda encomenda) throws Exception;

	public ArrayList<Encomenda> readEncomenda();

	public ArrayList<Encomenda> readEncomendasExcluidas();

	public void deleteEncomenda(Encomenda encomenda);

}
