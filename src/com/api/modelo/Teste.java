package com.api.modelo;

import java.util.Calendar;

public class Teste extends Identificador{
	private Integer testeId;
	private Calendar testeData;
	private int criancaId;
	private int psicoId;
	private String testeTipo;
	
	public Teste() {}
	public Teste(Integer testeId, Calendar testeData, int criancaId, int psicoId, String testeTipo) {
		super(testeId);
		this.testeData = testeData;
		this.criancaId = criancaId;
		this.psicoId = psicoId;
		this.testeTipo = testeTipo;
	}
	
	public int getTesteId() {
		return testeId;
	}
	
	public void setTesteId(int testeId) {
		this.testeId = testeId;
	}
	
	public Calendar getTesteData() {
		return testeData;
	}
	
	public void setTesteData(Calendar testeData) {
		this.testeData = testeData;
	}
	
	public int getCriancaId() {
		return criancaId;
	}
	
	public void setCriancaId(int criancaId) {
		this.criancaId = criancaId;
	}
	
	public String getTesteTipo() {
		return testeTipo;
	}
	
	public void setTesteTipo(String testeTipo) {
		this.testeTipo = testeTipo;
	}

	public int getPsicoId() {
		return psicoId;
	}

	public void setPsicoId(int psicoId) {
		this.psicoId = psicoId;
	}
	
}

