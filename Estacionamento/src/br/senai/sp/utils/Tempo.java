package br.senai.sp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Tempo {
	
	public static String coletarDataEHoraAtuais() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date momentoAtual = new Date(); 
		String dataFormatada = sdf.format(momentoAtual);
		
		return dataFormatada;
	}
	
	public static int calcularTempo(String dataEntrada) {
		
		//Obter a data de hoje
		Date hoje = new Date();
		
		//Definindo a toler�ncia em minutos
		int tolerancia = 5;
		
		//Criar um formatador de datas
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //Para capturar hora, usa-se HH:mm
		Date dataEntradaFormat = null;		
		
		//Transformar a data de nascimento em uma data
		try {
			dataEntradaFormat = dateFormat.parse(dataEntrada);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
				
		//Obter a diferen�a entre data de hoje e a data de nascimento em milisegundos
		long mils = hoje.getTime() - dataEntradaFormat.getTime();
		
		//Obter a quantidade de horas dos milisegundos
		double horas = mils / (1000*60*60);
		double minutos = mils / (1000*60);
		
		//Adequando as horas de acordo com a toler�ncia
		
		//Checando se j� completou no m�nimo 1 hora
		if(horas>0) {
			if(minutos > horas*60) {
				if((minutos - horas*60) > tolerancia ) {
					horas += 1;
				}
			}
		//Caso n�o tenha completado 1 hora, checar se ultrapassou a toler�ncia
		} else {
			if(minutos > tolerancia) {
				horas +=1;
			}
		}
	
		return (int)horas;
				
	}
}
