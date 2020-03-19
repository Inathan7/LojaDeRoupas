package model;

import java.util.ArrayList;

public class Carrinho {

	private ArrayList<Roupa> roupas = new ArrayList<>(); 
	private static Carrinho carrinho;
	
	/*
	 * criei essa classe para armazenar as roupas que o cliente escolheu
	 * e deixei ela como Singleton já que em tempo de execução eu posso pegar
	 * só um objeto carrinho, assim possibilita que quando for chamado o carrinho
	 * ele mostre as roupas que foram escolhidas sem precisar de persistencia,
	 * mas só ficara salva enquanto o programa estiver rodando, já que o Singleton
	 * permite só um objeto do tipo carrinho na memoria em tempo de execução.
	 */
	private Carrinho() {
		// TODO Auto-generated constructor stub
	}
	public static synchronized Carrinho getInstance(){
		if(carrinho==null){
			carrinho = new Carrinho();
			return carrinho;
		}
		return carrinho;
	}
	public void addRoupa(Roupa roupa) {
		roupas.add(roupa);
	}
	
	public ArrayList<Roupa> getRoupa(){
		return roupas;
	}
	public void deleteRoupas(){
		roupas = new ArrayList<>();
	}
}
