package model;

import java.util.Date;

public class Cliente {
	private int id;
	private Date dataProspeccao;
	private String nome;
	private String cpfcnpj;
	private String telefone;
	private String email;
	private Endereco endereco;
	private boolean status;

	public Cliente(int id, Date dataProspeccao, String nome, String cpfcnpj, String telefone, String email,
			Endereco endereco) {
		super();
		this.id = id;
		this.dataProspeccao = dataProspeccao;
		this.nome = nome;
		this.cpfcnpj = cpfcnpj;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Cliente (boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataProspeccao() {
		return dataProspeccao;
	}

	public void setDataProspeccao(Date dataProspeccao) {
		this.dataProspeccao = dataProspeccao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return id + ";" + dataProspeccao + ";" + nome + ";" + cpfcnpj + ";" + telefone + ";" + email + "\n";
	}

}
