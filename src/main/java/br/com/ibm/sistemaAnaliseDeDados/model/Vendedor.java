package br.com.ibm.sistemaAnaliseDeDados.model;

public class Vendedor {

	//Atributos de vendedor
	private String cpf;
	private String name;
	private double salary;
	
	public Vendedor(String cpf, String name, double salary) { //Construtor de vendedor
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}
	
	//Getters de vendedor
	public String getCpf() {
		return cpf;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
}
