package com.tvcaxias.entidades;

import java.util.Calendar;

public class Item {

	private long id;
	private String descricao;
	private Calendar entrada, saida;
	private String status, quem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getEntrada() {
		return entrada;
	}

	public void setEntrada(Calendar entrada) {
		this.entrada = entrada;
	}

	public Calendar getSaida() {
		return saida;
	}

	public void setSaida(Calendar saida) {
		this.saida = saida;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuem() {
		return quem;
	}

	public void setQuem(String quem) {
		this.quem = quem;
	}

}
