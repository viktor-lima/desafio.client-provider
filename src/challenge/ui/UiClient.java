package challenge.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

import challenge.fachada.Fachada;
import challenge.model.entities.Address;
import challenge.model.entities.Client;
import challenge.repository.ClientRepository;
import challenge.utils.Utils;
import exceptions.ClientException;

public class UiClient {

	private static Fachada fachada = Fachada.getInstance();
	static Scanner sc;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	Client c;

	public void showMenu() {
		sc = new Scanner(System.in);
		int option;

		do {
			System.out.print("Inserir client - 1� op��o: " + "\nRemove client - 2� op��o: "
					+ "\nRemover client por name - 3� op��o: " + "\nPesquisar cliente pelo cpf - 4� op��o: ");
			option = sc.nextInt();

			String cpf;
			switch (option) {
			case 1:
				clientRegistration();
				break;
			case 2:
				System.out.println("CPF do cliente a ser removido");
				sc.nextLine();
				cpf = sc.nextLine();
				
				try {

					fachada.rmClient(cpf);

					System.out.println();
					System.out.print("Client removido com sucesso \n \n ");
				} catch (ClientException e) {
					System.out.println(e.getMessage() + "\n");
				}

				break;
			case 3:
				System.out.println("Nome do cliente a ser removido:");
				sc.nextLine();
				String Name = sc.nextLine();
				//c.setName(sc.nextLine());

				try {
					fachada.rmClientForName(Name);

					System.out.print("clientes removidos com sucesso \n");
				} catch (ClientException e) {
					System.out.println(e.getMsg() + "\n");
				}

				break;

			case 4:
				System.out.print("Digite o CPF: \n");
				sc.nextLine();
				String cpf1 = sc.nextLine();
				
				try {
					fachada.searcheClientForCpf(cpf1);
					ClientRepository cr = ClientRepository.getInstance();
					cr.searcheClientForCpf(cpf1);
					System.out.println(c.getName());
					
				} catch (ClientException e) {
					System.out.println(e.getMsg() + "\n");
				}
			}
		} while (option != 0);

	}

	public void clientRegistration() {
		c = new Client();
		System.out.print("\ndigite o seu nome: \n");
		sc.nextLine();
		c.setName(sc.nextLine());
		
		int[] num = new int[1];
		Random r = new Random();

		for (int i = 0; i < num.length; i++) {
			int number = r.nextInt(1000) + 1;
			for (int j = 0; j < num.length; j++) {
				if (number == num[j] && j != i) {
					number = r.nextInt(1000) + 1;
				} else {
					num[i] = number;
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			c.setCodigo(num[i]);
			System.out.println("Ol� " + c.getName() + " seu c�digo �: " + c.getCodigo() + "\n");
		}
		System.out.print("Digite o seu email: ");
		c.setEmail(sc.next());
		System.out.print("Digite seu CPF: ");
		c.setCpf(sc.next());
		System.out.print("digite a data de nascimento: \n");
		try {
			c.setDt_nascimento(sdf.parse(sc.next()));

			Utils utils = new Utils();
			c.setAge(utils.calculaIdade(c.getDt_nascimento()));
			System.out.println(c.getAge());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// pegar valores do endereco e criar o objeto endereco
		System.out.print("-------------CADASTRO DE ENDERE�O------------ \n");
		System.out.print("rua:");
		sc.nextLine();
		String street = sc.nextLine();
		System.out.print("bairro: ");
		sc.next();
		String district = sc.nextLine();
		System.out.print("n�mero: ");
		int number = sc.nextInt();
		System.out.print("complemento: ");
		sc.next();
		String complement = sc.nextLine();
		System.out.print("cep: ");
		sc.next();
		String cep = sc.nextLine();
		System.out.println("------------------------------------------- \n");

		Address address = new Address(street, district, number, complement, cep);

		c.setEndereco(address);

		try {
			fachada.addClient(c);

			System.out.println();
			System.out.print("Client Cadastrado com sucesso \n \n ");
		} catch (ClientException e) {
			System.out.println(e.getMessage() + "\n");
		}

	}

}
