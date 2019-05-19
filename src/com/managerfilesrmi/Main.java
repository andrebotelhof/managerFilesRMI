package com.managerfilesrmi;

public class Main {
	public static void main(String[] args) {
		if (args[1].equals("servidor")) {
			Servidor servidor = new Servidor();
		} else {
			Cliente cliente = new Cliente(args[2]);
		}
	}
}
