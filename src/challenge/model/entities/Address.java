package challenge.model.entities;

public class Address {
	
	private String street;
	private String district;
	private int number;
	private String complement;
	private String cep;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String district, int number, String complement, String cep) {
		super();
		this.street = street;
		this.district = district;
		this.number = number;
		this.complement = complement;
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Address \n street:" + street + "\n district: " + district + "\n number: " + number + "\n complement: "
				+ complement + "\n cep:" + cep;
	}
	
	
	

}
