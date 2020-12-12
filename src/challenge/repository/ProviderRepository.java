package challenge.repository;

import java.util.ArrayList;
import java.util.List;

import challenge.model.entities.Provider;
import exceptions.ProviderException;

public class ProviderRepository implements IproviderReporitory{

	private List<Provider> listProvider;
	
	private static ProviderRepository instance;
	
	public static ProviderRepository getInstance() {
		if(instance == null)
			return new ProviderRepository();
		else
			return instance;
	}
	public ProviderRepository() {
		listProvider = new ArrayList<Provider>();
	}
	@Override
	public void insertProvider(Provider c) throws ProviderException {
		// TODO Auto-generated method stub
		
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
	@Override
	public boolean existProvider(String cpf) {
		for (Provider p : listProvider) {
			if (p.getCnpj().equals(cpf)){
				return true;
			}
		}
		return false;
	}

}
