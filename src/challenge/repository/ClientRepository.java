package challenge.repository;

import java.util.ArrayList;
import java.util.List;

import challenge.model.entities.Client;
import exceptions.ClientException;

public class ClientRepository implements IclientRepository {

	private List<Client> listaCliente;

	private static ClientRepository instance;

	public static ClientRepository getInstance() {
		if (instance == null)
			return new ClientRepository();
		else
			return instance;
	}

	public ClientRepository() {
		listaCliente = new ArrayList<Client>();
	}

	@Override
	public void addClient(Client c) throws ClientException {
		listaCliente.add(c);
	}

	@Override
	public void rmClient(String cpf) throws ClientException {

		for (Client c : listaCliente) {
			if (listaCliente != null && c.getCpf().equals(cpf)) {
				listaCliente.remove(c);
				return;
			}
		}
	}

	@Override
	public void rmClientByName(String name) throws ClientException {
		// TODO Auto-generated method stub

		for (Client c : listaCliente) {
			if (listaCliente != null && c.getName().equals(name)) {
				listaCliente.remove(c);
				return;
			}
		}

	}

	@Override
	public Client searcheClientByCpf(String cpf) throws ClientException {
		// TODO Auto-generated method stub
		for (Client client : listaCliente) {
			if (listaCliente != null && client.getCpf().equals(cpf)) {
				return client;
			}
		}
		return null;
	}

	@Override
	public Client[] searcheClientByDistrict(String district) throws ClientException {

		Client[] clients = null;
		int cont = 0;

		for (Client client : listaCliente) {
			if (listaCliente != null && client.getEndereco().getDistrict().equalsIgnoreCase(district)) {
				cont++;
			}
		}
		if (cont > 0) {

			clients = new Client[cont];
			int aux = 0;

			for (Client client : listaCliente) {
				if (listaCliente != null && client.getEndereco().getDistrict().equalsIgnoreCase(district)) {
					clients[aux] = client;
					aux++;
				}	
			}
			return clients;
		}
		return null;
	}

	@Override
	public boolean existClient(String cpf) {
		for (Client c : listaCliente) {
			if (c.getCpf().equals(cpf))
				return true;
		}
		return false;
	}

	@Override
	public boolean existClientForName(String name) {
		for (Client client : listaCliente) {
			if (client.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existClientForDistrict(String district) {
		for (Client client : listaCliente) {
			if (client.getEndereco().getDistrict().equalsIgnoreCase(district)) {
				return true;
			}
		}
		return false;
	}

}
