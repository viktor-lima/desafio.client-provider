package challenge.model.entities;

import java.util.Date;

public class Provider {
	
	private String cnpj;
	private String name;
	private String ghostName;
	private Date dt_fundacao;
	private Address address;			 
	private String email;
	private String typeOfService;
	
	public Provider() {
		// TODO Auto-generated constructor stub
	}

	public Provider(String cnpj, String name, String ghostName, Date dt_fundacao, Address address, String email,
			String typeOfService) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.ghostName = ghostName;
		this.dt_fundacao = dt_fundacao;
		this.address = address;
		this.email = email;
		this.typeOfService = typeOfService;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGhostName() {
		return ghostName;
	}

	public void setGhostName(String ghostName) {
		this.ghostName = ghostName;
	}

	public Date getDt_fundacao() {
		return dt_fundacao;
	}

	public void setDt_fundacao(Date dt_fundacao) {
		this.dt_fundacao = dt_fundacao;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	@Override
	public String toString() {
		return "Provider \n cnpj: " + cnpj + "\n name: " + name + "\n ghostName: " + ghostName + "\n dt_fundacao: " + dt_fundacao
				+ "\n address: " + address + "\n email: " + email + "\n typeOfService: " + typeOfService;
	}
	
	
	
	
}
