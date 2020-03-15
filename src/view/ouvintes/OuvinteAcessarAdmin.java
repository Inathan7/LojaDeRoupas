package view.ouvintes;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controller.facade.FacadeAdministracao;
import model.Administrador;
import view.templateMethod.TelaAdministrador;
import view.templateMethod.TelaMenuPrincipal;


public class OuvinteAcessarAdmin implements ActionListener{
    private TelaAdministrador ta;
    public OuvinteAcessarAdmin(TelaAdministrador ta){
    	this.ta = ta;
    }
	public void actionPerformed(ActionEvent arg0) {
           String senha = new String (ta.getSenhaCampo().getPassword());
           Administrador a = new Administrador("Administrador", ta.getCampoEmail().getText(), senha, "Masculino");
           FacadeAdministracao facadeAdmin = new FacadeAdministracao();
           
           if (ta.getCampoEmail().getText().equals("")|| senha.equals("")){
        	   ta.getCampoEmail().setBackground(Color.RED);
        	   ta.getSenhaCampo().setBackground(Color.RED);
        	   JOptionPane.showMessageDialog(null, "Algum campo vazio");
           }else{
        	   if(facadeAdmin.getAdministrador().getEmail().equals(a.getEmail())&& facadeAdmin.getAdministrador().getSenha().equals(a.getSenha())){
        		   ta.getCampoEmail().setBackground(Color.GREEN);
            	   ta.getSenhaCampo().setBackground(Color.GREEN);
            	   JOptionPane.showMessageDialog(null, "Campos preenchidos");
            	   JOptionPane.showMessageDialog(null, "Olá "+facadeAdmin.getAdministrador().getNome()+" Bem vindo(a)");
        
            	   new TelaMenuPrincipal();
            	   ta.dispose();
            	   }
        	   else{
        		   JOptionPane.showMessageDialog(null, "Não existe esse administrador","ALERTA!",JOptionPane.ERROR_MESSAGE);
        	   }
              }
    	       ta.getCampoEmail().setText("");
		       ta.getSenhaCampo().setText("");
           }
	    }
