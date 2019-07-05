package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import br.com.ibm.sistemaAnaliseDeDados.model.Venda;
import br.com.ibm.sistemaAnaliseDeDados.action.Reader;


public class gerenciadorVendas {
	private List<Venda> vendas = new ArrayList<Venda>();

	public void getVendaList() {
		for (String venda : Reader.getFormatoArquivo()) {
			if (venda.startsWith("003ç")) {
				String aux[] = venda.split("ç");
				vendas.add(new Venda(aux[1], getVendaPreco(aux[2]), aux[3]));
			}
		}
	}

	public int TotalVendas() {
		return vendas.size();
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public double getVendaPreco(String venda) {
		double preco = 0;
		String splitvirgula[] = venda.split(",");
		for (int i = 0; i < splitvirgula.length; i++) {
			String splitlinha[] = splitvirgula[i].split("-");
			preco = preco + Double.parseDouble(splitlinha[1].replace("[", ""))
					* Double.parseDouble(splitlinha[2].replace("]", ""));
		}
		
		return preco;
	}

	public String getIdVendaMaisCara() {
		vendas.sort(Comparator.comparing(Venda::getVendaPreco).reversed());
		return vendas.get(0).getIdVenda();
	}

	public String getPiorVendedor() {
		vendas.sort(Comparator.comparing(Venda::getVendaPreco));
		return vendas.get(0).getVendedor();
	}

}
