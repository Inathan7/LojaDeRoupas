package view.templateMethod;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerPedido;
import model.Carrinho;

import model.Roupa;

public class TelaCadastrarPedido extends TemplateMethodTela{
	//Fiz a lógica de cadastrar pedido, está no ouvinte dessa classe
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
		
		OuvinteVoltarTelaCarrinho ouvinteVoltarTelaCarrinho = new OuvinteVoltarTelaCarrinho();
		buttonVoltar.addActionListener(ouvinteVoltarTelaCarrinho);
		
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
	public class OuvinteVoltarTelaCarrinho implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new TelaDeCarrinho();
			dispose();
		}
	}
	
	public class OuvinteCadastrarPedido implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String opc = e.getActionCommand();
			
			switch (opc) {
			
			case "Fazer Pedido":
				ControllerPedido pedidoCTL = new ControllerPedido();
				//Pega as roupas escolhidas pelo o cliente, que está no singleton
				//que é o carrinho
				Carrinho carrinho = Carrinho.getInstance();
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			    Date d = new Date();
			    String a = s.format(d);
			    String[] datas = a.split("/");
                datas[2]+=pedidoCTL.quantidadeDePedidos()+1;
                long id = Long.parseLong(datas[2]);
                //gera um id com a data do ano junto o tamanho de pedido, assim
                //o id é unica a cada pedido
				pedidoCTL.addPedido(id,campoEmail.getText(), campoNome.getText(),
						campoTelefone.getText(),carrinho.getRoupa());
				campoEmail.setText("");
				campoNome.setText("");
				campoTelefone.setText("");
				JOptionPane.showMessageDialog(null, "Pedido Feito!");
				//deleta as roupas salvas no singleton carrinho
				//e depois volta para tela carrinho
				carrinho.deleteRoupas();
				new TelaDeCarrinho();
				dispose();
				break;

			default:

				
			// Ainda vou fazer essa parte da lógica, onde vou cadastrar o cliente e fazer a persistência dele.
			
			//Paulo - na hora que cria o pedido já é cadastrado o cliente, quando é passado os parametros do pedido,
			//Como é visto na classe pedido, assim a persistencia de pedido já salva o pedido com o cliente dentro como atributo
			//a lógica de cadastrar pedido está pegando e funcionando.
				
				break;
			}
			
			
		}
	}
	
}
