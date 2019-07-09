package br.com.ibm.sistemaAnaliseDeDados.model;

public class Cliente {

	//Atributos de cliente
	private String name;
	private String cnpj;
	private String businessArea;
	
	public Cliente(String name, String cnpj, String businessArea) { //Construtor de cliente
		
		this.name = name;
		this.cnpj = cnpj;
		this.businessArea = businessArea;
	}
	
	//Getters de cliente
	public String getName() {
		return name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public String getBusinessArea() {
		return businessArea;
	}	
}