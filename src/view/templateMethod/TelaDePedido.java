package view.templateMethod;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerPedido;
import controller.ControllerRoupa;
import model.Carrinho;
import model.Pedido;
import model.Roupa;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaDePedido extends TemplateMethodTela{

	/*
	 * Tela onde vai ficar todos os pedidos feitos pelos cliente que confirmaram
	 * a compra.
	 * 
	 * Ainda vou terminar de fazer a tela
	 */
	public TelaDePedido() {
		repaint();
	}

	private JTable tabela;
	private DefaultTableModel model;

	@Override
	public void adicionarBotoes() {
		OuvinteVoltarTelaMenu voltarMenu = new OuvinteVoltarTelaMenu(this);
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(400, 5, 80, 30);
		voltar.addActionListener(voltarMenu);
		add(voltar);
	}

	@Override
	public void adicionarJLabel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void adicionarTabela() {
		model = new DefaultTableModel();
		model.addColumn("Cliente");
		ControllerPedido controllerPedido = new ControllerPedido();
		ArrayList<Pedido> pedidos = controllerPedido.loadPedido();
		for(Pedido p : pedidos){
			model.addRow(new Object[]{p.getCliente().getNome()});
		}

		tabela = new JTable(model);
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 40, 494, 330);
		add(painel);
	}

}
