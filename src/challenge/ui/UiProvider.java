package challenge.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import challenge.fachada.Fachada;
import challenge.model.entities.Address;
import challenge.model.entities.Client;
import challenge.model.entities.Provider;
import challenge.repository.ClientRepository;
import challenge.repository.ProviderRepository;
import exceptions.ClientException;
import exceptions.ProviderException;

public class UiProvider {

	private static Fachada fachada = Fachada.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static Scanner sc;

	public void showMenu() {
		sc = new Scanner(System.in);
		int option;

		do {
			System.out.print("1� op��o: Inserir fornecedor; " + "\n2� op��o: Remover fornecedor pelo cnpj; "
					+ "\n3� op��o: pesquisar fornecedor por tipo de servi�o prestado; "
					+ "\n4� op��o: Pesquisar fornecedor por CEP; ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				insertProvider();
				break;
			case 2:
				deleteProvider();
				break;
			case 3:
				searcheProviderByTypeOfService();
				break;
			case 4:
				searcheProviderByCep();
				break;
			}
		} while (option != 0);

	}

	private void searcheProviderByCep() {
		System.out.print("Digite o CEP do fornecedor: ");
		String cep = sc.next();

		try {
			fachada.searcheProviderByCep(cep);
			Provider[] p = fachada.searcheProviderByCep(cep);
			if (p != null) {
				for (int i = 0; i < p.length; i++) {
					System.out.println(p[i] + "\n");
				}
			} else {
				System.out.println("Fornecedor n�o encontrado");
			}

		} catch (ProviderException e) {
			System.out.println(e.getMsg() + "\n");
		}

	}

	private void searcheProviderByTypeOfService() {
		System.out.println("Digite o tipo do servi�o do fornecedor: ");
		String tipo = sc.next();

		try {
			Provider p = fachada.searcheProviderByTypeOfService(tipo);
			if (p != null) {
				System.out.print(p.toString() + "\n");
			} else {
				System.out.println("Client n�o encontrado");
			}
		} catch (ProviderException e) {

			System.out.println(e.getMessage() + "\n");
		}

	}

	private void deleteProvider() {
		System.out.println("Digite o CNPJ:");
		String cnpj = sc.next();

		try {
			fachada.deleteProvider(cnpj);

			System.out.println("Fornecedor removido com sucesso \n");

		} catch (ProviderException e) {

			System.out.println(e.getMessage() + "\n");
		}

	}

	private void insertProvider() {

		Provider provider = new Provider();

		System.out.print("Digite seu nome: ");
		sc.nextLine();
		provider.setName(sc.nextLine());
		System.out.print("Digite seu nome fantasia: ");
		provider.setGhostName(sc.nextLine());
		System.out.println("Digite o CNPJ:");
		provider.setCnpj(sc.next());
		System.out.print("Digite o seu e-mail: ");
		provider.setEmail(sc.next());
		System.out.println("Digite a data de funda��o: ");
		try {
			provider.setDt_fundacao(sdf.parse(sc.next()));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		System.out.println("Digite o tipo de servi�o: ");
		sc.nextLine();
		provider.setTypeOfService(sc.nextLine());

		Address address = new Address();
		System.out.print("-------------CADASTRO DE ENDERE�O------------ \n");

		System.out.print("rua:");
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

		provider.setAddress(address);

		try {
			fachada.insertProvider(provider);
			System.out.println("Fornecedor cadastrado com sucesso!");
		} catch (ProviderException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "\n");
		}

	}

}
