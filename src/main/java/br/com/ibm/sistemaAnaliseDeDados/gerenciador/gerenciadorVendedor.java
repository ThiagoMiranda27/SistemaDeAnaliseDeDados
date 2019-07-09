package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import java.util.ArrayList;

import br.com.ibm.sistemaAnaliseDeDados.action.Reader;
import br.com.ibm.sistemaAnaliseDeDados.model.Vendedor;

import java.util.List;

public class gerenciadorVendedor {

	private List<Vendedor> vendedores = new ArrayList<Vendedor>(); //cria lista vendedor

	public void getVendedorList() {
		for (String vendedor : Reader.getFormatoArquivo()) { //metodo para separar em cada "ç" e armazenar em um array de string 
			if (vendedor.startsWith("001ç")) {
				String[] aux = vendedor.split("ç");
				vendedores.add(new Vendedor(aux[1], aux[2], Double.parseDouble(aux[3])));
			}

		}
	}

	public int TotalVendedor() { //Get do Array de vendedor
		return vendedores.size();
	}

	public List<Vendedor> getVendedores() { //metodo para chamar o array de vendedores
		vendedores.clear(); //limpa o array caso tenha mais do que um arquivo para gerar o relatorio
		return vendedores;
	}
}

