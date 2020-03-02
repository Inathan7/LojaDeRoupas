package model.iterator;

import java.util.ArrayList;

public class ArrayListIterator<T> implements Iterator {
	
	protected ArrayList<T> arrayList;
	protected int cont;
	
	public ArrayListIterator (ArrayList<T> arrayList) {
		this.arrayList = arrayList;
	}
	
	@Override
	public Object next() {
		Object next = arrayList.get(cont);
		cont++;
		return next;
	}

	@Override
	public boolean hasNext() {
		return cont < arrayList.size();
	}

}
