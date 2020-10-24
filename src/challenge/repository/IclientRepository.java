package challenge.repository;

import challenge.model.entities.Client;
import exceptions.ClientException;

public interface IclientRepository {
	
	public boolean existClient(String cpf);
	
	public boolean existClientForName(String name);

	public void addClient(Client c) throws ClientException;

	public void rmClient(String cpf) throws ClientException;

	public void rmClientForName(String name) throws ClientException;

	public Client searcheClientForCpf(String cpf) throws ClientException;

	public Client[] searcheClientForDistrict(Client c);

}
