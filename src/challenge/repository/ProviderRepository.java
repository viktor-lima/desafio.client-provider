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
	public void insertProvider(Provider p) throws ProviderException {
		listProvider.add(p);
		
	}
	@Override
	public void deleteProvider(String cnpj) throws ProviderException {
		for (Provider p : listProvider) {
			if (listProvider != null && p.getCnpj().equals(cnpj)) {
				listProvider.remove(p);
				return;
			}
		}
		
	}
	@Override
	public void earcheProviderByCnpj(String cnpj) throws ProviderException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void searcheProviderByCep(Provider p) throws ProviderException {
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
