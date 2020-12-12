package challenge.controller;

import challenge.model.entities.Provider;
import challenge.repository.IproviderReporitory;
import challenge.repository.ProviderRepository;
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
	public void insertProvider(Provider p) throws ProviderException {
		if (providerRepository.existProvider(p.getCnpj())) 
			throw new ProviderException("Erro: fornecedor já existe!");
		else
			providerRepository.insertProvider(p);
		
	}
	@Override
	public void deleteProvider(String cnpj) throws ProviderException {
		if (!providerRepository.existProvider(cnpj)) 
			throw new ProviderException("Erro: fornecedor não existe!");
		
		else
			providerRepository.deleteProvider(cnpj);
			
			
		
		
	}
	@Override
	public void earcheProviderByCnpj(String cnpj) throws ProviderException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void searcheProviderByCep(Provider p) throws ProviderException {
		// TODO Auto-generated method stub
		
	}
}
