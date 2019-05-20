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
	                        for (String s : fsinterface.ls(lerDiretorio)) {
	                        	System.out.println(s);
	                        };
	                        break;
	                    case 2:
	                        System.out.println("Digite o caminho para criação de um novo diretório");
	                        String criacaoD = scanner.next();
	                        int folder = fsinterface.mkdir(criacaoD);
	                        if (folder == 0) {
	                        	System.out.println(" ----- PASTA CRIADA COM SUCESSO! -----");
	                        } else {
	                        	System.out.println("----- OCORREU UMA FALHA PARA CRIAR A PASTA! -----");
	                        }
	                        break;
	                    case 3:
	                        System.out.println("Digite o caminho e o nome do arquivo para ser criado (separado por \\\\)");
	                        String criacaoA = scanner.next();
	                        int newfile = fsinterface.create(criacaoA);
	                        if ( newfile == 0) {
	                        	System.out.println(" ----- ARQUIVO CRIADO COM SUCESSO! -----");
	                        } else {
	                        	System.out.println(" ----- OCORREU UMA FAHA PARA CRIAR O ARQUIVO! -----");
	                        }
	                    
	                        break;
	                    case 4:
	                        System.out.println("Digite o caminho e o nome para deletar um arquivo (separado por \\\\)");
	                        String deletar = scanner.next();
	                        int fileDel = fsinterface.unlink(deletar); 
	                        if (fileDel == 0) {
	                        	System.out.println(" ----- ARQUIVO DELETADO COM SUCESSO! -----");
	                        } else {
	                        	System.out.println(" ----- OCORREU UMA FAHA PARA DELETAR O ARQUIVO! -----");
	                        }
	                        break;
	                    case 5:
	                        System.out.println("Digite o caminho e o nome do arquivo que será editado (separado por \\\\)");
	                        String editar = scanner.next();
	                        System.out.println("Digite o texto do arquivo");
	                        Scanner scanner2 = new Scanner(System.in);
	                        String information = scanner2.nextLine();
	                        int fileEdit = fsinterface.write(information.getBytes(),editar);
	                        if ( fileEdit == 0) {
	                        	System.out.println(" ----- ARQUIVO EDITADO COM SUCESSO! -----");
	                        } else {
	                        	System.out.println(" ----- OCORREU UMA FAHA PARA EDITAR O ARQUIVO! -----");
	                        }
	                        break;                                      
	                    case 6:
	                        System.out.println("Digite o caminho e o nome do arquivo que deve ser lido (separados por \\\\)");
	                        String lerArquivo = scanner.next();
	                        String textoLido = new String(fsinterface.read(lerArquivo));
	                        System.out.println(" ----- TEXTO DO ARQUIVO ----- ");
	                        System.out.println(textoLido);
	                        System.out.println(" ----- FIM DO TEXTO DO ARQUIVO ----- ");
	                        break;
	                    case 9:
	                    	System.out.println("Encerrando o sistema...");
	                        System.exit(0);
	                        break;
	                    default:
	                    	System.out.println("Digite uma opção válida!");
	                }
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println ("Falha na conexão! Verifique se o endereço digitado esta correto!");
		}
	}
}