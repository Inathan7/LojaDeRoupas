package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import view.templateMethod.TelaInicio;

public class OuvinteSair implements ActionListener{
    private TelaInicio ti;
	public OuvinteSair(TelaInicio ti){
		this.ti = ti;
	}
	public void actionPerformed(ActionEvent arg0) {
		int res = JOptionPane.showConfirmDialog(null, "Deseja Realmente Sair?", "Atenção", JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Obrigado Por Ficar!");
		}else if(res == JOptionPane.YES_OPTION){
			ti.dispose();
		}
	}

}

