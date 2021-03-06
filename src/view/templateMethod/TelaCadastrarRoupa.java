package view.templateMethod;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.ControllerRoupa;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaCadastrarRoupa extends TemplateMethodTela{
	/*
	 * Mudei o ouvinte cadastrar roupa que est� nessa classe, eu explico tudo
	 * no ouvinte que est� abaixo.
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

		OuvinteCadastrarRoupa ouvinteCadastrarRoupa = new OuvinteCadastrarRoupa(this);
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

		JLabel labelPreco = new JLabel("Pre�o");
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
		
		private TelaCadastrarRoupa tela;
		
		public OuvinteCadastrarRoupa(TelaCadastrarRoupa tela) {
			this.tela = tela;
		}

		public void actionPerformed(ActionEvent e) {
			/*
			 * Mudei s� a logica de cadastrar a roupa, j� que agora precisa
			 * do id para criar uma roupa.
			 * 
			 * Para gerar IDs diferentes eu usei o array das roupas cadastradas
			 * no sistema, e fiz a logica de roupas.siza()+1, assim ele sempre vai
			 * colocar o proximo indice do array para cada roupa que for cadastrada
			 * como � feito em lista sequencial.
			 */
			
			/* EDIT 2
			 * Mudei a l�gica do incremento no ID, pois da forma antiga, a camada de neg�cio de acoplava com a view, 
			 * j� com o m�todo no controller de Roupa isso n�o acontece mais. -Inathan
			 */
			
			if(campoRoupa.getText().equals("") || campoPreco.getText().equals("") || campoTamanho.getText().equals("")) {
				JOptionPane.showMessageDialog(tela, "Campo Vazio!");
			}else {

				ControllerRoupa roupaCTL = new ControllerRoupa();
				try {
					roupaCTL.addRoupa(campoRoupa.getText(),
							Float.parseFloat(campoPreco.getText()),
							campoTamanho.getText(),roupaCTL.contId());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				campoRoupa.setText("");
				campoPreco.setText("");
				campoTamanho.setText("");
				JOptionPane.showMessageDialog(tela, "Roupa Cadastrada");

			}

		}
	}
}