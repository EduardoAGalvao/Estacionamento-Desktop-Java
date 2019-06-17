package br.senai.sp.calculos;

import br.senai.sp.dao.EstacionamentoDAO;
import br.senai.sp.dao.UsuarioDAO;
import br.senai.sp.model.ClienteEstacionamento;
import br.senai.sp.model.Usuario;
import br.senai.sp.utils.Tempo;

public class Calculos {
	
	private int horas; 
	private EstacionamentoDAO dao = new EstacionamentoDAO();
	private double valorPrimeiraHora = dao.buscarValorPrimeiraHora();
	private double valorDemaisHoras = dao.buscarValorDemaisHoras();
	
	public double calcularValorAPagar(ClienteEstacionamento cliente) {
		horas = Tempo.calcularTempo(cliente.getDataEntrada());
		
		double valor = 0;
		
		if(horas != 0) {
			valor = horas > 1 ? valorPrimeiraHora + ((horas-1) * valorDemaisHoras) : valorPrimeiraHora;
		}
		
		return valor;
	}
}
