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

public class Watcher {
	

	public void carregarDiretorio() {
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
					Reader.CarregarDados(path.toString());
					Writer writer = new Writer();
					writer.arquivoDeRelalatorio();
					writer.printRelatorio();
				}

				boolean valid = key.reset();

				if (!valid) {
					break;
				}
			}

			watcher.close();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		Writer w = new Writer();
		w.printRelatorio();
	}
			
}
