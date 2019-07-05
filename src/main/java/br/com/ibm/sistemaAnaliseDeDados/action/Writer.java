package br.com.ibm.sistemaAnaliseDeDados.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import br.com.ibm.sistemaAnaliseDeDados.gerenciador.gerenciadorCliente;
import br.com.ibm.sistemaAnaliseDeDados.gerenciador.gerenciadorVendas;
import br.com.ibm.sistemaAnaliseDeDados.gerenciador.gerenciadorVendedor;

public class Writer {

	private gerenciadorCliente clienteGerenciado = new gerenciadorCliente();
	private gerenciadorVendas vendasGerenciada = new gerenciadorVendas();
	private gerenciadorVendedor vendedorGerenciado = new gerenciadorVendedor();

	public Writer() {

		this.clienteGerenciado.getClienteList();
		this.vendasGerenciada.getVendaList();
		this.vendedorGerenciado.getVendedorList();

	}

	public void printRelatorio() {
		
		System.out.println("Quantidade de Clientes no arquivo: " + clienteGerenciado.totalClientes() + "\r\n"
				+ "Total de Vendedores no arquivo: " + vendedorGerenciado.TotalVendedor() + "\r\n"
				+ "Id da Venda Mais Cara: " + vendasGerenciada.getIdVendaMaisCara() + "\r\n"
				+ "Pior Vendedor: " + vendasGerenciada.getPiorVendedor());
	}
	
	public void arquivoDeRelalatorio() {

		FileWriter arquivo;

		try {
			String env = System.getenv("HOMEPATH");
			arquivo = new FileWriter(new File(env + "\\data\\out\\OutputFile.done.dat"));
			arquivo.write("Quantidade de Clientes no arquivo: " + clienteGerenciado.totalClientes() + "\r\n"
					+ "Total de Vendedores no arquivo: " + vendedorGerenciado.TotalVendedor() + "\r\n"
					+ "Id da Venda Mais Cara: " + vendasGerenciada.getIdVendaMaisCara() + "\r\n"
					+ "Pior Vendedor: " + vendasGerenciada.getPiorVendedor());
			
			arquivo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
