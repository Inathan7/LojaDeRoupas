package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controller.facade.FacadeAdministracao;
import view.templateMethod.TelaInicio;

public class OuvinteEntrar implements ActionListener{

	private TelaInicio ti;
	public OuvinteEntrar(TelaInicio ti){
		this.ti = ti;
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		if(facade.getAdministrador()==null){
			JOptionPane.showMessageDialog(ti, "NÃO PODE ENTRAR, NÃO EXISTE ADMINISTRADOR AINDA!", "ATENÇÂO!",JOptionPane.WARNING_MESSAGE);
		}
		else{
			//		new SegundaTela("Cliente");
			ti.dispose();
		}
	}
}
