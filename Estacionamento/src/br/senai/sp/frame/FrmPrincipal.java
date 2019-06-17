package br.senai.sp.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.calculos.Calculos;
import br.senai.sp.dao.EstacionamentoDAO;
import br.senai.sp.model.ClienteEstacionamento;
import br.senai.sp.utils.Formatacao;
import br.senai.sp.utils.Tempo;

public class FrmPrincipal extends JFrame {
	
	public JTable tabelaClientes = new JTable();
	public FrmRegistroCliente telaRegistro;
	public JPanel painelTabela;
	public JScrollPane scroll = new JScrollPane();
	public JComboBox combo;
	public TitledBorder bordaTabela; 
	
	@SuppressWarnings("unchecked")
	public FrmPrincipal() {
		
		setTitle("Estacionamento");
		setSize(600,625);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Font fonteTitulo = new Font("Roboto", Font.BOLD, 26);
		Font fonteTextoTitulo = new Font("Roboto", Font.BOLD, 16);
		Font fonteTexto = new Font("Roboto", Font.PLAIN, 16);
		
		//Criar painel da tabela
		painelTabela = new JPanel();
		painelTabela.setBounds(10, 10, 560, 450);
		painelTabela.setLayout(null);
		bordaTabela = new TitledBorder("Lista de Veículos Estacionados");
		painelTabela.setBorder(bordaTabela);
		
		//Criação de combo box de exibições
		String[] opcoesFiltro = {"Veículos Estacionados", "Veículos Ausentes"};
		combo = new JComboBox<Object>(opcoesFiltro);
		combo.setBounds(400, 15, 150, 30);
		painelTabela.add(combo);
		
		//Criar painel dos botões
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(12, 470, 556, 100);
		TitledBorder bordaBotoes = new TitledBorder("");
		painelBotoes.setBorder(bordaBotoes);
		painelBotoes.setLayout(null);
		
		//Criação dos Botões
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setBounds(10,10,100,80);
		btnAdicionar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/entrada.png")));
		btnAdicionar.setToolTipText("Registrar entrada de veículo");
		
		JButton btnEditar= new JButton("");
		btnEditar.setBounds(150,10,100,80);
		btnEditar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/editar.png")));
		btnEditar.setToolTipText("Editar placa ou modelo");
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setBounds(290,10,100,80);
		btnExcluir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/saida.png")));
		btnExcluir.setToolTipText("Registrar saída de veículo");
		
		JButton btnSair= new JButton("");
		btnSair.setBounds(445,10,100,80);
		btnSair.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/desligar64.png")));
		btnSair.setToolTipText("Sair da aplicação");
		
		//Adição dos botões
		painelBotoes.add(btnAdicionar);
		painelBotoes.add(btnExcluir);
		painelBotoes.add(btnEditar);
		painelBotoes.add(btnSair);
		painelBotoes.setBackground(Color.BLACK);
		
		//Adição dos painéis no painel principal
		getContentPane().add(painelTabela);
		getContentPane().add(painelBotoes);
		
		//OUVINTES DE AÇÃO
		
		//Testado e aprovado em 29/04
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(combo.getSelectedItem() == "Veículos Ausentes") {
					criarTabelaAusentes();
					btnAdicionar.setEnabled(false);
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
					
					bordaTabela = new TitledBorder("Lista de Veículos Ausentes");
					painelTabela.setBorder(bordaTabela);
					
				} else {
					criarTabelaEstacionados();
					btnAdicionar.setEnabled(true);
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					
					bordaTabela = new TitledBorder("Lista de Veículos Estacionados");
					painelTabela.setBorder(bordaTabela);
				}
			}
			
		});
		
		//Testado em 24/04 - sucesso
		btnAdicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FrmRegistroCliente telaCadastro = new FrmRegistroCliente();
				telaCadastro.setVisible(true);
				
			}
		});
		
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				abrirRegistro("Atualizar veículo","ATUALIZAR","editar.png");
			}
		});
		
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				abrirRegistro("Excluir Veículo","EXCLUIR", "saida.png");			
				
			}
		});
		
		//Testado e aprovado em 24/04
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?", "Fechar Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				//O Yes retorna número 0, e No retorna número 1					
				if(resposta == 0) {
					System.exit(EXIT_ON_CLOSE);	
				}			
			}
		});
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
				criarTabelaEstacionados();
				
			}
		});
		
		setVisible(true);
		
	}
	
	//Aprovado - 24/04
	private void criarTabelaEstacionados() {
		
		//Criar os vetores matriz para preencher a tabela
		String[] cabecalho = {
				"ID", 
				"MODELO",
				"PLACA",
				"ENTRADA"
				};
		
		// Conectar com o banco de dados
		EstacionamentoDAO dao = new EstacionamentoDAO();
		ArrayList<ClienteEstacionamento> clientesEstacionados = dao.listarEstacionados();
		
		//Exibição em tela, puxando os dados do banco
		int linhas = clientesEstacionados.size();
		String[][] dados = new String[linhas][4];
				
		int linha = 0;

		for(ClienteEstacionamento cliente : clientesEstacionados) {
			dados[linha][0] = String.valueOf(cliente.getCodigo());
			dados[linha][1] = cliente.getModelo();
			dados[linha][2] = Formatacao.converterPlacaParaUsuario(cliente.getPlaca());
			dados[linha][3] = cliente.getDataEntrada();
			linha++;
		}
		
		//Ordem na criação de tabelas
		//1 - Cria-se um objeto scroll (a barra de rolagem) com JScrollPane
		//2 - Cria-se um modelo de tabela com DefaultTableModel (tabela padrão) que leva como argumento um vetor de cabeçalho e um array de dados
		//3 - Cria-se um objeto tabela com JTable
		//4 - É o Scroll que é adicionado ao painel de visualização criado, então o painel de visualização adiciona o Scroll
		//5 - Toda tabela precisa de um modelo. Então o modelo criado deve ser adicionado ao objeto tabela pelo método setModel(modelo criado)
		//6 - O objeto scroll exibe a tabela, que já possui o modelo inserido, com o método setViewportView(tabela)
		
		scroll.setBounds(10, 55, 540, 380);
				
		DefaultTableModel modelo = new DefaultTableModel(dados, cabecalho);
		
		tabelaClientes.setModel(modelo);
		tabelaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(160);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(190);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(138);
		tabelaClientes.setDefaultEditor(Object.class, null);
		tabelaClientes.getTableHeader().setReorderingAllowed(false);
		tabelaClientes.getTableHeader().setResizingAllowed(false);

		scroll.setViewportView(tabelaClientes);
		painelTabela.add(scroll);
	}
	
	private void criarTabelaAusentes() {
		
		//Criar os vetores matriz para preencher a tabela
		String[] cabecalho = {
				"ID", 
				"MODELO",
				"PLACA",
				"ENTRADA",
				"SAÍDA",
				"TEMPO (HORAS PAGAS)",
				"VALOR PAGO"
				};
		
		// Conectar com o banco de dados
		EstacionamentoDAO dao = new EstacionamentoDAO();
		ArrayList<ClienteEstacionamento> clientesAusentes = dao.listarAusentes();
		
		//Exibição em tela, puxando os dados do banco
		int linhas = clientesAusentes.size();
		String[][] dados = new String[linhas][7];
				
		int linha = 0;

		for(ClienteEstacionamento cliente : clientesAusentes) {
			dados[linha][0] = String.valueOf(cliente.getCodigo());
			dados[linha][1] = cliente.getModelo();
			dados[linha][2] = Formatacao.converterPlacaParaUsuario(cliente.getPlaca());
			dados[linha][3] = cliente.getDataEntrada();
			dados[linha][4] = cliente.getDataSaida();
			dados[linha][5] = String.valueOf(cliente.getTempo()) + " hora(s)";
			dados[linha][6] = "R$ " + String.valueOf(cliente.getValor());
			linha++;
		}
		
		//Ordem na criação de tabelas
		//1 - Cria-se um objeto scroll (a barra de rolagem) com JScrollPane
		//2 - Cria-se um modelo de tabela com DefaultTableModel (tabela padrão) que leva como argumento um vetor de cabeçalho e um array de dados
		//3 - Cria-se um objeto tabela com JTable
		//4 - É o Scroll que é adicionado ao painel de visualização criado, então o painel de visualização adiciona o Scroll
		//5 - Toda tabela precisa de um modelo. Então o modelo criado deve ser adicionado ao objeto tabela pelo método setModel(modelo criado)
		//6 - O objeto scroll exibe a tabela, que já possui o modelo inserido, com o método setViewportView(tabela)
		
		scroll.setBounds(10, 55, 540, 380);
				
		DefaultTableModel modelo = new DefaultTableModel(dados, cabecalho);
		
		tabelaClientes.setModel(modelo);
		tabelaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(160);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(190);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(140);
		tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(140);
		tabelaClientes.getColumnModel().getColumn(5).setPreferredWidth(140);
		tabelaClientes.getColumnModel().getColumn(6).setPreferredWidth(115);
		tabelaClientes.setDefaultEditor(Object.class, null);
		tabelaClientes.getTableHeader().setReorderingAllowed(false);
		tabelaClientes.getTableHeader().setResizingAllowed(false);

		scroll.setViewportView(tabelaClientes);
		painelTabela.add(scroll);
	}
	
	
	private void abrirRegistro(String textoDoTitulo, String textoDoBotao, String enderecoImagem){
		
		int linha = tabelaClientes.getSelectedRow();
		int coluna = 0; //Sempre é 0, pois é a coluna da matrícula
		
		if(linha == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um veículo na lista.", "Veículo não selecionado", JOptionPane.ERROR_MESSAGE);
		} else {
			
			int id = Integer.parseInt(tabelaClientes.getValueAt(linha, coluna).toString());
			
			ClienteEstacionamento cliente = new ClienteEstacionamento();
			Calculos calc = new Calculos();
			EstacionamentoDAO dao = new EstacionamentoDAO();
			cliente = dao.buscarPorCodigo(id);

			telaRegistro = new FrmRegistroCliente();

			telaRegistro.txtPlaca.setText(Formatacao.converterPlacaParaUsuario(cliente.getPlaca()));
			telaRegistro.txtModelo.setText(cliente.getModelo());
			
			telaRegistro.btGravar.setText(textoDoBotao);
			
			telaRegistro.lblEntrada.setText("Data/Hora Entrada");
			telaRegistro.lblInfoEntrada.setText(Formatacao.converterDataParaUsuario(cliente.getDataEntrada()));
			telaRegistro.lblTitulo.setText(textoDoTitulo);
			telaRegistro.lblRegistro.setText(String.valueOf(cliente.getCodigo()));
			
			if(textoDoBotao.equals("EXCLUIR")) {
				telaRegistro.lblTitulo.setForeground(new Color(255,0,0));
				telaRegistro.lblRegistro.setForeground(new Color(255,0,0));
				telaRegistro.lblSaida.setText("Data/Hora Saída");
				telaRegistro.lblInfoSaida.setText(Formatacao.converterDataParaUsuario(Tempo.coletarDataEHoraAtuais()));
				telaRegistro.lblTempo.setText("Tempo a Pagar");
				telaRegistro.lblInfoTempo.setText(String.valueOf(Tempo.calcularTempo(cliente.getDataEntrada())) + " hora(s)");
				telaRegistro.lblValorAPagar.setText("Valor de Pagamento");
				telaRegistro.lblInfoValorAPagar.setText("R$" + String.valueOf(calc.calcularValorAPagar(cliente)));
				telaRegistro.lblIcone.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/" + enderecoImagem)));
				telaRegistro.lblInfoPlaca.setText(" ");
				telaRegistro.btGravar.setBackground(new Color(255,0,0));
				
			} else if(textoDoBotao.equals("ATUALIZAR")) {
				telaRegistro.lblTitulo.setForeground(new Color(193,139,58));
				telaRegistro.lblRegistro.setForeground(new Color(193,139,58));
				telaRegistro.lblIcone.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/" + enderecoImagem)));
				telaRegistro.lblInfoPlaca.setText(" ");
				telaRegistro.btGravar.setBackground(new Color(193,139,58));
			}
			
			telaRegistro.setVisible(true);
		}
		
		
	}
	

}

