package br.senai.sp.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import br.senai.sp.dao.EstacionamentoDAO;
import br.senai.sp.model.ClienteEstacionamento;
import br.senai.sp.utils.Formatacao;
import br.senai.sp.utils.Tempo;
import br.senai.sp.utils.Validacao;

public class FrmRegistroCliente extends JDialog{
	
	public JTextField txtPlaca;
	public JTextField txtModelo;
	
	public JButton btGravar;
	
	public JLabel lblPlaca;
	public JLabel lblInfoPlaca;
	public JLabel lblModelo;
	public JLabel lblEntrada;
	public JLabel lblInfoEntrada;
	public JLabel lblSaida;
	public JLabel lblInfoSaida;
	public JLabel lblTempo;
	public JLabel lblInfoTempo;
	public JLabel lblValorAPagar;
	public JLabel lblInfoValorAPagar;
	public JLabel lblIcone;
	public JLabel lblTitulo;
	public JLabel lblRegistro;
	
	public Color azul;
	public Color amarelo;
	public Color branco;
	public Color verde;
	public Color vermelho;
	public Color cinza;
	public Color cinzaClaro;
	public Color preto;
	
	public Border bordaPreta;
	public Border bordaVerde;
	public Border bordaVermelha;
	public Border bordaAmarela;
	
	
	//Declaração de classe construtora com métodos da JFrame
		public FrmRegistroCliente() {
			this.setSize(455, 500); //Tamanho da tela, width and height
			this.setResizable(false); //Comando que permite ou não ser redimensionado pelo usuário
			this.setTitle("Registro de Veículos"); //Título para aparecer na barra de título
			this.setLayout(null); //Com o null, existe a liberação de controle padrão, fica tudo por parte do desenvolvedor
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Comando utilizado para fechar a aplicação //ao fecha-la definitivamente 
			this.setLocationRelativeTo(null); //Comando para aparecer no centro da tela
			this.setBackground(branco);
			
			// ** Declarando os componentes
			lblPlaca = new JLabel("Placa:");
			lblInfoPlaca = new JLabel("Ex: XXX0000 ou XXX-0000");
			lblModelo = new JLabel("Modelo:");
			lblEntrada = new JLabel("Entrada:");
			lblInfoEntrada = new JLabel(Formatacao.converterDataParaUsuario(Tempo.coletarDataEHoraAtuais()));
			lblSaida = new JLabel(" ");
			lblInfoSaida = new JLabel(" ");
			lblTempo = new JLabel(" ");
			lblInfoTempo = new JLabel(" ");
			lblValorAPagar = new JLabel(" ");
			lblInfoValorAPagar = new JLabel(" ");
			lblTitulo = new JLabel("Registro de Veículo");
			lblRegistro = new JLabel(" ");
			lblIcone = new JLabel("");
			
			txtPlaca = new JTextField();
			txtModelo = new JTextField();
			
			btGravar = new JButton("GRAVAR");
			btGravar.setToolTipText("Registrar novo veículo");
			
			JPanel painelTitulo = new JPanel();
			JPanel painelPrincipal = new JPanel();
			
			azul = new Color(0,21,109);
			amarelo = new Color(255,240,45);
			branco = new Color(255,255,255);
			verde = new Color(10,255,23);
			vermelho = new Color(255,10,0);
			cinza = new Color(224, 222, 222);
			cinzaClaro = new Color(237,234,234);
			preto = new Color(0,0,0);
			
			Font fonteTitulo = new Font("Roboto", Font.BOLD, 26);
			Font fonteTextoTitulo = new Font("Roboto", Font.BOLD, 16);
			Font fonteTexto = new Font("Roboto", Font.PLAIN, 16);
			
			// ** Posicionamento de componentes - Telas e títulos
			
			//Bordas
			bordaPreta= BorderFactory.createLineBorder(preto);
			bordaVerde= BorderFactory.createLineBorder(verde);
			bordaVermelha= BorderFactory.createLineBorder(vermelho);
			bordaAmarela= BorderFactory.createLineBorder(amarelo);
			
			//Painel Título
			painelTitulo.setBounds(0, 0, 455, 80);
			painelTitulo.setLayout(null);
			painelTitulo.setBackground(cinzaClaro);
			
			
			lblIcone.setIcon(new ImageIcon(FrmRegistroCliente.class.getResource("/br/senai/sp/imagens/entrada.png")));
			lblIcone.setBounds(20, 10, 100, 64);
			
			lblTitulo.setBounds(125, 10, 300, 50);
			lblTitulo.setFont(fonteTitulo);
			lblTitulo.setForeground(azul);
			
			lblRegistro.setBounds(380, 20, 100, 30);
			lblRegistro.setFont(fonteTitulo);
			
			TitledBorder bordaPainelTitulo = new TitledBorder(bordaPreta, "");
			painelTitulo.setBorder(bordaPainelTitulo);
			
			//Painel Principal
			painelPrincipal.setBounds(0, 80, 455, 630);
			painelPrincipal.setLayout(null);
			painelPrincipal.setBackground(cinzaClaro);
			
			TitledBorder bordaPainelPrincipal = new TitledBorder(bordaPreta, "");
			painelPrincipal.setBorder(bordaPainelPrincipal);
			
			// ** Adicionar os componentes no painel Título
			painelTitulo.add(lblTitulo);
			painelTitulo.add(lblIcone);
			painelTitulo.add(lblRegistro);
			
			// ** Adicionar os componentes no painel principal
			painelPrincipal.add(txtPlaca);
			painelPrincipal.add(txtModelo);
			
			painelPrincipal.add(lblPlaca);
			painelPrincipal.add(lblInfoPlaca);
			painelPrincipal.add(lblModelo);
			painelPrincipal.add(lblEntrada);
			painelPrincipal.add(lblInfoEntrada);
			painelPrincipal.add(lblSaida);
			painelPrincipal.add(lblInfoSaida);
			painelPrincipal.add(lblTempo);
			painelPrincipal.add(lblInfoTempo);
			painelPrincipal.add(lblValorAPagar);
			painelPrincipal.add(lblInfoValorAPagar);
			
			painelPrincipal.add(btGravar);
			
			// ** Posicionar os componentes no painel Principal
			btGravar.setBounds(260, 280, 150, 45);
			btGravar.setFont(fonteTextoTitulo);
			lblPlaca.setBounds(40, 20, 100, 25);
			lblPlaca.setFont(fonteTextoTitulo);
			lblInfoPlaca.setBounds(150, 50, 200, 25);
			lblInfoPlaca.setFont(fonteTexto);
			txtPlaca.setBounds(40, 50, 100, 25);
			txtPlaca.setFont(fonteTexto);
			lblModelo.setBounds(40, 110, 100, 25);
			lblModelo.setFont(fonteTextoTitulo);
			txtModelo.setBounds(40,140,100,25);
			txtModelo.setFont(fonteTexto);
			lblEntrada.setBounds(40, 220, 150, 25);
			lblEntrada.setFont(fonteTextoTitulo);
			lblInfoEntrada.setBounds(40, 250, 200, 25);
			lblInfoEntrada.setFont(fonteTexto);
			lblSaida.setBounds(40, 310, 150, 25);
			lblSaida.setFont(fonteTextoTitulo);
			lblInfoSaida.setBounds(40, 340, 200, 25);
			lblInfoSaida.setFont(fonteTexto);
			lblTempo.setBounds(260, 90, 150, 25);
			lblTempo.setFont(fonteTextoTitulo);
			lblInfoTempo.setBounds(260, 115, 100, 25);
			lblInfoTempo.setFont(fonteTexto);
			lblValorAPagar.setBounds(260, 175, 180, 25);
			lblValorAPagar.setFont(fonteTextoTitulo);
			lblInfoValorAPagar.setBounds(260, 205, 100, 25);
			lblInfoValorAPagar.setFont(fonteTexto);
			
			// ** Inserir os painéis no Frame e tornar visível
			this.getContentPane().add(painelTitulo);
			this.getContentPane().add(painelPrincipal);
			
			// ** Ouvinte de evento
			btGravar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(btGravar.getText().equals("GRAVAR")) {
						//Testado e aprovado em 24/04
						gravar();
					} else if(btGravar.getText().equals("EXCLUIR")){
						excluir(); 
					} else if(btGravar.getText().equals("ATUALIZAR")){
						atualizar();
					}
					
				};
			});
			
			//Tornando a tela de cadastro Modal
			//Tornando o principal foco da tela, bloqueando a anterior
			this.setModal(true);
			
		}
		
		//Método para atualizar saída de um veículo
		private void excluir() {
			
			int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o veículo com placa de número " + txtPlaca.getText() + " ?", "Excluir veículo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(resposta == 0) {
				EstacionamentoDAO dao = new EstacionamentoDAO(criarVeiculo());
				dao.atualizarSaida(Integer.parseInt(lblRegistro.getText()));
				this.dispose();
			}
		
		}
		
		//Método para atualizar um aluno
		private void atualizar(){
			
			EstacionamentoDAO dao = new EstacionamentoDAO(criarVeiculo());
			dao.atualizarDados(Integer.parseInt(lblRegistro.getText()));
			JOptionPane.showMessageDialog(null,"Dado atualizado com sucesso!","Atualização de Dados", JOptionPane.INFORMATION_MESSAGE); 
			
		}

		//Método para gravar um aluno
		public void gravar() {

			//Salvando no banco de dados
			EstacionamentoDAO dao = new EstacionamentoDAO(criarVeiculo());
			
			if(dao != null) {
				dao.gravar();
				JOptionPane.showMessageDialog(null,"Veículo Gravado com Sucesso!","Novo Veículo", JOptionPane.INFORMATION_MESSAGE);
			} 
			
			//Impede que o usuário salve mais de uma vez
			btGravar.setEnabled(false);
		}

		private ClienteEstacionamento criarVeiculo() {
			ClienteEstacionamento cliente = new ClienteEstacionamento();
			
			//Seta o registro somente se já for um veículo existente
			if(!btGravar.getText().equals("GRAVAR")) {
				cliente.setCodigo(Integer.parseInt(lblRegistro.getText()));
			} 
			
			if(btGravar.getText().equals("EXCLUIR")) {
				cliente.setDataEntrada(Formatacao.converterDataParaBanco(lblInfoEntrada.getText()));
				cliente.setDataSaida(Tempo.coletarDataEHoraAtuais());
			}
			
			//Setando valores
			if(Validacao.validarPlaca(txtPlaca.getText()) && Validacao.validarModelo(txtModelo.getText())){
				cliente.setPlaca(Formatacao.converterPlacaParaBanco(txtPlaca.getText()));
				cliente.setModelo(txtModelo.getText());
				return cliente;
			} else {
				return null;
			}
			
		}
		
}
