package br.senai.sp.app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.senai.sp.calculos.Calculos;
import br.senai.sp.frame.FrmAutenticacao;
import br.senai.sp.frame.FrmPrincipal;
import br.senai.sp.model.Usuario;


public class EstacionamentoApp {

	public static void main(String[] args) {
		
		//Capturando a skin do sistema para montar o projeto (pode ser Windows, Linux, etc)
		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		
		//Internacionalização da aplicação, onde troca-se o idioma dos botões de OptionPanes 
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		//Classe FrmAutenticacao
		//Teste de FrmAutenticacao.FrmAutenticacao() - Sucesso em 29/04
		FrmAutenticacao frmUsuario = new FrmAutenticacao();
		
		//Classe FrmPrincipal
		//Teste de FrmPrincipal.FrmPrincipal() - Sucesso em 23/04
		//FrmPrincipal frmTela = new FrmPrincipal();
		
		/******************************************TESTES******************************************/
	
		//Classe Conexao
		//Teste de conexão - Sucesso em 22/04
		//Conexao.getConexao();
		
		//Classe Data
		//Teste de Data.converterParaUsuario(String data) - Sucesso em 22/04
		//Data.converterParaUsuario("2019-04-22 07:01:00");
		
		//Teste de Data.calcularTempo() - Sucesso em 22/04
		//Data.calcularTempo("teste");
		
		//Teste de Data.coletarDataEHoraAtuais() - Sucesso em 22/04
		//Data.coletarDataEHoraAtuais();
		
		//Classe EstacionamentoDAO
		//Teste de EstacionamentoDAO.buscarValorPrimeiraHora() - Sucesso em 22/04
		//EstacionamentoDAO dao = new EstacionamentoDAO();
		//dao.buscarValorPrimeiraHora();

		//Teste de EstacionamentoDAO.buscarValorDemaisHoras() - Sucesso em 22/04
		//EstacionamentoDAO dao = new EstacionamentoDAO();
		//dao.buscarValorDemaisHoras();
		
		//Teste de método gravar() - Aprovado em 22/04
		//EstacionamentoDAO dao = new EstacionamentoDAO();
		//dao.gravar();
		
		//Teste de método buscarPorCodigo() - Aprovado em 22/04
		//EstacionamentoDAO dao = new EstacionamentoDAO();
		//dao.buscarPorCodigo(3);
		
		//Teste de método - listarEstacionados() - Aprovado em 22/04
		//EstacionamentoDAO dao = new EstacionamentoDAO();
		//dao.listarEstacionados();
		
		//Teste de método - atualizarSaida() - Aprovado em 22/04
		//EstacionamentoDAO dao = new EstacionamentoDAO();
		//dao.atualizarSaida(3);
		
		//Classe Calculos
		//Teste de Calculos.calcularValorAPagar() - Aprovado em 22/04
		/*
		ClienteEstacionamento cliente = new ClienteEstacionamento();
		Calculos calculos = new Calculos();
		cliente.setDataEntrada("22/04/2019 07:01:00");
		calculos.calcularValorAPagar(cliente);
		*/
		
		//Teste de Calculos.autenticar() - Aprovado em 29/04
		/*
		Usuario usuario = new Usuario();
		Calculos calculos = new Calculos();
		calculos.autenticar("operador");
		*/
		
				
	}

}
