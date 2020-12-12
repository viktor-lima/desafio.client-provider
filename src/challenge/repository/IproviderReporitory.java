package challenge.repository;

import challenge.model.entities.Provider;
import exceptions.ProviderException;

public interface IproviderReporitory {
	
	
	public void insertProvider(Provider c) throws ProviderException;

	public void deleteProvider(Provider c) throws ProviderException;

	public void earcheProviderByCnpj(String cnpj) throws ProviderException;

	public void searcheProviderByCep(Provider c) throws ProviderException;
	
	public boolean existProvider(String cpf);

}
