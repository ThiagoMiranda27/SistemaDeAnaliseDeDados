package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import java.util.ArrayList;
import java.util.List;
import br.com.ibm.sistemaAnaliseDeDados.model.Vendedor;
import br.com.ibm.sistemaAnaliseDeDados.action.Reader;

public class gerenciadorVendedor {

	private List<Vendedor> vendedores = new ArrayList<Vendedor>();

	public void getVendedorList() {
		for (String vendedor : Reader.getFormatoArquivo()) {
			if (vendedor.startsWith("001ç")) {
				String aux[] = vendedor.split("ç");
				vendedores.add(new Vendedor(aux[1], aux[2], Double.parseDouble(aux[3])));
			}

		}
	}

	public int TotalVendedor() {
		return vendedores.size();
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}
}

