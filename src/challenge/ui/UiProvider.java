package challenge.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import challenge.fachada.Fachada;
import challenge.model.entities.Address;
import challenge.model.entities.Provider;
import exceptions.ProviderException;

public class UiProvider {

	private static Fachada fachada = Fachada.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static Scanner sc;

	public void showMenu() {
		sc = new Scanner(System.in);
		int option;

		do {
			System.out.print("1ª opção: Inserir fornecedor; " + "\n2ª opção: Remover fornecedor pelo cnpj; "
					+ "\n3ª opção: pesquisar fornecedor por tipo de serviço prestado; "
					+ "\n4ª opção: Pesquisar fornecedor por CEP; ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				insertProvider();
				break;
			case 2:
				deleteProvider();
				break;
			case 3:
				searcheProviderByCnpj();
				break;
			case 4:
				searcheProviderByCep();
				break;
			}
		} while (option != 0);

	}

	private void searcheProviderByCep() {
		// TODO Auto-generated method stub

	}

	private void searcheProviderByCnpj() {
		// TODO Auto-generated method stub

	}

	private void deleteProvider() {
		System.out.println("Digite o CNPJ:");
		String cnpj = sc.next();

		try {
			fachada.deleteProvider(cnpj);
			System.out.println("Fornecedor removido com sucesso");
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
		System.out.println("Digite a data de fundação: ");
		try {
			provider.setDt_fundacao(sdf.parse(sc.next()));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		System.out.println("Digite o tipo de serviço: ");
		sc.nextLine();
		provider.setTypeOfService(sc.nextLine());

		Address address = new Address();
		System.out.print("-------------CADASTRO DE ENDEREÇO------------ \n");

		System.out.print("rua:");
		address.setStreet(sc.nextLine());

		System.out.print("bairro: ");
		address.setDistrict(sc.nextLine());

		System.out.print("número: ");
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
