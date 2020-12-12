package challenge.controller;

import challenge.model.entities.Provider;
import exceptions.ProviderException;

public interface IproviderController {

	public void insertProvider(Provider c) throws ProviderException;
	
	public void deleteProvider(Provider c) throws ProviderException;
	
	public void earcheProviderByCnpj(String cnpj) throws ProviderException;
	
	public void searcheProviderByCep(Provider c) throws ProviderException;
	
}
