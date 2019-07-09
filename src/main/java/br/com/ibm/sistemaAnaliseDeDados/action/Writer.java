package br.com.ibm.sistemaAnaliseDeDados.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import br.com.ibm.sistemaAnaliseDeDados.action.*;
import br.com.ibm.sistemaAnaliseDeDados.gerenciador.gerenciadorCliente;
import br.com.ibm.sistemaAnaliseDeDados.gerenciador.gerenciadorVendas;
import br.com.ibm.sistemaAnaliseDeDados.gerenciador.gerenciadorVendedor;

public class Writer {

	//Chama as classes de gerenciador
	private gerenciadorCliente clienteGerenciado = new gerenciadorCliente();
	private gerenciadorVendas vendasGerenciada = new gerenciadorVendas();
	private gerenciadorVendedor vendedorGerenciado = new gerenciadorVendedor();

	public Writer() {
		
		//Cria os construtores das classes
		this.clienteGerenciado.getClienteList();
		this.vendasGerenciada.getVendaList();
		this.vendedorGerenciado.getVendedorList();

	}
	
	public void arquivoDeRelalatorio(String file) { //Metodo para gerar o Relatorio done.dat

		FileWriter arquivo;

		try {
			String env = System.getenv("HOMEPATH"); //direciona para o caminho em "HOMEPATH"
			new File(env + "\\data\\" + "out").mkdirs();  //cria a pasta out
			arquivo = new FileWriter(new File(env + "//data//out//"+ file + ".done.dat")); //gera o Relatorio com o nome do arquivo lido
			arquivo.write("Quantidade de Clientes no arquivo: " + clienteGerenciado.totalClientes() + "\r\n"
					+ "Total de Vendedores no arquivo: " + vendedorGerenciado.TotalVendedor() + "\r\n"
					+ "Id da Venda Mais Cara: " + vendasGerenciada.getIdVendaMaisCara() + "\r\n"
					+ "Pior Vendedor: " + vendasGerenciada.getPiorVendedor());
			
			arquivo.close();
			
		} catch (IOException e) { //caso nao consiga gerar cai na exceção
			e.printStackTrace();
		}
		
		
	}
}
