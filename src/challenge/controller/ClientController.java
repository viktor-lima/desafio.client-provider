package challenge.controller;

import challenge.model.entities.Client;
import challenge.repository.ClientRepository;
import challenge.repository.IclientRepository;
import exceptions.ClientException;

public class ClientController implements IclientController {

	private IclientRepository clientRepository;

	private static ClientController instance;

	public static ClientController getInstance() {
		if (instance == null)
			return new ClientController();
		else
			return instance;
	}

	public ClientController() {
		clientRepository = ClientRepository.getInstance();

	}

	@Override
	public void addClient(Client c) throws ClientException {
		// TODO Auto-generated method stub
		if (clientRepository.existClient(c.getCpf())) {
			throw new ClientException("Erro: cliente já existe!");
		} else {
			clientRepository.addClient(c);
		}

	}

	@Override
	public void rmClient(String cpf, Client c) throws ClientException {
		// TODO Auto-generated method stub
		if (clientRepository.existClient(cpf) && c.getCpf().equals(cpf)) {
			clientRepository.rmClient(cpf, c);
		} else {
			throw new ClientException("Erro: cliente não existe!");
		}

	}

	@Override
	public void rmClientForName(String name, Client c) throws ClientException {
		// TODO Auto-generated method stub
		if (c.getName().equals(name)) {
			clientRepository.rmClientForName(name, c);

		} else {
			throw new ClientException("Erro: Não existe cliente com esse nome!");

		}

	}

	@Override
	public Client[] searcheClientForCpf(String cpf) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Client[] searcheClientForDistrict(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

}
