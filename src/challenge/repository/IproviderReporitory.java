package challenge.repository;

import challenge.model.entities.Provider;
import exceptions.ProviderException;

public interface IproviderReporitory {
	
	
	public void insertProvider(Provider p) throws ProviderException;

	public void deleteProvider(String cnoj) throws ProviderException;

	public void earcheProviderByCnpj(String cnpj) throws ProviderException;

	public void searcheProviderByCep(Provider p) throws ProviderException;
	
	public boolean existProvider(String cpf);

}
