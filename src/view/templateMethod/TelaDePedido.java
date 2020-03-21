package view.templateMethod;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.ControllerPedido;
import model.Pedido;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaDePedido extends TemplateMethodTela{

	/*
	 * Tela onde vai ficar todos os pedidos feitos pelos cliente que confirmaram
	 * a compra.
	 * 
	 * Ainda vou terminar de fazer a tela
	 * 
	 * !AVISO! -> Paulo - já terminei a tela, mas pode ficar a vontade se quiser adicionar mais
	 * funcionalidades
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
		model.addColumn("ID");
		model.addColumn("Preço");
		ControllerPedido controllerPedido = new ControllerPedido();
		ArrayList<Pedido> pedidos = controllerPedido.loadPedido();
		for(Pedido p : pedidos){
			model.addRow(new Object[]{p.getCliente().getNome(),
					p.getID_Pedido(),p.precoTotal()});
		}
		tabela = new JTable(model);
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 40, 494, 330);
		add(painel);
	}

}
