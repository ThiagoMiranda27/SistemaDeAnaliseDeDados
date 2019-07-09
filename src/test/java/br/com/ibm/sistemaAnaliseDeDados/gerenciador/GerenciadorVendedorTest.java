package br.com.ibm.sistemaAnaliseDeDados.gerenciador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ibm.sistemaAnaliseDeDados.action.Reader;

public class GerenciadorVendedorTest {

	private gerenciadorVendedor gerenciadorVendedor;
	private String teste = "001ç1234567891234çMarcosç50300";
	private String teste2 = "001ç3245678865434çAugustoç12400.99";
	private String teste3 = "002ç2345675433444345çVictor Miranda�Urbano";

	@Before
	public void setup() {
		gerenciadorVendedor = new gerenciadorVendedor();
	}

	@Test
	public void testaSeVendedorFoiAdicionadoNaLista() {  // testa se o vendedor esta sendo adicionado no array
		Reader.getFormatoArquivo().add(teste);
		Reader.getFormatoArquivo().add(teste2);
		gerenciadorVendedor.getVendedorList();
		System.out.println(gerenciadorVendedor.TotalVendedor());
		assertEquals(2, gerenciadorVendedor.TotalVendedor());
	}

	@Test
	public void testaVendedorList() { //Testa o Array list de vendedor
		assertNotNull(gerenciadorVendedor.getVendedores());
	}

	@Test
	public void testaTotalVendedor() { //Testa total vendedor
		Reader.getFormatoArquivo().add(teste3);
		gerenciadorVendedor.getVendedorList();
		assertEquals(2, gerenciadorVendedor.TotalVendedor());
	}

}
