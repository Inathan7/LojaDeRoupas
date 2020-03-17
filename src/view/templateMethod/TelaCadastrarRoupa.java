package view.templateMethod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerRoupa;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaCadastrarRoupa extends TemplateMethodTela{
	
	public TelaCadastrarRoupa() {
		setTitle("Cadastrar Roupas");
		setSize(600,350);
		repaint();
	}
	
	
	private JTextField campoRoupa;
	private JTextField campoPreco;
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
		
		OuvinteCadastrarRoupa ouvinteCadastrarRoupa = new OuvinteCadastrarRoupa();
		buttonCadastrar.addActionListener(ouvinteCadastrarRoupa);

	// Adicionar Ouvinte
	//adicionei o ouvinte voltar para a tela de menu principal.
		OuvinteVoltarTelaMenu ouvinteTelaMenu = new OuvinteVoltarTelaMenu(this);
		buttonVoltar.addActionListener(ouvinteTelaMenu);
	}

	@Override
	public void adicionarJLabel() {
		
		JLabel labelRoupa = new JLabel("Roupa");
		labelRoupa.setBounds(100, 110, 50, 30);
		add(labelRoupa);

		JLabel labelPreco = new JLabel("Preço");
		labelPreco.setBounds(100, 150, 50, 30);
		add(labelPreco);
		
		JLabel labelTamanho = new JLabel("Tamanho");
		labelTamanho.setBounds(290,150, 70, 30);
		add(labelTamanho);
		
	}
	
	
	public void adicionarTextField() {
		
		campoRoupa = new JTextField();
		campoRoupa.setBounds(170, 110, 290, 30);
		add(campoRoupa);

		campoPreco = new JTextField();
		campoPreco.setBounds(140, 150, 130, 30);
		add(campoPreco);

		campoTamanho = new JTextField();
		campoTamanho.setBounds(365, 150, 95, 30);
		add(campoTamanho);

	}
	
	
	public class OuvinteCadastrarRoupa implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ControllerRoupa roupaCTL = new ControllerRoupa();
			roupaCTL.addRoupa(campoRoupa.getText(), Float.parseFloat(campoPreco.getText()), campoTamanho.getText());
			JOptionPane.showMessageDialog(null, "Roupa Cadastrada");
		}
		
	}
	
	

}
