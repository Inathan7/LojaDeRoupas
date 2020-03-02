package view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controller.facade.FacadeAdministracao;
import view.templateMethod.TelaAdministrador;
import view.templateMethod.TelaInicio;

public class OuvinteExcluirAdmin implements ActionListener{
    private TelaAdministrador ta;
    
    public OuvinteExcluirAdmin(TelaAdministrador ta){
    	this.ta = ta;
    }
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		int res = JOptionPane.showConfirmDialog(ta, "Tem certeza?", "Aviso", JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION){
			facade.excluirAdministrador();
			//facade.salvarDados();
			JOptionPane.showMessageDialog(ta,"Opera��o Feita");
			JOptionPane.showMessageDialog(ta, "Voc� Ir� Voltar Para Tela Inicial", "Aten��o", JOptionPane.WARNING_MESSAGE);
			new TelaInicio();
			ta.dispose();
		}else{
			JOptionPane.showMessageDialog(ta, "Opera��o Cancelada");
		}
	}

}
