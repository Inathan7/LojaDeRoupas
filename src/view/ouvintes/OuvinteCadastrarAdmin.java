package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.facade.FacadeAdministracao;
import view.templateMethod.TelaCadastrarAdmin;
import view.templateMethod.TelaInicio; 


public class OuvinteCadastrarAdmin implements ActionListener{

	private JFrame tela;
	public OuvinteCadastrarAdmin(JFrame tela){
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		if(facade.getAdministrador()!=null){
			JOptionPane.showMessageDialog(tela,
					"Já possui um administrador cadastrado",
					"AVISO!", JOptionPane.WARNING_MESSAGE);
		}else{
			new TelaCadastrarAdmin();
			tela.dispose();
		}
	}
}

