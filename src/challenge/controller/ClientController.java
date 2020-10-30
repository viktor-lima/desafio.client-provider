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
	public void rmClient(String cpf) throws ClientException {
		// TODO Auto-generated method stub
		if (clientRepository.existClient(cpf) != true) {
			throw new ClientException("Erro: cliente não existe!");
		} else {
			clientRepository.rmClient(cpf);
		}

	}

	@Override
	public void rmClientForName(String name) throws ClientException {
		// TODO Auto-generated method stub
		if (!clientRepository.existClientForName(name)) {
			throw new ClientException("Erro: Não existe cliente com esse nome!");
		} else {
			clientRepository.rmClientForName(name);
			

		}

	}

	@Override
	public Client searcheClientForCpf(String cpf) throws ClientException {
		if(!clientRepository.existClient(cpf))
			throw new ClientException("Erro: cliente não existe!");
		else
			return clientRepository.searcheClientForCpf(cpf);
			
			
		
		
	}

	@Override
	public Client[] searcheClientForDistrict(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

}
