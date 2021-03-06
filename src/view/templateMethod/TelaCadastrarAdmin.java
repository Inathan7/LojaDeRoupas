package view.templateMethod;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.ouvintes.OuvinteAdicionarAdmin;
import view.ouvintes.OuvinteVerSenha;
import view.ouvintes.OuvinteVoltarTelaInicio;

public class TelaCadastrarAdmin extends TemplateMethodTela{
	private JTextField campoNome;
	private JTextField campoEmail; 
	private JPasswordField campoSenha;
	private JComboBox<String> sexo;
	private JLabel ver;

	public TelaCadastrarAdmin() {
		repaint();
	}	
	public void adicionarBotoes() {
		OuvinteVoltarTelaInicio ouvinteVoltarTelaInicio = new OuvinteVoltarTelaInicio(this);
		JButton botao = new JButton("Voltar");
		botao.setBounds(400, 10, 80, 30);
		botao.addActionListener(ouvinteVoltarTelaInicio);
		add(botao);
		
		OuvinteAdicionarAdmin ouvinteAdicionarAdmin = new OuvinteAdicionarAdmin(this);
		JButton botaoCadastrar = new JButton("Cadastrar",new ImageIcon(getClass().getResource("/icons8-adicionar-administrador-filled-28.png")));
		botaoCadastrar.setBounds(172, 310, 128, 34);
		botaoCadastrar.addActionListener(ouvinteAdicionarAdmin);
		add(botaoCadastrar);
	}

	@Override
	public void adicionarJLabel() {
		JLabel cadastrar = new JLabel("Cadastrar Administrador");
		cadastrar.setBounds(165, 10, 200, 40);
		cadastrar.setFont(new Font("Arial",Font.BOLD,16));
		add(cadastrar);
		
		JLabel nome = new JLabel("Nome");
		nome.setBounds(80, 50, 40, 30);
		nome.setFont(new Font("Arial",Font.BOLD,12));
		add(nome);
		
		JLabel email = new JLabel("E-mail");
		email.setBounds(80, 90, 50, 30);
		email.setFont(new Font("Arial",Font.BOLD,12));
		add(email);
		
		JLabel senha = new JLabel("Senha");
		senha.setBounds(80, 130, 50, 30);
		senha.setFont(new Font("Arial",Font.BOLD,12));
		add(senha);
		
		OuvinteVerSenha verSenha = new OuvinteVerSenha(this);
		ver = new JLabel();
		ver.setBounds(355, 130, 30, 30);
		ver.setIcon(new ImageIcon(getClass().getResource("/icons8-invisível-30.png")));
		ver.addMouseListener(verSenha);
		add(ver);
	}
	@Override
	public void adicionarTextField() {
		campoNome = new JTextField();
		campoNome.setBounds(125, 50, 220, 30);
		add(campoNome);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(125, 90, 220, 30);
		add(campoEmail);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(125, 130, 220, 30);
		add(campoSenha);
	}
	@Override
	public void adicionarJComboBox() {
		sexo = new JComboBox<String>();
		sexo.addItem("Masculino");
		sexo.addItem("Feminino");
		sexo.setBounds(280, 180, 90, 30);
		add(sexo);
	}
	
	public JLabel getVer() {
		return ver;
	}
	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public JComboBox<String> getSexo() {
		return sexo;
	}
}