package view.templateMethod;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControllerEncomenda;
import model.Encomenda;
import view.ouvintes.OuvinteVoltarTelaMenu;


public class TelaListarEncomendas extends TemplateMethodTela{
	
	//A classe de listar encomenda ta completa, se quiser adicionar alguma cois pode
	//ficar a vontade.
	
	private JTable tabela;
	private DefaultTableModel model;
	private JTextField tfFiltro;
	private ControllerEncomenda controllerEncomenda;
	@Override
	public void adicionarTextField(){
		tfFiltro = new JTextField();
		tfFiltro.setBounds(20, 5, 150, 30);
		add(tfFiltro);
	}
	public void adicionarBotoes() {
		OuvinteVoltarTelaMenu voltarMenu = new OuvinteVoltarTelaMenu(this);
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(400, 5, 80, 30);
		voltar.addActionListener(voltarMenu);
		add(voltar);
		
		OuvinteBtFiltro ouvinteDoBtFiltro = new OuvinteBtFiltro(this);
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
	public void adicionarTabela() {
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Cliente");
		model.addColumn("Roupa");
		model.addColumn("Tamanho");
		model.addColumn("Telefone");
		controllerEncomenda = new ControllerEncomenda();
		ArrayList<Encomenda> encomenda = controllerEncomenda.loadEncomenda();
		for(Encomenda e:encomenda){
			model.addRow(new Object[]{e.getID_Encomenda(),e.getNomeCliente(),
					e.getNomeRoupa(),e.getTamanhoRoupa(),e.getTelefone()});
		}
		tabela = new JTable(model);
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 40, 494, 330);
		add(painel);
	}
	public class OuvinteBtFiltro implements ActionListener{
		private TelaListarEncomendas tela;
		
		public OuvinteBtFiltro(TelaListarEncomendas tela) {
			this.tela = tela;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Cliente");
			model.addColumn("Roupa");
			model.addColumn("Tamanho");
			model.addColumn("Telefone");
			String filtro = tfFiltro.getText().toLowerCase();

			for (Encomenda encomenda: controllerEncomenda.loadEncomenda()) {
				if((encomenda.getID_Encomenda()+"").contains(filtro) || encomenda.getNomeCliente().toUpperCase().contains(filtro.toUpperCase())||
						encomenda.getNomeRoupa().toUpperCase().contains(filtro.toUpperCase())||encomenda.getTamanhoRoupa().toUpperCase().contains(filtro.toUpperCase())||
						encomenda.getTelefone().contains(filtro)) {
					Object[] row = new Object[] {
							encomenda.getID_Encomenda(),
							encomenda.getNomeCliente(),
							encomenda.getNomeRoupa(),
							encomenda.getTamanhoRoupa(),
							encomenda.getTelefone()
					};
					model.addRow(row);
				}else if(filtro==null){
					adicionarTabela();
				}
			}

			tela.tabela.setModel(model);
			tela.repaint();	
			
		}
		
	}

}
