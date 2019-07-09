package br.com.ibm.sistemaAnaliseDeDados.main;

import br.com.ibm.sistemaAnaliseDeDados.action.Watcher;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Rodando . . .");
    	
    	Watcher watcher = new Watcher(); //chamando classe watcher
		watcher.carregarDiretorio(); //chama classe carregarDiretorio
    }
}
