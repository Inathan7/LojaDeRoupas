package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaListarRoupa;

public class OuvinteListarRoupa implements ActionListener{
	
	private JFrame tela;
	
	public OuvinteListarRoupa(JFrame tela) {
		this.tela = tela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaListarRoupa();
		tela.dispose();
	}

}
