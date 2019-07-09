package br.com.ibm.sistemaAnaliseDeDados.action;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Optional;

import br.com.ibm.sistemaAnaliseDeDados.action.Writer;

public class Watcher {
	

	public void carregarDiretorio() { //metodo para carregar o diretorio HOMEPATH/data/in
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			String pathToDir = System.getenv("HOMEPATH") + "\\data\\in";
			Path diretorio = Paths.get((pathToDir));
			diretorio.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
			while (true) {
				WatchKey key = watcher.take();
				Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream().findFirst();
				Path path = (Path) watchEvent.get().context();
				if (path.toString().endsWith(".dat")) {
					Reader.CarregaDados(path.toString()); //carregaDados de Reader
					System.out.println("Arquivo Formatado!");
					Writer writer = new Writer();
					writer.arquivoDeRelalatorio(Reader.fileName); //gera arquivo relatorio com o nome do arquivo lido
					System.out.println("Gerado Relatorio!");

				}

				boolean valid = key.reset(); //reseta a chave

				if (!valid) { //caso nao seja valid, ele fecha
					break;
				}
			}

			watcher.close(); //fecha watcher

		} catch (IOException | InterruptedException e) { //caso nao consiga carregar cai na exceção
			e.printStackTrace();
		}
	}
			
}
