package br.senai.sp.utils;

public class Formatacao {
	
	public static String converterDataParaUsuario(String data) {
		
		String dataCompleta;
		String dataTela;
		String horaTela;
		
		String dia = data.substring(8, 10);
		String mes = data.substring(5,7);
		String ano = data.substring(0,4);
		dataTela = dia + "/" + mes + "/" + ano;
		
		horaTela = data.substring(11, 19);
		
		dataCompleta = dataTela + "  " + horaTela;
		
		return dataCompleta;
	}
	
	public static String converterDataParaBanco(String data) {
		
		String dataCompleta;
		String dataBanco;
		String horaBanco;

		String dia = data.substring(0, 2);
		String mes = data.substring(3,5);
		String ano = data.substring(6,10);
		dataBanco = ano + "-" + mes + "-" + dia;
		
		horaBanco = data.substring(12, 20);
		
		dataCompleta = dataBanco + " " + horaBanco;
		
		return dataCompleta;
	}
	
	public static String converterPlacaParaUsuario(String placa) {
		
		String letras = placa.substring(0,3);
		String numeros = placa.substring(3,7);
		
		String placaFinal = letras + "-" + numeros;
		
		return placaFinal;
	}
	
	//Retira o hífen caso seja feita edição
	public static String converterPlacaParaBanco(String placa) {
		
		String placaFinal = "";
		String letras = "";
		String numeros = "";
		
		if(placa.contains("-")) {
			numeros = placa.substring(4,8);
		} else {	
			numeros = placa.substring(3,7);
		}
		
		letras = placa.substring(0,3);
		placaFinal = letras.toUpperCase() + numeros;
		
		return placaFinal;
	}
}
