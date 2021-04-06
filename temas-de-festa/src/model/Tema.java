package model;

import java.util.Date;

public class Tema {

	private Integer id;
	private Double valor;
	private String status;
	private Date dataDisponibilizacao;
	private String descricao;

	public Tema(Integer id, Double valor, String status, Date dataDisponibilizacao, String descricao) {
		this.id = id;
		this.valor = valor;
		this.status = status;
		this.dataDisponibilizacao = dataDisponibilizacao;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataDisponibilizacao() {
		return dataDisponibilizacao;
	}

	public void setDataDisponibilizacao(Date dataDisponibilizacao) {
		this.dataDisponibilizacao = dataDisponibilizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
