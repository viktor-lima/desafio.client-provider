package challenge.model.entities;

import java.util.Date;

public class Client {
 
	private int codigo;
	private String name;
	private int age;
	private String email;
	private String cpf;
	private Address address;
	private Date dt_nascimento;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(int codigo, String name, int age, String email, String cpf, Address endereco,
			Date dt_nascimento) {
		super();
		this.codigo = codigo;
		this.name = name;
		this.age = age;
		this.email = email;
		this.cpf = cpf;
		this.address = endereco;
		this.dt_nascimento = dt_nascimento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int num) {
		this.codigo = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Address getEndereco() {
		return address;
	}

	public void setEndereco(Address endereco) {
		this.address = endereco;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	@Override
	public String toString() {
		return "Client: \n codigo: " + codigo + "\n name: " + name + "\n age: " + age + "\n email: " + email + "\n cpf: " + cpf;
				
	}
	
	
	
	
}
