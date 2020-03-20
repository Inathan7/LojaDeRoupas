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

public class PedidoDAOXML implements PedidoDAO{

	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	private File arquivo;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private ArrayList<Pedido> pedidosExcluidos = new ArrayList<Pedido>();
	private IterarColecaoConcreto iterarPedido = new IterarColecaoConcreto(pedidos);
	private Iterator iteratorArrayPedido = iterarPedido.criarIterator();
	
	public PedidoDAOXML() {
		pedidos = load("pedidos");
		pedidosExcluidos = load("pedidosExcluidos");
	}

	@Override
	public void save(String pedidoArquivo) {
		arquivo = new File(pedidoArquivo + ".xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(pedidos);
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
	public ArrayList<Pedido> load(String pedidoArquivo) {
		arquivo = new File(pedidoArquivo + ".xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (ArrayList<Pedido>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Pedido>();
	}

	@Override
	public void createPedido(Pedido pedido) {
	//	while (iteratorArrayRoupa.hasNext()){
	//		Roupa tapiocaDaVez = (Roupa) iteratorArrayRoupa.next();
		
	//	}

		pedidos.add(pedido);
		save("pedidos");
	}

	@Override
	public ArrayList<Pedido> readPedido() {
		pedidos = load("pedidos");
		return pedidos;
	}

	@Override
	public ArrayList<Pedido> readPedidosExcluidos() {
		pedidosExcluidos = load("pedidosExcluidos");
		return pedidosExcluidos;
	}

	@Override
	public void deletePedido(Pedido pedido) {
		pedidosExcluidos.add(pedido);
		save("pedidosExcluidos");
		
		while (iteratorArrayPedido.hasNext()) {
			Pedido pedidoDaVez = (Pedido) iteratorArrayPedido.next();
			if(pedido.getCliente().getNome().equals(pedidoDaVez.getCliente().getNome())){
				pedidos.remove(pedido);
			}
		}
		save("pedidos");
		
	}

}
