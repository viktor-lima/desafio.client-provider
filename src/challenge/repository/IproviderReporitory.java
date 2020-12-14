package challenge.repository;

import challenge.model.entities.Provider;
import exceptions.ProviderException;

public interface IproviderReporitory {

	public void insertProvider(Provider p) throws ProviderException;

	public void deleteProvider(String cnoj) throws ProviderException;

	public Provider searcheProviderByTypeOfService(String cnpj) throws ProviderException;

	public Provider[] searcheProviderByCep(String cep) throws ProviderException;

	public boolean existProvider(String cpf);

	public boolean existProviderTypeService(String tipo);

	public boolean existProviderCep(String cep);

}
