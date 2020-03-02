package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.templateMethod.TelaInicio;

public class OuvinteVoltarPrimeiraTela implements ActionListener{
    private JFrame tp;
	public OuvinteVoltarPrimeiraTela(JFrame tp){
		this.tp = tp;
	}
	public void actionPerformed(ActionEvent e) {
		//facade.salvarDados();
		new TelaInicio();
		tp.dispose();
	}
}
