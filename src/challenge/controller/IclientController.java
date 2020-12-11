package challenge.controller;

import java.util.List;

import challenge.model.entities.Client;
import exceptions.ClientException;

public interface IclientController {

	public void addClient(Client c) throws ClientException;

	public void rmClient(String cpf) throws ClientException;

	public void rmClientForName(String name) throws ClientException;

	public Client searcheClientByCpf(String cpf) throws ClientException;

	public Client[] searcheClientByDistrict(String district) throws ClientException;

}
