package view.templateMethod;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.ControllerEncomenda;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaCadastrarEncomenda extends TemplateMethodTela{
	
	public TelaCadastrarEncomenda() {
		setTitle("Cadastrar Encomendas");
		setSize(600,350);
		repaint();
	}
	
	private JTextField campoRoupa;
	private JTextField campoTamanho;
	private JButton buttonCadastrar;
	private JTextField campoNomeCliente;
	private JTextField campoTelefone;
	private JTextArea campoDesc;

	@Override
	public void adicionarBotoes() {

		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(370, 240, 90, 30);
		add(buttonVoltar);

		buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setBounds(100, 240, 90, 30);
		add(buttonCadastrar);
		
		OuvinteCadastrarEncomenda ouvinteCadastrarEncomenda = new OuvinteCadastrarEncomenda(this);
		buttonCadastrar.addActionListener(ouvinteCadastrarEncomenda);

		OuvinteVoltarTelaMenu ouvinteTelaMenu = new OuvinteVoltarTelaMenu(this);
		buttonVoltar.addActionListener(ouvinteTelaMenu);
		
	}

	@Override
	public void adicionarJLabel() {
		
		JLabel labelTitulo = new JLabel("Cadastrar Encomendas");
		labelTitulo.setBounds(210, 10, 200, 30);
		labelTitulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
		add(labelTitulo);
		
		JLabel labelNomeCliente = new JLabel("Cliente");
		labelNomeCliente.setBounds(100, 70, 50, 30);
		labelNomeCliente.setFont(new Font("Arial",Font.BOLD,12));
		add(labelNomeCliente);
		
		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setBounds(290, 70, 70, 30);
		labelTelefone.setFont(new Font("Arial",Font.BOLD,12));
		add(labelTelefone);
		

		JLabel labelRoupa = new JLabel("Roupa");
		labelRoupa.setBounds(100, 110, 50, 30);
		labelRoupa.setFont(new Font("Arial",Font.BOLD,12));
		add(labelRoupa);

		JLabel labelTamanho = new JLabel("Tamanho");
		labelTamanho.setBounds(290, 110, 70, 30);
		labelTamanho.setFont(new Font("Arial",Font.BOLD,12));
		add(labelTamanho);
		
		JLabel labelDesc = new JLabel("Descrição");
		labelDesc.setBounds(100, 150, 70, 30);
		labelDesc.setFont(new Font("Arial",Font.BOLD,12));
		add(labelDesc);
		
	}
	
	public void adicionarTextField() {
		
		campoNomeCliente = new JTextField();
		campoNomeCliente.setBounds(140, 70, 130, 30);
		add(campoNomeCliente);
		
		campoTelefone = new JTextField();
		campoTelefone.setBounds(345, 70, 95, 30);
		add(campoTelefone);

		campoDesc = new JTextArea();
		campoDesc.setBounds(170, 150, 290, 70);
		campoDesc.setLineWrap(true);
		campoDesc.setWrapStyleWord(true);
		add(campoDesc);

		campoRoupa = new JTextField();
		campoRoupa.setBounds(140, 110, 130, 30);
		add(campoRoupa);

		campoTamanho = new JTextField();
		campoTamanho.setBounds(345, 110, 95, 30);
		add(campoTamanho);
		
		

	}
	
	
	
public class OuvinteCadastrarEncomenda implements ActionListener{
		
		private TelaCadastrarEncomenda tela;
		
		public OuvinteCadastrarEncomenda(TelaCadastrarEncomenda tela) {
			this.tela = tela;
		}

		public void actionPerformed(ActionEvent e) {
			
			if(campoRoupa.getText().equals("") || campoNomeCliente.getText().equals("") || campoTamanho.getText().equals("") ||
					campoDesc.getText().equals("") || campoTelefone.getText().equals("")) {
				JOptionPane.showMessageDialog(tela, "Campo Vazio!");
			}else {

				ControllerEncomenda encomendaCTL = new ControllerEncomenda();
				
				encomendaCTL.addEncomenda(campoNomeCliente.getText(), campoRoupa.getText(), campoTamanho.getText(),
						campoTelefone.getText(), campoDesc.getText(), encomendaCTL.contId());
				
				campoNomeCliente.setText("");
				campoRoupa.setText("");
				campoTamanho.setText("");
				campoDesc.setText("");
				campoTelefone.setText("");
				
				JOptionPane.showMessageDialog(tela, "Encomenda Cadastrada");

			}

		}
	}

}
