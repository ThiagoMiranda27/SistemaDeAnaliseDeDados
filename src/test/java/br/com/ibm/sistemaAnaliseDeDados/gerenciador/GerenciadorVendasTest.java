package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ibm.sistemaAnaliseDeDados.action.Reader;

public class GerenciadorVendasTest {

	private gerenciadorVendas gerenciadorVendas;
	private String teste = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çArtur";
	private String teste2 = "003ç08ç[1-1-10,2-0-1.50,3-0-0.10]çRicardo";
	private String teste3 = "002ç2345675433444345çMiguel LopesçUrbano";

	@Before
	public void setup() {
		gerenciadorVendas = new gerenciadorVendas();
	}

	@Test
	public void testaSeVendaFoiAdicionadoNaLista() {
		Reader.getFormatoArquivo().add(teste);
		Reader.getFormatoArquivo().add(teste2);
		gerenciadorVendas.getVendaList();
		assertEquals(2, gerenciadorVendas.TotalVendas());
	}

	@Test
	public void testaVendaList() {
		assertNotNull(gerenciadorVendas.getVendas());
	}

	@Test
	public void testaSeIraAdicionarASequencia() {
		Reader.getFormatoArquivo().add(teste3);
		gerenciadorVendas.getVendaList();
		assertEquals(2, gerenciadorVendas.TotalVendas());
	}

	@Test
	public void testaOPiorVendedor() {
		gerenciadorVendas.getVendaList();
		assertEquals("Ricardo", gerenciadorVendas.getPiorVendedor());
	}

	@Test 
	public void testaIdVendaMaisCara() {
		gerenciadorVendas.getVendaList();
		assertEquals("10", gerenciadorVendas.getIdVendaMaisCara());
	}

}
