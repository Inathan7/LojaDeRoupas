package model;

import java.util.ArrayList;

public class Carrinho {

	private ArrayList<Roupa> roupas = new ArrayList<>(); 
	private static Carrinho carrinho;
	
	/*
	 * criei essa classe para armazenar as roupas que o cliente escolheu
	 * e deixei ela como Singleton j� que em tempo de execu��o eu posso pegar
	 * s� um objeto carrinho, assim possibilita que quando for chamado o carrinho
	 * ele mostre as roupas que foram escolhidas sem precisar de persistencia,
	 * mas s� ficara salva enquanto o programa estiver rodando, j� que o Singleton
	 * permite s� um objeto do tipo carrinho na memoria em tempo de execu��o.
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
