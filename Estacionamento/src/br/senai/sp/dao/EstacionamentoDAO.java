package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.senai.sp.calculos.Calculos;
import br.senai.sp.model.ClienteEstacionamento;
import br.senai.sp.utils.Formatacao;
import br.senai.sp.utils.Tempo;

public class EstacionamentoDAO {

	private ClienteEstacionamento cliente = new ClienteEstacionamento();
	private Calculos calc;

	public EstacionamentoDAO(ClienteEstacionamento cliente) {
		this.cliente = cliente;
	}

	public EstacionamentoDAO() {
	}

	// CREATE
	public void gravar() {
		String sql = "INSERT INTO tbl_movimentacao " + "(placa, modelo, data_entrada, tempo, valor_pago) " + "VALUES(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, cliente.getPlaca());
			stm.setString(2, cliente.getModelo());
			stm.setString(3, Tempo.coletarDataEHoraAtuais());
			//0 será padrão de entrada para o tempo e valor_pago
			stm.setInt(4, 0);
			stm.setInt(5, 0);
			
			stm.execute();
			Conexao.fecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// READ
	public ClienteEstacionamento buscarPorCodigo(int codigo) {
		

		String sql = "SELECT * FROM tbl_movimentacao WHERE codigo = ?";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codigo);
			
			ResultSet rs;
			rs = stm.executeQuery();

			// Necessário para acertar o cursor no Result Set.
			rs.next();
			
			cliente.setCodigo(rs.getInt("codigo"));
			cliente.setPlaca(rs.getString("placa"));
			cliente.setModelo(rs.getString("modelo"));
			cliente.setDataEntrada(rs.getString("data_entrada"));
			cliente.setDataSaida(rs.getString("data_saida"));
			cliente.setTempo(rs.getInt("tempo"));
			cliente.setValor(rs.getDouble("valor_pago"));

			Conexao.fecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public ArrayList<ClienteEstacionamento> listarEstacionados() {
		
		ArrayList<ClienteEstacionamento> clientes = new ArrayList<ClienteEstacionamento>();

		String sql = "SELECT * FROM tbl_movimentacao WHERE data_saida IS NULL ORDER BY data_entrada";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);

			ResultSet rs;

			rs = stm.executeQuery();
			
			while(rs.next()) {
				cliente = new ClienteEstacionamento();
				
				cliente.setCodigo(rs.getInt("codigo"));
				cliente.setPlaca(rs.getString("placa"));
				cliente.setModelo(rs.getString("modelo"));
				cliente.setDataEntrada(Formatacao.converterDataParaUsuario(rs.getString("data_entrada")));
				
				clientes.add(cliente);
			}
			
			Conexao.fecharConexao();
			return clientes;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public ArrayList<ClienteEstacionamento> listarAusentes() {
		
		ArrayList<ClienteEstacionamento> clientes = new ArrayList<ClienteEstacionamento>();

		String sql = "SELECT * FROM tbl_movimentacao WHERE data_saida IS NOT NULL ORDER BY data_entrada";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);

			ResultSet rs;

			rs = stm.executeQuery();
			
			while(rs.next()) {
				cliente = new ClienteEstacionamento();
				
				cliente.setCodigo(rs.getInt("codigo"));
				cliente.setPlaca(rs.getString("placa"));
				cliente.setModelo(rs.getString("modelo"));
				cliente.setDataEntrada(Formatacao.converterDataParaUsuario(rs.getString("data_entrada")));
				cliente.setDataSaida(Formatacao.converterDataParaUsuario(rs.getString("data_saida")));
				cliente.setTempo(rs.getInt("tempo"));
				cliente.setValor(rs.getDouble("valor_pago"));
				clientes.add(cliente);
			}
			
			Conexao.fecharConexao();
			return clientes;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	// DELETE/UPDATE -> Não será excluido, só terá a saída atualizada
	public void atualizarSaida(int codigo) {
		String sql = "UPDATE tbl_movimentacao SET data_saida = ?, tempo = ?, valor_pago = ? WHERE codigo = ?";
		
		calc = new Calculos();
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, cliente.getDataSaida());
			stm.setInt(2, Tempo.calcularTempo(cliente.getDataEntrada()));
			stm.setDouble(3, calc.calcularValorAPagar(cliente));
			stm.setInt(4, codigo);

			// Executar o comando no banco
			stm.execute();
			Conexao.fecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//UPDATE -> Atualizar placa ou modelo
	public void atualizarDados(int codigo) {
		String sql = "UPDATE tbl_movimentacao SET placa = ?, modelo = ? WHERE codigo = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, cliente.getPlaca());
			stm.setString(2, cliente.getModelo());
			stm.setInt(3, codigo);

			// Executar o comando no banco
			stm.execute();
			Conexao.fecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Coletar valor de custo da primeira hora
	public double buscarValorPrimeiraHora() {
		String sql = "SELECT * FROM tbl_valor WHERE data_fim IS NULL";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			
			ResultSet rs;
			rs = stm.executeQuery();
			rs.next();
			
			double valor = rs.getDouble("valor_primeira_hora");
			
			Conexao.fecharConexao();
			
			return valor;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return (Double) null;
		}
	}
	
	//Coletar valor de custo das demais horas
	public double buscarValorDemaisHoras() {
		String sql = "SELECT * FROM tbl_valor WHERE data_fim IS NULL";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
				
			ResultSet rs;
			rs = stm.executeQuery();
			rs.next();
				
			double valor = rs.getDouble("valor_demais_horas");
				
			Conexao.fecharConexao();
				
			return valor;
				
		} catch (SQLException e) {
			e.printStackTrace();
			return (Double) null;
		}
	}

}
