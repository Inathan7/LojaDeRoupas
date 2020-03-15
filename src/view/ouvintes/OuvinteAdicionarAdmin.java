package view.ouvintes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controller.facade.FacadeAdministracao;
import model.Administrador;
import model.decorator.Validacao;
import model.decorator.ValidacaoEmailDecorator;
import model.decorator.ValidacaoPadraoDeEntrada;
import model.decorator.ValidacaoSenhaDecorator;
import view.exception.EmailInvalidoException;
import view.exception.SenhaInvalidaException;
import view.templateMethod.TelaCadastrarAdmin;
import view.templateMethod.TelaMenuPrincipal;

public class OuvinteAdicionarAdmin implements ActionListener{
    private TelaCadastrarAdmin tca;
	public OuvinteAdicionarAdmin(TelaCadastrarAdmin tca){
		this.tca = tca;
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		String nome = tca.getCampoNome().getText();
		String email = tca.getCampoEmail().getText();
		String senha = new String(tca.getCampoSenha().getPassword());
	    try {
	    	String sexo = (String) tca.getSexo().getSelectedItem();
	    	Validacao validacaoPadrao = new ValidacaoPadraoDeEntrada();
			Validacao validacaoCompleta = new ValidacaoSenhaDecorator(new ValidacaoEmailDecorator(validacaoPadrao));
			if(validacaoCompleta.validacaoPadrao(nome)==false||validacaoCompleta.validacaoPadrao(email)==false||validacaoCompleta.validacaoPadrao(senha)==false){
				JOptionPane.showMessageDialog(tca, "Campo vazio");
			}else{
				validacaoCompleta.validarEmail(email);
				validacaoCompleta.validarSenha(senha);
			    Administrador a = new Administrador(nome, email, senha, sexo);
			    facade.adicionarAdministrador(a);
				JOptionPane.showMessageDialog(null, "Foi cadastrado");
				//facade.salvarDados();
				new TelaMenuPrincipal();
				tca.dispose();
		   }
		} catch (EmailInvalidoException e) {
			JOptionPane.showMessageDialog(tca, e.getMessage());
		}
		catch (SenhaInvalidaException e) {
			JOptionPane.showMessageDialog(tca, e.getMessage());
		}	
		tca.getCampoEmail().setText("");
		tca.getCampoNome().setText("");
		tca.getCampoSenha().setText("");
	}
}
