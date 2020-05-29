package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaCadastrarEncomenda;

public class OuvinteTelaCadastrarEncomenda implements ActionListener{
	
	  private JFrame tela;
	    
	    public OuvinteTelaCadastrarEncomenda(JFrame tela) {
	    	this.tela = tela;
		}
	    
		public void actionPerformed(ActionEvent arg0) {
			new TelaCadastrarEncomenda();
			tela.dispose();
		}

}
