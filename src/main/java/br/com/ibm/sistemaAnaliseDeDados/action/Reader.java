package br.com.ibm.sistemaAnaliseDeDados.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader { //classe para ler o arquivo .dat recebido

	static String fileName = "";

	private static List<String> formatoArquivo = new ArrayList<String>(); //cria array para armazenar os valores ja separados em cada Id

	public static void CarregaDados(String file) { //metedo para carregar arquivo em "HOMEPATH" e separar em cada Id
		BufferedReader br;
		try {
			String env = System.getenv("HOMEPATH"); //direciona para o caminho em "HOMEPATH"
			File f = new File(env + "//data//in//" + file); //Le o arquivo no diretorio /data/in + arquivo
			fileName = file.split(".dat")[0];
			br = new BufferedReader(new FileReader(f));
			formatoArquivo.clear();
			String linha = "";
			while ((linha = br.readLine()) != null) { //Separa os valores em cada Id "caso seja 001ç ira separar e armazenar em um array de String"
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
			br.close(); //fecha o bufferedReader
		} catch (IOException e) { //Caso nao encontre o arquivo entra na exceção
			System.out.println("Arquivo de Input nao encontrado.");
		}
	}

	public static List<String> getFormatoArquivo() { //Get do Array de FormatoArquivo
		return formatoArquivo;
	}

}
