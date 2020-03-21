package view.templateMethod;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Carrinho;
import model.Roupa;
import view.ouvintes.OuvinteTelaCadastrarPedido;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaDeCarrinho extends TemplateMethodTela{
	/*
	 * Tela onde fica os produtos escolhido pelo cliente
	 * Nessa tela onde fica fazer pedido, coloquei o ouvinte telaCadastrar pedido
	 * para que o cliente cadastre o pedido a partir do seu carrinho
	 */
	public TelaDeCarrinho() {
		repaint();
	}
	@Override
	public void adicionarBotoes() {
		OuvinteTelaCadastrarPedido ouvinteTelaCadastrarPedido = new OuvinteTelaCadastrarPedido(this);
		JButton fazerPedido = new JButton("Fazer Pedido");
        fazerPedido.addActionListener(ouvinteTelaCadastrarPedido);
		JButton removerPedido = new JButton("Remover");
		
		OuvinteVoltarTelaMenu ouvinteVoltarTelaMenu = new OuvinteVoltarTelaMenu(this);
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(ouvinteVoltarTelaMenu);
		voltar.setBounds(400, 5, 80, 30);
		
		fazerPedido.setBounds(380, 300, 100, 30);
		removerPedido.setBounds(80, 300, 80, 30);
		add(fazerPedido);
		add(removerPedido);
		add(voltar);
	}

	@Override
	public void adicionarJLabel() {
		JLabel pedidos = new JLabel("Pedidos no carrinho");
		pedidos.setBounds(220, 8, 120, 30);
		Carrinho carrinho = Carrinho.getInstance();
		float total = 0;
		for(Roupa r:carrinho.getRoupa()){
			total+=r.getPreco();
		}
		JLabel totalAPagar = new JLabel("Total a pagar: "+total);
		totalAPagar.setBounds(170, 300, 275, 30);
		add(totalAPagar);
		add(pedidos);
	}

	@Override
	public void adicionarTabela() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Preço");
		model.addColumn("Tamanho");
		Carrinho carrinho = Carrinho.getInstance();
		ArrayList<Roupa> roupas = carrinho.getRoupa();
		for(Roupa r:roupas){
			model.addRow(new Object[]{r.getId(),r.getNome(),r.getPreco(),r.getTamanho()});
		}
		JTable tabela = new JTable(model);
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 40, 494, 220);
		add(painel);
	}
}
