package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaDePedido;

public class OuvinteTelaPedido implements ActionListener{
	
	private JFrame tela;

	public OuvinteTelaPedido(JFrame tela) {
		this.tela = tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaDePedido();
		tela.dispose();
		
	}

}
