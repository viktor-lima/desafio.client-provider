package challenge.repository;

import challenge.model.entities.Client;
import exceptions.ClientException;

public interface IclientRepository {
	
	public boolean existClient(String cpf);

	public void addClient(Client c) throws ClientException;

	public void rmClient(String cpf, Client c) throws ClientException;

	public void rmClientForName(String name, Client c) throws ClientException;

	public Client searcheClientForCpf(String cpf);

	public Client[] searcheClientForDistrict(Client c);

}