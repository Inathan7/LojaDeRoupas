package view.templateMethod;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerRoupa;
import model.Carrinho;
import model.Roupa;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaListarRoupa extends TemplateMethodTela{
	/*
	 *Tela onde vai ficar a lista de roupas cadastradas no sistema, a tela e a logica
	 *está toda pronto 
	 */
	private JTable tabela;
	private DefaultTableModel model;
	private ControllerRoupa controllerRoupa;
	public TelaListarRoupa() {
		repaint();
	}
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
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Preço");
		model.addColumn("Tamanho");
		controllerRoupa = new ControllerRoupa();
		ArrayList<Roupa> roupas = controllerRoupa.loadRoupa();
		for(Roupa r:roupas){
			model.addRow(new Object[]{r.getId(),r.getNome(),r.getPreco(),r.getTamanho()});
		}
		OuvinteAdicionarRoupaNoCarrinho ouvinte = new OuvinteAdicionarRoupaNoCarrinho();
		tabela = new JTable(model);
		tabela.addMouseListener(ouvinte);
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 40, 494, 330);
		add(painel);
	}
	
	public class OuvinteAdicionarRoupaNoCarrinho implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			Object obj = model.getValueAt(tabela.getSelectedRow(),0);
            String id_produto = String.valueOf(obj);
			int id = Integer.parseInt(id_produto);
			Roupa roupa = controllerRoupa.searchRoupa(id);
			Carrinho carrinho = Carrinho.getInstance();
			carrinho.addRoupa(roupa);
			JOptionPane.showMessageDialog(null, "Adicionado no carrinho");
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		
	}
}