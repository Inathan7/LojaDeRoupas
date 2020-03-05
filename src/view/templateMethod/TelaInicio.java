package view.templateMethod;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import view.ouvintes.OuvinteAdmin;
import view.ouvintes.OuvinteEntrar;
import view.ouvintes.OuvinteSair;

public class TelaInicio extends TemplateMethodTela {

	public TelaInicio() {
		repaint();
	}
	@Override
	public void adicionarBotoes() {
		OuvinteEntrar ouvinte = new OuvinteEntrar(this);
		JButton botao = new JButton("Entrar",new ImageIcon(getClass().getResource("/icons8-login-filled-23.png")));
		botao.setBounds(200, 300, 98, 30);
		botao.addActionListener(ouvinte);
		add(botao);

		OuvinteSair ouvinteSair = new OuvinteSair(this);
		JButton sair = new JButton("Sair");
		sair.setBounds(400, 30, 60, 30);
		sair.addActionListener(ouvinteSair);
		add(sair);

		OuvinteAdmin cadastrar = new OuvinteAdmin(this);
		JButton admin = new JButton("Cadastrar",new ImageIcon(getClass().getResource("/icons8-usuário-homem-com-círculo-25.png")));
		admin.setBounds(174, 250, 148, 30);
		admin.addActionListener(cadastrar);
		add(admin);
	}

	@Override
	public void adicionarJLabel() {
		JLabel bemVindo = new JLabel("Bem-Vindo(a)");
		bemVindo.setFont(new Font("Arial", Font.BOLD, 16));
		bemVindo.setBounds(200, 30, 105, 30);
		add(bemVindo);

		JLabel nome = new JLabel("Fashion Designer Pattern");
		nome.setFont(new Font("Arial", Font.BOLD, 16));
		nome.setForeground(Color.WHITE);
		nome.setBounds(160, 70, 200, 30);
		add(nome);

		JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("/TelaDeFundo.jpg")));
		fundo.setBounds(0, 0, 500, 400);
		add(fundo);
	}
}
