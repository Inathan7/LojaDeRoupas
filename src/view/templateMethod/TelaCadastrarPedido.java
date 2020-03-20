package view.templateMethod;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerPedido;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaCadastrarPedido extends TemplateMethodTela{

	public TelaCadastrarPedido() {
		setTitle("Cadastrar Pedido");
		setSize(600,350);
		repaint();
	}
	
	
	private JTextField campoEmail;
	private JTextField campoNome;
	private JTextField campoTelefone;
	private JButton buttonFazerPedido;

	@Override
	public void adicionarBotoes() {
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(470, 20, 90, 30);
		add(buttonVoltar);

		buttonFazerPedido = new JButton("Fazer Pedido");
		buttonFazerPedido.setBounds(230, 240, 140, 30);
		add(buttonFazerPedido);
		
		OuvinteCadastrarPedido ouvinteCadastrarPedido = new OuvinteCadastrarPedido();
		buttonFazerPedido.addActionListener(ouvinteCadastrarPedido);

		OuvinteVoltarTelaMenu ouvinteTelaMenu = new OuvinteVoltarTelaMenu(this);
		buttonVoltar.addActionListener(ouvinteTelaMenu);
	}

	@Override
	public void adicionarJLabel() {
		
		JLabel labelTitulo = new JLabel("Dados Do Cliente");
		labelTitulo.setBounds(225, 80, 150, 30);
		labelTitulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
		add(labelTitulo);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(100, 110, 50, 30);
		add(labelEmail);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(100, 150, 50, 30);
		add(labelNome);
		
		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setBounds(290,150, 70, 30);
		add(labelTelefone);
		
	}
	
	
	public void adicionarTextField() {
		
		campoEmail = new JTextField();
		campoEmail.setBounds(170, 110, 290, 30);
		add(campoEmail);

		campoNome = new JTextField();
		campoNome.setBounds(140, 150, 130, 30);
		add(campoNome);

		campoTelefone = new JTextField();
		campoTelefone.setBounds(365, 150, 95, 30);
		add(campoTelefone);

	}
	
	
	public class OuvinteCadastrarPedido implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String opc = e.getActionCommand();
			
			switch (opc) {
			
			case "Fazer Pedido":
				new TelaCadastrarRoupa();
				dispose();
				break;

			default:
				ControllerPedido pedidoCTL = new ControllerPedido();
			//	pedidoCTL.addPedido(email, nome, telefone, roupas);
				campoEmail.setText("");
				campoNome.setText("");
				campoTelefone.setText("");
				
			// Ainda vou fazer essa parte da lógica, onde vou cadastrar o cliente e fazer a persistência dele.
				
				break;
			}
			
			
		}
	}
	
}
