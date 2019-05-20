package com.managerfilesrmi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClasseRemota extends UnicastRemoteObject implements FSInterface {

	private static final long serialVersionUID = -4164277960532266268L;
	
	public ClasseRemota() throws RemoteException {
		File arquivo = new File("arquivos");
		if (!arquivo.exists()) {
			arquivo.mkdir();
		}
	}

	@Override
	public String[] ls(String path) throws RemoteException {
		File arquivo = null;
		if (path.equals(".")) {
			arquivo = new File("arquivos");
		} else {
			arquivo = new File("arquivos\\" + path);
		}
		File[] directoryFiles = arquivo.listFiles();
		if (directoryFiles == null) {
			return new String[] { "Essa pasta não existe!" };
		}
		if (directoryFiles.length > 0) {
			String[] arquivosEncontrados = new String[directoryFiles.length + 2];
			int i = 1;
			arquivosEncontrados[0] = "----- LISTA DE ARQUIVOS: -----";
			for (File f : directoryFiles) {
				if (f.isDirectory() == true) {
					arquivosEncontrados[i] = "PASTA: ";
				} else {
					arquivosEncontrados[i] = "ARQUIVO: ";
				}
				arquivosEncontrados[i] += f.getName();
				i++;
			}
			arquivosEncontrados[i] = "----- FIM DA LISTA DE ARQUIVOS NO DIRETÓRIO -----";
			return arquivosEncontrados;
		} else {
			return new String[] { "A pasta esta vazia!" };
		}
	}

	@Override
	public int mkdir(String path) throws RemoteException {
		File arquivo = new File("arquivos\\" + path);
		if (!arquivo.exists()) {
			if (arquivo.mkdir()) {
				return 0;
			} else {
				return 1;
			}
		}
		return 1;
	}

	@Override
	public int create(String path) throws RemoteException {
		File file = new File("arquivos\\" + path);
		if (!file.exists()) {
			try {
				file.createNewFile();
				return 0;
			} catch (IOException e) {
				return 1;
			}
		}
		return 1;
	}

	@Override
	public int unlink(String path) throws RemoteException {
		File file = new File("arquivos\\" + path);
		if (file.exists()) {
			file.delete();
			return 0;
		}  else {
			return 1;
		}
	}

	@Override
	public int write(byte[] data, String path) throws RemoteException {
		if (data != null && path != null) {
			try {
				Files.write(Paths.get("arquivos\\" + path), data);
				return 0;
			} catch (IOException e) {
				return 1;
			}
			
		}
		return 1;
	}

	@Override
	public byte[] read(String path) throws RemoteException {
		String content;
		try {
			return Files.readAllBytes(Paths.get("arquivos\\" + path));
		} catch (IOException e) {
			content = " ----- O ARQUIVO NÃO FOI ENCONTRADO ----- ";
			return content.getBytes();
		}
	}
	
}
