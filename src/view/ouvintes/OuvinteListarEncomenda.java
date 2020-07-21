package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaListarEncomendas;

public class OuvinteListarEncomenda implements ActionListener{
	private JFrame tela;
	
	public OuvinteListarEncomenda(JFrame tela) {
	this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaListarEncomendas();
		tela.dispose();
		
	}
	
}
