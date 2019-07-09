package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import br.com.ibm.sistemaAnaliseDeDados.action.Reader;

public class GerenciadorClienteTest {

	private gerenciadorCliente gerenciadorCliente;
	private String teste = "002ç2665675886544345çAlberto AzevedoçUrbano";
	private String teste2 = "002ç4785675221544366çMariaçRural";
	private String teste3 = "001ç36876788654347çHenriqueç30000.99";

	@Before
	public void setup() {
		gerenciadorCliente = new gerenciadorCliente();
	}

	@Test
	public void testaSeClienteFoiAdicionadoNaLista() {
		Reader.getFormatoArquivo().add(teste);
		Reader.getFormatoArquivo().add(teste2);
		gerenciadorCliente.getClienteList();
		assertEquals(2, gerenciadorCliente.totalClientes());
	}

	@Test
	public void testaClienteList() {
		assertNotNull(gerenciadorCliente.getClientes());
	}

	@Test
	public void testaSeIraAdicionarASequencia() {
		Reader.getFormatoArquivo().add(teste3);
		gerenciadorCliente.getClienteList();
		assertEquals(2, gerenciadorCliente.totalClientes());
	}
}