package com.managerfilesrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClasseRemota extends UnicastRemoteObject implements FSInterface {

	private static final long serialVersionUID = -4164277960532266268L;
	
	public ClasseRemota() throws RemoteException {
		
	}

	@Override
	public String[] ls(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int mkdir(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
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
