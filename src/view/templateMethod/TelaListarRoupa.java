package view.templateMethod;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	private JTextField tfFiltro;
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
		
		OuvinteDoBtFiltro ouvinteDoBtFiltro = new OuvinteDoBtFiltro(this);
		JButton btLupa =new JButton(new ImageIcon(getClass().getResource("/icons8-pesquisar-28.png")));
		btLupa.setBounds(175, 5, 30, 30);
		btLupa.setBackground(new Color(255,255,255,0));
		btLupa.addActionListener(ouvinteDoBtFiltro);
		add(btLupa);
	}

	@Override
	public void adicionarJLabel() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void adicionarTextField() {
		tfFiltro = new JTextField();
		tfFiltro.setBounds(20, 5, 150, 30);
		add(tfFiltro);
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
	
	
	public class OuvinteDoBtFiltro implements ActionListener{
		private TelaListarRoupa telaListarRoupa;
		public OuvinteDoBtFiltro(TelaListarRoupa telaListarRoupa) {
			this.telaListarRoupa = telaListarRoupa;
		}
		public void actionPerformed(ActionEvent e) {
			model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Nome");
			model.addColumn("Preço");
			model.addColumn("Tamanho");
			String filtro = tfFiltro.getText().toLowerCase();

			for (Roupa roupa: controllerRoupa.loadRoupa()) {
				if(roupa.getNome().toLowerCase().contains(filtro) || roupa.getTamanho().toLowerCase().contains(filtro)) {
					Object[] row = new Object[] {
							roupa.getId(),
							roupa.getNome(),
							roupa.getPreco(),
							roupa.getTamanho()
					};
					model.addRow(row);
				}else if(filtro==null){
					adicionarTabela();
				}
			}

			telaListarRoupa.tabela.setModel(model);
			telaListarRoupa.repaint();	
		}	
	}	
}