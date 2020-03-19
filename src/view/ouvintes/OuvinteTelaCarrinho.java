package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaDeCarrinho;

public class OuvinteTelaCarrinho implements ActionListener{
	/*
	 * O ouvinte para levar até a tela carrinho, onde o cliente vai ver os produtos
	 * escolhidos.
	 */
	private JFrame tela;
	
	public OuvinteTelaCarrinho(JFrame tela) {
		this.tela = tela;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaDeCarrinho();
		tela.dispose();
		
	}

}
