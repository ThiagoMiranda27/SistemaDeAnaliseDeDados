package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import java.util.ArrayList;
import java.util.List;
import br.com.ibm.sistemaAnaliseDeDados.model.Cliente;
import br.com.ibm.sistemaAnaliseDeDados.action.Reader;

public class gerenciadorCliente {

		private List<Cliente> clientes = new ArrayList<Cliente>();

		public void getClienteList() {
			for (String cliente : Reader.getFormatoArquivo()) {
				if (cliente.startsWith("002ç")) {
					String aux[] = cliente.split("ç");
					clientes.add(new Cliente (aux[1], aux[2], aux[3]));
				}
			}
		}

		public int totalClientes() {
			return clientes.size();
		}

		public List<Cliente> getClientes() {
			return clientes;
		}
}
