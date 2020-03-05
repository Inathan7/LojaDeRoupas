package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.facade.FacadeAdministracao;
import view.templateMethod.TelaAdministrador;
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
			new TelaAdministrador();
		}else{
			new TelaCadastrarAdmin();
		}
		tela.dispose();
	}
}

