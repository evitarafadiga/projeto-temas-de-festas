package model;

import java.util.Date;

public class Festa {
	private int cliente;
	private int tema;
	private Endereco endereco;
	private Double valor;
	private Double despesas;
	private Double desconto;
	private String descricaoDespesas;
	private Date horaInicio;
	private Date horaFim;
	private boolean select;

	public Festa(int cliente, int tema, Endereco endereco, Double valor, Double despesas, Double desconto,
			String descricaoDespesas, Date horaInicio, Date horaFim) {
		this.cliente = cliente;
		this.tema = tema;
		this.endereco = endereco;
		this.valor = valor;
		this.despesas = despesas;
		this.desconto = desconto;
		this.descricaoDespesas = descricaoDespesas;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;

	}
	
	public Festa(int cliente, int tema, Endereco endereco, Double valor, Double despesas, Double desconto,
			String descricaoDespesas, Date horaInicio, Date horaFim, boolean select) {
		this.cliente = cliente;
		this.tema = tema;
		this.endereco = endereco;
		this.valor = valor;
		this.despesas = despesas;
		this.desconto = desconto;
		this.descricaoDespesas = descricaoDespesas;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.select = select;
	}

	public Festa() {
		// TODO Auto-generated constructor stub
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getDespesas() {
		return despesas;
	}

	public void setDespesas(Double despesas) {
		this.despesas = despesas;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public String getDescricaoDespesas() {
		return descricaoDespesas;
	}

	public void setDescricaoDespesas(String descricaoDespesas) {
		this.descricaoDespesas = descricaoDespesas;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}
	
	public boolean getSelect() {
		return select;
	}
	
	public void setSelect(boolean select) {
		this.select = select;
	}

}
