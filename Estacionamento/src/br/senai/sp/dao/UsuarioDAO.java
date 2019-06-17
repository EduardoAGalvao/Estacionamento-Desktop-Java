package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.sp.model.ClienteEstacionamento;
import br.senai.sp.model.Usuario;

public class UsuarioDAO {
	
	private Usuario usuario = new Usuario();
	
	public Usuario buscarPorUsuario(String nome_usuario, String senha) {

		String sql = "SELECT * FROM tbl_usuario WHERE usuario = ? AND senha = ?";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, nome_usuario);
			stm.setString(2, senha);
			
			ResultSet rs;
			rs = stm.executeQuery();

			// Necessário para acertar o cursor no Result Set.
			rs.next();
		
			usuario.setNome(rs.getString("nome"));
			usuario.setUsuario(rs.getString("usuario"));
			usuario.setSenha(rs.getString("senha"));

			Conexao.fecharConexao();
			
			return usuario;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
		
	}
	
	
}
