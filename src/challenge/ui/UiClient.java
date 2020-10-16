package challenge.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

import challenge.fachada.Fachada;
import challenge.model.entities.Address;
import challenge.model.entities.Client;
import challenge.utils.Utils;
import exceptions.ClientException;

public class UiClient {

	private static Fachada fachada = Fachada.getInstance();
	static Scanner sc;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public void showMenu() {
		sc = new Scanner(System.in);
		int option;
		Client c = new Client();

		do {
			System.out.print("Inserir client - 1ª opção: " + "\nRemove client - 2ª opção: "
					+ "\nRemover client por name - 3ª opção: " + "\nPesquisar cliente pelo cpf - 4ª opção: ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				clientRegistration();
				break;
			case 2:
				System.out.println("CPF do cliente a ser removido");
				
				String cpf = sc.next();
				try {

					fachada.rmClient(cpf, c);

					System.out.println();
					System.out.print("Client removido com sucesso \n \n ");
				} catch (ClientException e) {
					System.out.println(e.getMessage() + "\n");
				}

				break;
			case 3:
				System.out.println("Nome do cliente a ser removido:");
				c.setName(sc.next());

				try {
					fachada.rmClientForName(c.getCpf(), c);
					System.out.println();

					System.out.print("clientes removidos com sucesso \n");
				} catch (ClientException e) {
					System.out.println(e.getMsg() + "\n");
				}

				break;

			case 4:
				System.out.print("Digite o CPF: \n");
				c.setCpf(sc.next());
			}
		} while (option != 0);

	}

	public void clientRegistration() {
		Client c = new Client();
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
			System.out.println("Olá " + c.getName() + " seu código é: " + c.getCodigo() + "\n");
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
		System.out.print("-------------CADASTRO DE ENDEREÇO------------ \n");
		System.out.print("rua:");
		String street = sc.next();
		System.out.print("bairro: ");
		String district = sc.next();
		System.out.print("número: ");
		int number = sc.nextInt();
		System.out.print("complemento: ");
		String complement = sc.next();
		System.out.print("cep: ");
		String cep = sc.next();
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
