package model;

import java.awt.Image;
import java.util.Date;

public class Tema {

	private Integer id;
	private Image img;
	private Double valor;
	private String status;
	private Date dataDisponibilizacao;
	private String descricao;

	public Tema(Integer id, Image img, Double valor, String status, Date dataDisponibilizacao, String descricao) {
		this.id = id;
		this.img = img;
		this.valor = valor;
		this.status = status;
		this.dataDisponibilizacao = dataDisponibilizacao;
		this.descricao = descricao;
	}

	public Tema() {
		// TODO Auto-generated constructor stub
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

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "Tema [id=" + id + ", valor=" + valor + ", status=" + status + ", dataDisponibilizacao="
				+ dataDisponibilizacao + ", descricao=" + descricao + "]";
	}

}
