package challenge.controller;

import challenge.model.entities.Provider;
import challenge.repository.IproviderReporitory;
import challenge.repository.ProviderRepository;
import exceptions.ClientException;
import exceptions.ProviderException;

public class ProviderController implements IproviderController{

	private IproviderReporitory providerRepository;
	
	private static ProviderController instance;
	
	public static ProviderController getInstance() {
		if(instance == null)
			return new ProviderController();
		else
			return instance;
	}
	public ProviderController() {
		providerRepository = ProviderRepository.getInstance();
	}
	@Override
	public void insertProvider(Provider c) throws ProviderException {
		if (providerRepository.existProvider(c.getCnpj())) {
			throw new ProviderException("Erro: fornecedor já existe!");
		}
		
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
