package challenge.ui;

import java.util.Scanner;



public class Main {
	
	private static Scanner sc;
	public static void main(String[] args) {
		
		
		
		
	
		sc = new Scanner (System.in);
		
		int opcao;
		
		System.out.println("Escolha uma op��o: \n1 - Area do Cliente \n2 - Area da Administra��o");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			UiClient UiCliente = new UiClient();
			UiCliente.showMenu();
			break;
			
		case 2:
				
			break;
		
		default:
			System.out.println("Op��o Inv�lida");
			break;
		}

	}
}
