package com.api.modelo;

import java.util.Calendar;

public class Profissional{

	private Integer profId;
	private String nome;
	private Calendar dataFormacao;
	private String email;
	private String senha;
	
	
	public Profissional(){}
	public Profissional(Integer profId, String nome, Calendar dataFormacao, String email, String senha) {
		this.profId = profId;
		this.nome = nome;
		this.dataFormacao = dataFormacao;
		this.email = email;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Integer getProfId() {
		return profId;
	}
	
	public void setProfIdInt(int profId) {
		this.profId = profId;
	}
	
	public void setProfId(Integer profId) {
		this.profId = profId;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Calendar getDataFormacao() {
		return dataFormacao;
	}
	
	public void setDataFormacao(Calendar dataFormacao) {
		this.dataFormacao = dataFormacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
