package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Encomenda;
import model.Pedido;
import model.iterator.IterarColecaoConcreto;
import model.iterator.Iterator;

public class EncomendaDAOXML implements EncomendaDAO{
	
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	private File arquivo;
	private ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();
	private ArrayList<Encomenda> encomendasExcluidas = new ArrayList<Encomenda>();
	private IterarColecaoConcreto iterarEncomenda = new IterarColecaoConcreto(encomendas);
	private Iterator iteratorArrayEncomenda = iterarEncomenda.criarIterator();
	
	public EncomendaDAOXML() {
		encomendas = load("encomendas");
		encomendasExcluidas = load("encomendasExcluidos");
	}

	@Override
	public void save(String encomendaArquivo) {
		arquivo = new File(encomendaArquivo + ".xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(encomendas);
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
	public ArrayList<Encomenda> load(String encomendaArquivo) {
		arquivo = new File(encomendaArquivo + ".xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (ArrayList<Encomenda>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Encomenda>();
	}

	@Override
	public void createEncomenda(Encomenda encomenda) throws Exception {
		while (iteratorArrayEncomenda.hasNext()) {
			Encomenda encomendaDaVez = (Encomenda) iteratorArrayEncomenda.next();
			if(encomenda.getID_Encomenda()==(encomendaDaVez.getID_Encomenda())){
				throw new Exception("Encomenda duplicada");
			}
		}
		encomendas.add(encomenda);
		save("encomendas");
		
	}

	@Override
	public ArrayList<Encomenda> readEncomenda() {
		encomendas = load("encomendas");
		return encomendas;
	}

	@Override
	public ArrayList<Encomenda> readEncomendasExcluidas() {
		encomendasExcluidas = load("encomendasExcluidas");
		return encomendasExcluidas;
	}

	@Override
	public void deleteEncomenda(Encomenda encomenda) {
		encomendasExcluidas.add(encomenda);
		save("encomendasExcluidas");
		
		while (iteratorArrayEncomenda.hasNext()) {
			Encomenda encomendaDaVez = (Encomenda) iteratorArrayEncomenda.next();
			if(encomenda.getNomeCliente().equals(encomendaDaVez.getNomeCliente())){
				encomendas.remove(encomenda);
			}
		}
		save("encomendas");
		
	}

}
