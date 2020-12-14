package challenge.repository;

import java.util.ArrayList;
import java.util.List;

import challenge.model.entities.Provider;
import exceptions.ProviderException;

public class ProviderRepository implements IproviderReporitory {

	private List<Provider> listProvider;

	private static ProviderRepository instance;

	public static ProviderRepository getInstance() {
		if (instance == null)
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
	public Provider searcheProviderByTypeOfService(String tipo) throws ProviderException {

		for (Provider p : listProvider) {
			if (listProvider != null && p.getTypeOfService().equals(tipo)) {
				return p;
			}
		}

		return null;

	}

	@Override
	public Provider[] searcheProviderByCep(String cep) throws ProviderException {
		Provider[] listCepP = null;
		int cont = 0;

		for (Provider p : listProvider) {
			if (listProvider != null && p.getAddress().getCep().equalsIgnoreCase(cep)) {
				cont++;
			}
		}

		if (cont > 0) {
			listCepP = new Provider[cont];
			int aux = 0;
			for (Provider p : listProvider) {
				if (listProvider != null && p.getAddress().getCep().equalsIgnoreCase(cep)) {
					listCepP[aux] = p;
					aux++;
				}
				return listCepP;
			}
		}
		
		return null;
	}

	@Override
	public boolean existProvider(String cpf) {
		for (Provider p : listProvider) {
			if (p.getCnpj().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existProviderTypeService(String tipo) {
		for (Provider p : listProvider) {
			if (p.getTypeOfService().equals(tipo)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existProviderCep(String cep) {
		for (Provider p : listProvider) {
			if (p.getAddress().getCep().equals(cep))
				return true;
		}
		return false;
	}

}
