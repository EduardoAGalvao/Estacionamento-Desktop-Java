package br.senai.sp.model;

public class Usuario {
	private int id;
	private String nome;
	private String senha;
	private String usuario;
	
	/*Get & Set - ID*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*Get & Set - Nome*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*Get & Set - Senha*/
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/*Get & Set - Usuário*/
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
