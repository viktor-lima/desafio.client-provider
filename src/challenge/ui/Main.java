package challenge.ui;

import java.util.Scanner;



public class Main {
	
	private static Scanner sc;
	public static void main(String[] args) {
		
		
		
		
	
		sc = new Scanner (System.in);
		
		int opcao;
		
		
		System.out.println("Escolha uma opção: \n1 - Área do Cliente \n2 - Área Fornecedor");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			UiClient UiCliente = new UiClient();
			UiCliente.showMenu();
			break;
			
		case 2:
			UiProvider UiProvider = new UiProvider();
			UiProvider.showMenu();
				
			break;
		
		default:
			System.out.println("Opção Inválida");
			break;
		}

	}
}
