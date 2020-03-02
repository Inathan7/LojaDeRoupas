package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.facade.FacadeAdministracao;
import view.templateMethod.TelaAdministrador;
import view.templateMethod.TelaCadastrarAdmin;
import view.templateMethod.TelaInicio; 


public class OuvinteCadastrarAdmin implements ActionListener{

	private TelaInicio ti;
	public OuvinteCadastrarAdmin(TelaInicio ti){
		this.ti = ti;
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		if(facade.getAdministrador()!=null){
			new TelaAdministrador();
		}else{
			new TelaCadastrarAdmin();
		}
		ti.dispose();
	}
}

