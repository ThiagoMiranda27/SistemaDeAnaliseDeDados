package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import br.com.ibm.sistemaAnaliseDeDados.action.Reader;
import br.com.ibm.sistemaAnaliseDeDados.model.Cliente;

import java.util.ArrayList;
import java.util.List;


public class gerenciadorCliente {

		private List<Cliente> clientes = new ArrayList<Cliente>(); //cria lista clientes

		public void getClienteList() { //metodo para separar em cada "ç" e armazenar em um array de string 
			for (String cliente : Reader.getFormatoArquivo()) {
				if (cliente.startsWith("002ç")) {
					String[] aux = cliente.split("ç"); 
					clientes.add(new Cliente (aux[1], aux[2], aux[3]));
				}
			}
		}

		public int totalClientes() { //metodo para pegar o total de clientes
			return clientes.size();
		}

		public List<Cliente> getClientes() { //Get do Array de clientes
			clientes.clear(); //limpa o array caso tenha mais do que um arquivo para gerar o relatorio
			return clientes;
		}
}
