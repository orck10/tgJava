package com.api.modelo;

import java.util.Calendar;


public class Crianca{
	private Integer id;
	private String nome;
	private String criancaSexo;
	private Calendar criancaNasc;	
	
	public Crianca(){}
	public Crianca(Integer id, String nome, String criancaSexo, Calendar criancaNasc) {
		this.nome = nome;
		this.criancaSexo = criancaSexo;
		this.criancaNasc = criancaNasc;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCriancaSexo() {
		return criancaSexo;
	}
	public void setCriancaSexo(String criancaSexo) {
		this.criancaSexo = criancaSexo;
	}
	public Calendar getCriancaNasc() {
		return criancaNasc;
	}
	public void setCriancaNasc(Calendar criancaNasc) {
		this.criancaNasc = criancaNasc;
	}
	
}
