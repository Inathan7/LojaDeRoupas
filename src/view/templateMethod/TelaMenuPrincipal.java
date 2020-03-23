package view.templateMethod;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.facade.FacadeAdministracao;
import view.ouvintes.OuvinteCadastrarRoupa;
import view.ouvintes.OuvinteListarRoupa;
import view.ouvintes.OuvinteTelaCadastrarPedido;
import view.ouvintes.OuvinteTelaCarrinho;
import view.ouvintes.OuvinteTelaPedido;
import view.ouvintes.OuvinteVoltarTelaInicio;

public class TelaMenuPrincipal extends TemplateMethodTela{

	public TelaMenuPrincipal() {
		repaint();
	}
	@Override
	public void adicionarBotoes() {
		
	}

	@Override
	public void adicionarJLabel() {
		String boasVindas = "";
		FacadeAdministracao facade = new FacadeAdministracao();
		if(facade.getAdministrador().getSexo().equalsIgnoreCase("masculino")){
			boasVindas = "Bem-Vindo Sr ";
		}else{
			boasVindas = "Bem-Vinda Sra ";
		}
		JLabel bemVindo = new JLabel(boasVindas+facade.getAdministrador().getNome());
		bemVindo.setBounds(150, 100, 200, 35);
		bemVindo.setFont(new Font("Times new roman", Font.BOLD, 20));
		add(bemVindo);
		
		JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("/FundoPadrao.jpg")));
		fundo.setBounds(0, 0, 500, 400);
		add(fundo);
	}
	
	@Override
	public void adicionarMenu() {
		/*
		 * Adicionei no menu um meuItem carrinho para poder ir para tela carrinho
		 */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(-5, 2, 500, 30);
		JMenu menu = new JMenu("Menu");
		JMenu detalhes = new JMenu("Detalhes");
		menu.setIcon(new ImageIcon(getClass().getResource("/icons8-menu-vertical-20.png")));
		
		OuvinteCadastrarRoupa ouvinteCadastrarRoupa = new OuvinteCadastrarRoupa(this);
		JMenuItem cadastrarRoupa = new JMenuItem("Cadastrar Roupa");
		cadastrarRoupa.addActionListener(ouvinteCadastrarRoupa);
		
		OuvinteListarRoupa ouvinteListarRoupa = new OuvinteListarRoupa(this);
		JMenuItem listarRoupas = new JMenuItem("Lista de Roupas");
		listarRoupas.addActionListener(ouvinteListarRoupa);
		
		OuvinteTelaPedido ouvinteTelaPedido = new OuvinteTelaPedido(this);
		JMenuItem pedidos = new JMenuItem("Pedidos");
		pedidos.addActionListener(ouvinteTelaPedido);
		
		OuvinteTelaCarrinho ouvinteCarrinho = new OuvinteTelaCarrinho(this);
		JMenuItem carrinho = new JMenuItem("Carrinho");
		carrinho.addActionListener(ouvinteCarrinho);
		
		OuvinteVoltarTelaInicio ouvinteTelaInicio = new OuvinteVoltarTelaInicio(this);
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(ouvinteTelaInicio);
		//irei implementar mais coisas...
		menu.add(cadastrarRoupa);
		menu.add(listarRoupas);
		menu.add(pedidos);
		menu.add(carrinho);
		menu.add(sair);
		menuBar.add(menu);
		menuBar.add(detalhes);
		add(menuBar);
	}

}
