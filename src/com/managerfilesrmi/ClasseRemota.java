package com.managerfilesrmi;

import java.io.File;
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
		if (directoryFiles.length > 0) {
			String[] arquivosEncontrados = new String[directoryFiles.length];
			int i = 0; 
			for (File f : directoryFiles) {
				System.out.println(f.getName());
				arquivosEncontrados[i] = f.getName();
				i++;
			}
			System.out.println("Arquivos dentro do diretório selecionado:");
			return arquivosEncontrados;
		} else {
			System.out.println("Nenhum arquivo encontrado");
			return null;
		}
	}

	@Override
	public int mkdir(String path) throws RemoteException {
		File arquivo = new File("arquivos\\" + path);
		if (!arquivo.exists()) {
			if (arquivo.mkdir()) {
				System.out.println("Directory is created!");
				return 0;
			} else {
				System.out.println("Failed to create directory!");
				return 1;
			}
		}
		return 1;
	}

	@Override
	public int create(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int unlink(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int write(byte[] data, String path) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] read(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
