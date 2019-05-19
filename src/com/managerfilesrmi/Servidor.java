package com.managerfilesrmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {
	public Servidor() {
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("Iniciando o servidor");
		} catch (RemoteException e) {
			System.out.println("Servidor já existe");
		}

		try {
			Naming.rebind("Servidor", new ClasseRemota());
			System.out.println("Servidor on");
		} catch (Exception e) {
			System.out.println("Deu pau no server");
			e.printStackTrace();
		}
	}
}