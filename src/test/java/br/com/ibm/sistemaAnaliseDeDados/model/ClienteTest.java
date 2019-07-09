package br.com.ibm.sistemaAnaliseDeDados.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ibm.sistemaAnaliseDeDados.model.Cliente;

public class ClienteTest {
	
	Cliente clienteTest;
	
	
	@Before
	public void setupTest() {
		clienteTest = new Cliente("Lucas", "1234556", "Gerencia");
	}

	@Test
	public void testaSeClienteGetNomeFunciona() { //Testa Nome Cliente
		String expected = "Lucas";
		assertEquals(expected, clienteTest.getName());
	}
	
	@Test
	public void testaSeClienteGetCnpjFunciona() { //Testa Cnpj Cliente
		String expected = "1234556";
		assertEquals(expected, clienteTest.getCnpj());
	}
	
	@Test
	public void testaSeClienteGetBusinessAreaFunciona() { //Testa Busines Area Cliente
		String expected = "Gerencia";
		assertEquals(expected, clienteTest.getBusinessArea());
	}


}
