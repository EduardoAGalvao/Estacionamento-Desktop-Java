package br.senai.sp.model;

public class ClienteEstacionamento {
	private int codigo;
	private String placa;
	private String modelo;
	private String dataEntrada;
	private String dataSaida;
	private int tempo;
	private double valor;
	
	/*Get - Valor*/
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/*Get & Set Placa*/
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	/*Get & Set Modelo*/
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	/*Get & Set - Data de Entrada*/
	// datas no banco de dados devem ser inseridos no formato 'yyyy-MM-dd'
	public String getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	/*Get & Set - Data de Saída*/
	// datas no banco de dados devem ser inseridos no formato 'yyyy-MM-dd'
	public String getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	/*Get & Set - Tempo*/
	public int getTempo() {
		return tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	/*Get & Set - Valor*/
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
