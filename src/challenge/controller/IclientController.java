package challenge.controller;

import challenge.model.entities.Client;
import exceptions.ClientException;

public interface IclientController {

	public void addClient(Client c) throws ClientException;

	public void rmClient(String cpf) throws ClientException;

	public void rmClientForName(String name) throws ClientException;

	public Client searcheClientForCpf(String cpf) throws ClientException;

	public Client[] searcheClientForDistrict(String district) throws ClientException;

}
