package com.managerfilesrmi;

public class Main {
	public static void main(String[] args) {
		if (args.length == 0 || args.length >= 2) {
			System.out.println("Digite um argumento válido!\n"
					+ "servidor - inicia uma instância de servidor;\n"
					+ "ip do servidor - para conectar em um determinado servidor.");
			
		} else if (args[0].equals("servidor")) {
			Servidor servidor = new Servidor();
		} else {
			Cliente cliente = new Cliente(args[0]);
		}
	}
}
