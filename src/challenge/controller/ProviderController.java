package challenge.controller;

import challenge.model.entities.Provider;
import challenge.repository.IproviderReporitory;
import challenge.repository.ProviderRepository;
import exceptions.ProviderException;

public class ProviderController implements IproviderController {

	private IproviderReporitory providerRepository;

	private static ProviderController instance;

	public static ProviderController getInstance() {
		if (instance == null)
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
	public Provider searcheProviderByTypeOfService(String tipo) throws ProviderException {
		if (!providerRepository.existProviderTypeService(tipo))
			throw new ProviderException("Erro: tipo de serviço não existe!");
		else
			 return providerRepository.searcheProviderByTypeOfService(tipo); 
		

	}

	@Override
	public Provider[] searcheProviderByCep(String cep) throws ProviderException {
		if(!providerRepository.existProviderCep(cep))
			throw new ProviderException("Erro: Não existe fornecedor com  este cep!");
		else
			return providerRepository.searcheProviderByCep(cep);
	
		

	}
}
