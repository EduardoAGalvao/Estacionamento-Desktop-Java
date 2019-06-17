package br.senai.sp.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.senai.sp.calculos.Autenticacao;

public class FrmAutenticacao extends JFrame{
	
	public FrmPrincipal tabelaPrincipal;
	
	public JTextField txtUsuario;
	public JPasswordField txtSenha;
	public JLabel lblUsuario;
	public JLabel lblSenha;
	
	public JButton btLogin;
	
	public Autenticacao autenticacao = new Autenticacao();
	
	public FrmAutenticacao() {
		
		setTitle("Login");
		setSize(400,200);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Font fonteTextoTitulo = new Font("Roboto", Font.BOLD, 16);
		Font fonteTexto = new Font("Roboto", Font.PLAIN, 16);
		
		lblUsuario = new JLabel("Usuário: ");
		lblUsuario.setFont(fonteTextoTitulo);
		lblUsuario.setBounds(20, 20, 100, 30);
		
		lblSenha = new JLabel("Senha: ");
		lblSenha.setFont(fonteTextoTitulo);
		lblSenha.setBounds(20, 60, 100, 30);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(fonteTexto);
		txtUsuario.setBounds(100, 20, 150, 30);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(100, 60, 150, 30);
		
		btLogin = new JButton("LOGIN");
		btLogin.setBounds(250, 110, 100, 30);
		
		getContentPane().add(lblUsuario);
		getContentPane().add(lblSenha);
		getContentPane().add(txtUsuario);
		getContentPane().add(txtSenha);
		getContentPane().add(btLogin);
		
		this.setVisible(true);
		
		btLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String usuario = txtUsuario.getText();
				String senha = String.valueOf(txtSenha.getPassword());
				
				if(autenticacao.autenticar(usuario, senha)) {
					tabelaPrincipal = new FrmPrincipal();
					dispose();
				}
			}
				
				
		});
	}
	
}
