package br.senai.sp.utils;

import javax.swing.JOptionPane;

public class Validacao {
	
	public static boolean validarPlaca(String placa) {
		if(placa.matches("^[A-Za-z]{3}[-]?[0-9]{4}$")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Por gentileza, digite a placa conforme exemplo: ABC-1234 ou ABC1234");
			return false;
		}	 
	}
	
	public static boolean validarModelo(String modelo) {
		if(modelo.matches("^[A-Za-z][A-Za-z0-9]+$")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Por gentileza, digite um modelo válido");
			return false;
		}	 
	}
	
}
