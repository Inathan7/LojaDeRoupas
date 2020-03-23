package view.templateMethod;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public abstract class TemplateMethodTela extends JFrame{
    public TemplateMethodTela(){
    	templateMethod();
    	JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("/FundoPadrao.jpg")));
		fundo.setBounds(0, 0, 600, 400);
		add(fundo);
    	repaint();
    }
    public void templateMethod(){
    	setTitle("Fashion Designer Pattern");
    	setIconImage(new ImageIcon(getClass().getResource("/icons8-terno-das-mulheres-30.png")).getImage());
    	setLayout(null);
        setResizable(false);
    	setSize(500,400);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	setLocationRelativeTo(null);
     	
     	try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if ("Nimbus".equals(info.getName())) {
			        UIManager.setLookAndFeel(info.getClassName());
			        break;
			    }
			}
			} catch (Exception e) {
			   // If Nimbus is not available, you can set the GUI to another look and feel.
			}
     	
     	adicionarBotoes();
     	adicionarTextField();
     	adicionarTabela();
     	adicionarMenu();
     	adicionarRadioButton();
     	adicionarJComboBox();
     	adicionarJLabel();
     	setVisible(true);
    }
    public abstract void adicionarBotoes();
    
    public void adicionarTextField(){
    	
    }
    public abstract void adicionarJLabel();
    
    public void adicionarLabel(String usuario){
    	
    }
    public void adicionarMenu(){
    	
    }
    public void adicionarTabela(){
    	
    }
    public void adicionarRadioButton(){
    	
    }
    public void adicionarJComboBox(){
    	
    }
}