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
		// TODO Auto-generated method stub
		listaCliente.add(c);

	}

	@Override
	public void rmClient(String cpf, Client c) throws ClientException {
		// TODO Auto-generated method stub
		// if (c.getCpf().equals(cpf))
		listaCliente.remove(cpf);

	}

	@Override
	public void rmClientForName(String name, Client c) throws ClientException {
		// TODO Auto-generated method stub
		if (listaCliente != null && c.getName().equals(name)) {
			for (Client client : listaCliente) {
				listaCliente.remove(c);
			}
		} 

	}

	@Override
	public Client searcheClientForCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client[] searcheClientForDistrict(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existClient(String cpf) {
		for (Client c : listaCliente) {
			if (c.getCpf().equals(cpf) && listaCliente != null)
				return true;
		}
		return false;
	}

}
