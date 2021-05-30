package model;

public class Endereco {
	private int idCliente;
	private String logradouro;
	private String cidade;
	private String estado;
	private Integer numero;
	private String complemento;
	private boolean select;

	public Endereco(int idCliente, String logradouro, String cidade, String estado, int numero,
			String complemento) {
		this.idCliente = idCliente;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.complemento = complemento;
	}
	
	public Endereco(int idCliente, String logradouro, String cidade, String estado, int numero,
			String complemento, boolean status) {
		this.idCliente = idCliente;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.complemento = complemento;
		this.select = status;
	}
	
	public Endereco() {
		
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		complemento = complemento;
	}
	
	public static String showUF(String estado) {
		System.out.println(estado);
		return estado;
	}
	
	public boolean getSelect() {
		return select;
	}
	
	public void setSelect(boolean select) {
		select = select;
	}

	@Override
	public String toString() {
		return idCliente + ";" + logradouro + ";" + cidade + ";"
				+ estado + ";" + numero + ";" + complemento + ";" + select +"\n";
	}
	
}
