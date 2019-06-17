package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static Connection con;

	public static Connection getConexao() {
		
		try {
			//Obtendo classe Driver que foi baixada. Esse tipo de classe não pode ser referenciada simplesmente como import
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Protocolo de comunicação entre Java e MySQL
			String dbUrl = "jdbc:mysql://localhost/db_estacionamento?useTimezone=true&serverTimezone=UTC&useSSL=false";
			
			//Usando o Driver do java.sql
			con = DriverManager.getConnection(dbUrl, "root","");
			//JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na abertura da conexão!");
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static void fecharConexao() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
