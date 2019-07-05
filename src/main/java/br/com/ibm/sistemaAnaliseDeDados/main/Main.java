package br.com.ibm.sistemaAnaliseDeDados.main;

import br.com.ibm.sistemaAnaliseDeDados.action.Watcher;

public class Main {

	public static void main(String[] args) {
		Watcher watcher = new Watcher();
		watcher.carregarDiretorio();
	}
	
}
