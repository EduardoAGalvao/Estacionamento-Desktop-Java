package br.senai.sp.calculos;

import javax.swing.JOptionPane;

import br.senai.sp.dao.UsuarioDAO;
import br.senai.sp.model.Usuario;

	public class Autenticacao {
		
		private UsuarioDAO user_dao = new UsuarioDAO();
		
		public boolean autenticar(String nome_usuario, String senha) {
			
			Usuario user = user_dao.buscarPorUsuario(nome_usuario, senha);
		
		if(user != null) {
			JOptionPane.showMessageDialog(null, "Bem-vindo, " + user.getNome() + "!");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos. Por gentileza, digite valores válidos de cadastro.");
			return false;
		}	
	}
}
