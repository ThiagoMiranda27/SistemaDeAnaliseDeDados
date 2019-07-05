package br.com.ibm.sistemaAnaliseDeDados.model;

public class Venda {

	private String idVenda;
	private double vendaPreco;
	private String vendedor;
	
	
	public Venda(String vendaId, double vendaPreco, String vendedor) {
		this.idVenda = vendaId;
		this.vendaPreco = vendaPreco;
		this.vendedor = vendedor;
		
	}
	
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
