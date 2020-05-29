package view.templateMethod;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

	@Override
	public void adicionarBotoes() {

		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(370, 240, 90, 30);
		add(buttonVoltar);

		buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setBounds(100, 240, 90, 30);
		add(buttonCadastrar);

	//	OuvinteCadastrarRoupa ouvinteCadastrarRoupa = new OuvinteCadastrarRoupa(this);
	//	buttonCadastrar.addActionListener(ouvinteCadastrarRoupa);

		OuvinteVoltarTelaMenu ouvinteTelaMenu = new OuvinteVoltarTelaMenu(this);
		buttonVoltar.addActionListener(ouvinteTelaMenu);
		
	}

	@Override
	public void adicionarJLabel() {
		
		JLabel labelTitulo = new JLabel("Cadastrar Encomendas");
		labelTitulo.setBounds(210, 80, 200, 30);
		labelTitulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
		add(labelTitulo);

		JLabel labelRoupa = new JLabel("Roupa");
		labelRoupa.setBounds(100, 110, 50, 30);
		labelRoupa.setFont(new Font("Arial",Font.BOLD,12));
		add(labelRoupa);

		JLabel labelTamanho = new JLabel("Tamanho");
		labelTamanho.setBounds(290,110, 70, 30);
		labelTamanho.setFont(new Font("Arial",Font.BOLD,12));
		add(labelTamanho);
		
		JLabel labelDesc = new JLabel("Descrição");
		labelDesc.setBounds(100, 150, 70, 30);
		labelDesc.setFont(new Font("Arial",Font.BOLD,12));
		add(labelDesc);
		
	}
	
	public void adicionarTextField() {

		JTextArea campoDesc = new JTextArea();
		campoDesc.setBounds(170, 150, 290, 70);
		campoDesc.setLineWrap(true);
		campoDesc.setWrapStyleWord(true);
		add(campoDesc);

		campoRoupa = new JTextField();
		campoRoupa.setBounds(140, 110, 130, 30);
		add(campoRoupa);

		campoTamanho = new JTextField();
		campoTamanho.setBounds(365, 110, 95, 30);
		add(campoTamanho);
		
		

	}

}
