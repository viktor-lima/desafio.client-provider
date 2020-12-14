package challenge.controller;

import challenge.model.entities.Provider;
import exceptions.ProviderException;

public interface IproviderController {

	public void insertProvider(Provider p) throws ProviderException;
	
	public void deleteProvider(String cnpj) throws ProviderException;
	
	public Provider searcheProviderByTypeOfService(String tipo) throws ProviderException;
	
	public Provider[] searcheProviderByCep(String  cep) throws ProviderException;
	
}
