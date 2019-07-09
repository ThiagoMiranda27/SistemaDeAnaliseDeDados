package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.ibm.sistemaAnaliseDeDados.action.Reader;
import br.com.ibm.sistemaAnaliseDeDados.model.Venda;


public class gerenciadorVendas {
	private List<Venda> vendas = new ArrayList<Venda>(); //cria lista venda
	
	public void getVendaList() {
		for (String venda : Reader.getFormatoArquivo()) { //metodo para separar em cada "ç" e armazenar em um array de string
			if (venda.startsWith("003ç")) {
				String[] aux = venda.split("ç");
				vendas.add(new Venda(aux[1], getVendaPreco(aux[2]), aux[3]));
			}
		}
	}

	public int TotalVendas() { //metodo para pegar o total de vendedor
		return vendas.size();
	}

	public List<Venda> getVendas() { //Get do Array de venda
		vendas.clear(); //limpa o array caso tenha mais do que um arquivo para gerar o relatorio
		return vendas;
	}

	public double getVendaPreco(String venda) { //metodo para separar e calcular o valor de preço
		double preco = 0;
		String splitV[] = venda.split(",");
		for (int i = 0; i < splitV.length; i++) {
			String splitL[] = splitV[i].split("-");
			preco = preco + Double.parseDouble(splitL[1].replace("[", "")) //retira os colchetes e calcula o valor do preco
					* Double.parseDouble(splitL[2].replace("]", "")); 
		}
		
		return preco;
	}

	public String getIdVendaMaisCara() { //metodo para pegar o Id com a venda mais cara comparando a classe venda com o metodo do getVendaPreco
		vendas.sort(Comparator.comparing(Venda::getVendaPreco).reversed());
		return vendas.get(0).getIdVenda();
	}

	public String getPiorVendedor() { //metodo para pegar o pior vendedor comparando a classe venda com o metodo do getVendaPreco
		vendas.sort(Comparator.comparing(Venda::getVendaPreco));
		return vendas.get(0).getVendedor();
	}

}
