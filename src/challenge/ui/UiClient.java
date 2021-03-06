package challenge.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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

	public void showMenu() {
		sc = new Scanner(System.in);
		int option;

		do {
			System.out.print("1� op��o: Inserir client; " + "\n2� op��o: Remover cliente; "
					+ "\n3� op��o: Remover cliente por nome; " + "\n4� op��o: Pesquisar cliente pelo cpf; "
					+ "\n5� op��o: Pesquisar client por bairro;"
					+ "\n6� op��o: back to menu; \n");
			option = sc.nextInt();

			switch (option) {
			case 1:
				clientRegistration();
				break;
			case 2:
				removeClient();
				break;
			case 3:
				removeClientByName();
				break;
			case 4:
				searcheClientByCpf();
				break;
			case 5:
				searcheClientByDistrict();
				break;
			case 6:
				Main main = new Main();
				main.main(null);
				break;

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
		Address address = new Address();
		System.out.print("-------------CADASTRO DE ENDERE�O------------ \n");
		System.out.print("rua:");
		sc.nextLine();

		address.setStreet(sc.nextLine());
		System.out.print("bairro: ");

		address.setDistrict(sc.nextLine());

		System.out.print("n�mero: ");

		address.setNumber(sc.nextInt());
		System.out.print("complemento: ");
		sc.nextLine();
		address.setComplement(sc.nextLine());
		System.out.print("cep: ");

		address.setCep(sc.nextLine());
		System.out.println("------------------------------------------- \n");
		//set address da classe Address no endereco da classe Client
		c.setEndereco(address);

		try {
			fachada.addClient(c);

			System.out.println();
			System.out.print("Client Cadastrado com sucesso \n \n ");
		} catch (ClientException e) {
			System.out.println(e.getMessage() + "\n");
		}

	}

	public void removeClient() {
		System.out.print("CPF do cliente a ser removido: ");
		sc.nextLine();
		String cpf = sc.nextLine();

		try {

			fachada.rmClient(cpf);

			System.out.println();
			System.out.print("Client removido com sucesso \n \n ");
		} catch (ClientException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	public void removeClientByName() {
		System.out.println("Nome do cliente a ser removido:");
		sc.nextLine();
		String Name = sc.nextLine();

		try {
			fachada.rmClientByName(Name);

			System.out.print("clientes removidos com sucesso \n");
		} catch (ClientException e) {
			System.out.println(e.getMsg() + "\n");
		}
	}

	public void searcheClientByCpf() {
		System.out.print("Digite o CPF: \n");
		sc.nextLine();
		String cpf1 = sc.nextLine();

		try {
			fachada.searcheClientByCpf(cpf1);
			ClientRepository cr = ClientRepository.getInstance();
			cr.searcheClientByCpf(cpf1);
			Client c = fachada.searcheClientByCpf(cpf1);
			if (c != null) {
				System.out.print(c.toString());
			} else {
				System.out.println("Client n�o encontrado");
			}

			System.out.println();

		} catch (ClientException e) {
			System.out.println(e.getMsg() + "\n");
		}
	}

	public void searcheClientByDistrict() {
		System.out.print("Digite o bairro: \n");
		sc.nextLine();
		String district = sc.nextLine();

		try {
			fachada.searcheClientByDistrict(district);
			
			Client[] c = fachada.searcheClientByDistrict(district);
			if (c != null) {
				for (int i = 0; i < c.length; i++) {
					System.out.println(c[i] + "\n");
				}
			} else {
				System.out.println("Client n�o encontrado");
			}

		} catch (ClientException e) {
			System.out.println(e.getMsg() + "\n");
		}
	}
}
