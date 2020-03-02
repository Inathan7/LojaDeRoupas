package model.iterator;

import java.util.ArrayList;

public class IterarColecaoConcreto<T> implements IterarColecaoInterface {

	private ArrayList<T> lista;
	
	public IterarColecaoConcreto(ArrayList<T> lista) {
		this.lista = lista;
	}
	
	@Override
	public Iterator criarIterator() {
		return new ArrayListIterator(lista);
	}

}
