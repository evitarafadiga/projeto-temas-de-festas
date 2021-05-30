package model;

import java.util.Date;
import java.text.DateFormat;

public class Cliente {
	private int id;
	private Date dataProspeccao;
	private String nome;
	private String cpfcnpj;
	private String telefone;
	private String email;
	private Endereco endereco;
	private boolean select;

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
	
	public Cliente(int id, Date dataProspeccao, String nome, String cpfcnpj, String telefone, String email,
			Endereco endereco, boolean status) {
		super();
		this.id = id;
		this.dataProspeccao = dataProspeccao;
		this.nome = nome;
		this.cpfcnpj = cpfcnpj;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.select = status;
	}
	

	public Cliente() {
		// TODO Auto-generated constructor stub
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
	
	public Boolean getSelect() {
		return select;
	}
	
	public void setSelect(Boolean select) {
		this.select = select;
	}

	@Override
	public String toString() {
		DateFormat df = DateFormat.getInstance();
		return id + ";" + df.format(dataProspeccao) + ";" + nome + ";" + cpfcnpj + ";" + telefone + ";" + email  + "\n";
	}

}
