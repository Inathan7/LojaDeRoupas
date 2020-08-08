package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Pedido;
import model.Roupa;
import model.iterator.IterarColecaoConcreto;
import model.iterator.Iterator;

public class RoupaDAOXML implements RoupaDAO{
	
	
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	private File arquivo;
	private ArrayList<Roupa> roupas = new ArrayList<Roupa>();
	private ArrayList<Roupa> roupasExcluidas = new ArrayList<Roupa>();
	private IterarColecaoConcreto iterarRoupa = new IterarColecaoConcreto(roupas);
	private Iterator iteratorArrayRoupa = iterarRoupa.criarIterator();
	
	public RoupaDAOXML() {
		roupas = load("roupas");
		roupasExcluidas = load("roupasExcluidas");
	}

	@Override
	public void save(String roupaArquivo) {
		arquivo = new File(roupaArquivo + ".xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(roupas);
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
	public ArrayList<Roupa> load(String roupaArquivo) {
		arquivo = new File(roupaArquivo + ".xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (ArrayList<Roupa>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Roupa>();
	}

	@Override
	public void createRoupa(Roupa roupa) throws Exception {
		while (iteratorArrayRoupa.hasNext()) {
			Roupa roupaDaVez = (Roupa) iteratorArrayRoupa.next();
			if(roupa.getId()==(roupaDaVez.getId())){
				throw new Exception("Roupa duplicada");
			}
		}
		roupas.add(roupa);
		save("roupas");
	}

	@Override
	public ArrayList<Roupa> readRoupa() {
		roupas = load("roupas");
		return roupas;
	}

	@Override
	public ArrayList<Roupa> readRoupasExcluidas() {
		roupasExcluidas = load("roupasExcluidas");
		return roupasExcluidas;
	}

	@Override
	public void deleteRoupa(Roupa roupa) {
		roupasExcluidas.add(roupa);
		save("roupasExcluidas");
		
		while (iteratorArrayRoupa.hasNext()) {
			Roupa roupaDaVez = (Roupa) iteratorArrayRoupa.next();
			if(roupa.getNome().equals(roupaDaVez.getNome())){
				roupas.remove(roupa);
			}
		}
		save("roupas");
		
	}

}
