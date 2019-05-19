package com.managerfilesrmi;

import java.rmi.Naming;
import java.util.Arrays;
import java.util.Scanner;

public class Cliente {
	public Cliente(String ipServer) {

		FSInterface fsinterface = null;

		try {
			fsinterface = (FSInterface) Naming.lookup("//"+ipServer+"/Servidor");
			try {
				while (true) {                
	                System.out.println("---------- MENU ----------");                
	                System.out.println("1 - Listar arquivos na pasta");
	                System.out.println("2 - Criar pasta;");              
	                System.out.println("3 - Cria um arquivo em branco;");
	                System.out.println("4 - Deleta um arquivo;");
	                System.out.println("5 - Escreve dados em um arquivo");
	                System.out.println("6 - Le um Arquivo;");
	                System.out.println("9 - FECHAR.");
	                System.out.println("--------------------------");  
	                System.out.println("Digita a opção desejada: ");
	                Scanner scanner = new Scanner(System.in);

	                switch (scanner.nextInt()) {
	                    case 1 :
	                        System.out.println("Digite o diretório que será lido\n"
	                        		+ "(. para o diretório raiz)");
	                        String lerDiretorio = scanner.next();
	                        System.out.println(Arrays.toString(fsinterface.ls(lerDiretorio)));
	                        break;
	                    case 2:
	                        System.out.println("Digite o caminho para criação de um novo diretório");
	                        String criacaoD = scanner.next();
	                        fsinterface.mkdir(criacaoD);
	                        break;
	                    case 3:
	                        System.out.println("Digite o caminho para criação de um novo arquivo");
	                        String criacaoA = scanner.next();
	                        fsinterface.create(criacaoA);
	                        break;
	                    case 4:
	                        System.out.println("Digite o caminho para deletar um arquivo");
	                        String deletar = scanner.next();
	                        fsinterface.unlink(deletar);
	                        break;
	                    case 5:
	                        System.out.println("Digite o caminho do arquivo que será editado");
	                        String editar = scanner.next();
	                        System.out.println("Digite o texto do arquivo");
	                        Scanner scanner2 = new Scanner(System.in);
	                        String information = scanner2.nextLine();
	                        fsinterface.write(information.getBytes(),editar);
	                        break;                                      
	                    case 6:
	                        System.out.println("Digite o caminho do arquivo que deve ser lido");
	                        String lerArquivo = scanner.next();
	                        System.out.println(fsinterface.read(lerArquivo));
	                        break;
	                    case 0:
	                        System.exit(0);
	                }
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println ("Falha na conexão");
			e.printStackTrace();
		}
	}
}