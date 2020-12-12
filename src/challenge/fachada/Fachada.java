package challenge.fachada;

import challenge.controller.ClientController;
import challenge.controller.IclientController;
import challenge.controller.IproviderController;
import challenge.controller.ProviderController;
import challenge.model.entities.Client;
import challenge.model.entities.Provider;
import exceptions.ClientException;
import exceptions.ProviderException;

public class Fachada implements IclientController, IproviderController {

	private static Fachada instance;
	private IclientController clientController;
	private IproviderController providerController;
	//private IproviderController providerController;

	public static Fachada getInstance() {
		if (instance == null)
			return new Fachada();
		else
			return instance;
	}
	
	public Fachada () {
		clientController = ClientController.getInstance();
		providerController = ProviderController.getInstance();
		
	}

	@Override
	public void addClient(Client c) throws ClientException {
		// TODO Auto-generated method stub
		clientController.addClient(c);
		
	}

	@Override
	public void rmClient(String cpf) throws ClientException {
		// TODO Auto-generated method stub
		clientController.rmClient(cpf);
		
	}

	@Override
	public void rmClientByName(String name) throws ClientException {
		 clientController.rmClientByName(name);
		
	}

	@Override
	public Client searcheClientByCpf(String cpf) throws ClientException{
		// TODO Auto-generated method stub
		return clientController.searcheClientByCpf(cpf);
	}

	@Override
	public Client[] searcheClientByDistrict(String district) throws ClientException {
		return clientController.searcheClientByDistrict(district);
	}
	

	@Override
	public void insertProvider(Provider c) throws ProviderException {
		providerController.insertProvider(c);
		
	}

	@Override
	public void deleteProvider(Provider c) throws ProviderException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void earcheProviderByCnpj(String cnpj) throws ProviderException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searcheProviderByCep(Provider c) throws ProviderException {
		// TODO Auto-generated method stub
		
	}

}
