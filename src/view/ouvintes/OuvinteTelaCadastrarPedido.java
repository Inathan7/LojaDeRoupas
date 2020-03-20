package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaCadastrarPedido;

public class OuvinteTelaCadastrarPedido implements ActionListener{
	
	private JFrame tela;
	
	public OuvinteTelaCadastrarPedido(JFrame tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaCadastrarPedido();
		tela.dispose();
		
	}

}
