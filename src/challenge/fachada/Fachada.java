package challenge.fachada;

import challenge.controller.ClientController;
import challenge.controller.IclientController;
import challenge.controller.IproviderController;
import challenge.model.entities.Client;
import exceptions.ClientException;

public class Fachada implements IclientController, IproviderController {

	private static Fachada instance;
	private IclientController clientController;
	//private IproviderController providerController;

	public static Fachada getInstance() {
		if (instance == null)
			return new Fachada();
		else
			return instance;
	}
	
	public Fachada () {
		clientController = ClientController.getInstance();
		
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
	public void rmClientForName(String name) throws ClientException {
		 clientController.rmClientForName(name);
		
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

}
