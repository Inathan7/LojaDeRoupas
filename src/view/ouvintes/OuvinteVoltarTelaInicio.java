package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import view.templateMethod.TelaInicio;

public class OuvinteVoltarTelaInicio implements ActionListener{
    private JFrame tp;
	public OuvinteVoltarTelaInicio(JFrame tp){
		this.tp = tp;
	}
	public void actionPerformed(ActionEvent e) {
		new TelaInicio();
		tp.dispose();
	}
}
