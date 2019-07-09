package br.com.ibm.sistemaAnaliseDeDados.model;

public class Venda {

	//Atributos de venda
	private String idVenda;
	private double vendaPreco;
	private String vendedor;
	
	
	public Venda(String idVenda, double vendaPreco, String vendedor) { //Construtor de Venda
		this.idVenda = idVenda;
		this.vendaPreco = vendaPreco;
		this.vendedor = vendedor;
		
	}
	
	//Getters de Venda
	public String getIdVenda() {
		return idVenda;
	}


	public double getVendaPreco() {
		return vendaPreco;
	}


	public String getVendedor() {
		return vendedor;
	}

}
