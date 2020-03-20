package dao;

import java.util.ArrayList;

import model.Roupa;

public interface RoupaDAO {

	public void save(String roupaArquivo);

	public ArrayList<Roupa> load(String roupaArquivo);

	public void createRoupa(Roupa roupa);

	public ArrayList<Roupa> readRoupa();

	public ArrayList<Roupa> readRoupasExcluidas();

	public void deleteRoupa(Roupa roupa);


}
