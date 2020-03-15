package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaMenuPrincipal;

public class OuvinteVoltarTelaMenu implements ActionListener{
	private JFrame tela;
	/*
	 * Esse ouvinte serve para qualquer classe que seja das opções de menu da TelaMenuPrincipal
	 * que tenha o botão voltar para a tela menu principal.
	 */
	public OuvinteVoltarTelaMenu(JFrame tela) {
		this.tela = tela;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaMenuPrincipal();
		tela.dispose();
	}

}
