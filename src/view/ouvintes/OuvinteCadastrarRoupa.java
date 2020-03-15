package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaCadastrarRoupa;

public class OuvinteCadastrarRoupa implements ActionListener{
    private JFrame tela;
    
    public OuvinteCadastrarRoupa(JFrame tela) {
    	this.tela = tela;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaCadastrarRoupa();
		tela.dispose();
	}

}
