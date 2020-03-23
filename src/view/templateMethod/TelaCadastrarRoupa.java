package view.templateMethod;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerRoupa;
import model.Roupa;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaCadastrarRoupa extends TemplateMethodTela{
	/*
	 * Mudei o ouvinte cadastrar roupa que está nessa classe, eu explico tudo
	 * no ouvinte que está abaixo.
	 */
	
	
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
		
		JLabel labelTitulo = new JLabel("Cadastrar Roupas");
		labelTitulo.setBounds(225, 80, 160, 30);
		labelTitulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
		add(labelTitulo);
		
		JLabel labelRoupa = new JLabel("Roupa");
		labelRoupa.setBounds(100, 110, 50, 30);
		labelRoupa.setFont(new Font("Arial",Font.BOLD,12));
		add(labelRoupa);

		JLabel labelPreco = new JLabel("Preço");
		labelPreco.setBounds(100, 150, 50, 30);
		labelPreco.setFont(new Font("Arial",Font.BOLD,12));
		add(labelPreco);
		
		JLabel labelTamanho = new JLabel("Tamanho");
		labelTamanho.setBounds(290,150, 70, 30);
		labelTamanho.setFont(new Font("Arial",Font.BOLD,12));
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

		public void actionPerformed(ActionEvent e) {
			/*
			 * Mudei só a logica de cadastrar a roupa, já que agora precisa
			 * do id para criar uma roupa.
			 * 
			 * Para gerar IDs diferentes eu usei o array das roupas cadastradas
			 * no sistema, e fiz a logica de roupas.siza()+1, assim ele sempre vai
			 * colocar o proximo indice do array para cada roupa que for cadastrada
			 * como é feito em lista sequencial.
			 */
			ControllerRoupa roupaCTL = new ControllerRoupa();
			ArrayList<Roupa> roupas = roupaCTL.loadRoupa();
			roupaCTL.addRoupa(campoRoupa.getText(),
							  Float.parseFloat(campoPreco.getText()),
							  campoTamanho.getText(),roupas.size()+1);
			campoRoupa.setText("");
			campoPreco.setText("");
			campoTamanho.setText("");
			JOptionPane.showMessageDialog(null, "Roupa Cadastrada");
		}
	}
}