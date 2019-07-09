package br.com.ibm.sistemaAnaliseDeDados.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class VendaTest {

	Venda vendaTest;

	@Before
	public void setupTest() {
		vendaTest = new Venda("1", 120.00, "Roberto");
	}
	
	
	@Test
	public void testaSeVendaGetIdFunciona() { //Testa Id Venda
		String expected = "1";
		assertEquals(expected, vendaTest.getIdVenda());
	}

	@Test
	public void testaSeVendaGetPrecoFunciona() { //Testa Preco Venda
		Double expected = 120.00;
		assertEquals(expected, vendaTest.getVendaPreco(), 0.1);
	}
	
	@Test
	public void testaSeVendaGetVendedorfunciona() { //Testa Vendedor Venda
		String expected = "Roberto";
		assertEquals(expected, vendaTest.getVendedor());
	}
}
