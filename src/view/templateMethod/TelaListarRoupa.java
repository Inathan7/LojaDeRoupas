package view.templateMethod;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerRoupa;
import model.Roupa;
import view.ouvintes.OuvinteVoltarTelaMenu;

public class TelaListarRoupa extends TemplateMethodTela{

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
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Preço");
		model.addColumn("Tamanho");
		ControllerRoupa controllerRoupa = new ControllerRoupa();
		ArrayList<Roupa> roupas = controllerRoupa.loadRoupa();
		for(Roupa r:roupas){
			model.addRow(new Object[]{r.getId(),r.getNome(),r.getPreco(),r.getTamanho()});
		}
		JTable tabela = new JTable(model);
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 40, 494, 330);
		add(painel);
	}
}