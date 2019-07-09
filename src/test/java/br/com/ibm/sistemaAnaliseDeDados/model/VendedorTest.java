package br.com.ibm.sistemaAnaliseDeDados.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VendedorTest {
	
	Vendedor vendedorTest;
	
	
	@Before
	public void setupTest() { 
		vendedorTest = new Vendedor("12345678901", "Lucas", 100.00);
	}

	@Test
	public void testaSeVendedorGetNomeFunciona() { //Testa Nome Vendedor
		String expected = "Lucas";
		assertEquals(expected, vendedorTest.getName());
	}
	
	@Test
	public void testaSeVendedorGetCpfFunciona() { //Testa Cpf Vendedor
		String expected = "12345678901";
		assertEquals(expected, vendedorTest.getCpf());
	}
	
	@Test
	public void testaSeVendedorGetSalario() { //Testa Salario Vendedor
		Double expected = 100.00;
		assertEquals(expected, vendedorTest.getSalary(), 0.1);
	}



}
