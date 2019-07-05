package br.com.ibm.sistemaAnaliseDeDados.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	private static List<String> formatoArquivo = new ArrayList<String>();

	public static void CarregarDados(String file) {

		BufferedReader buffer;

		try {
			String env = System.getenv("HOMEPATH");
			File f = new File(env + "//data//in//" + file);
			buffer = new BufferedReader(new FileReader(f));
			String linha = "";
			while ((linha = buffer.readLine()) != null) {
				if (linha.contains("001ç")) {
					String[] aux = linha.split("001ç");
					for (int i = 1; i < aux.length; i++) {
						formatoArquivo.add("001ç" + aux[i]);
					}
				} else if (linha.contains("002ç")) {
					String[] aux = linha.split("002ç");
					for (int i = 1; i < aux.length; i++) {
						formatoArquivo.add("002ç" + aux[i]);
					}
				} else if (linha.contains("003ç")) {
					String[] aux = linha.split("003ç");
					for (int i = 1; i < aux.length; i++) {
						formatoArquivo.add("003ç" + aux[i]);
					}
				}
				
			}

			buffer.close();

		} catch (IOException e) {
			System.out.println("Arquivo de input nao encontrado");
		}

	}

	public static List<String> getFormatoArquivo() {
		return formatoArquivo;
	}

}
