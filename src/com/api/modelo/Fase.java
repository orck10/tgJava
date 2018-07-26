package com.api.modelo;

public class Fase {
	private Identificador faseId;
	private int faseTentativas;
	private int faseAcerto;
	private int faseNumero;
	private int testeId;
	
	public int getTesteId() {
		return testeId;
	}

	public void setTesteId(int testeId) {
		this.testeId = testeId;
	}

	public int getFaseId() {
		return faseId.getId();
	}
	
	public void setFaseId(int faseId) {
		this.faseId.setId(faseId);
	}
	
	public int getFaseTentativas() {
		return faseTentativas;
	}
	
	public void setFaseTentativas(int faseTentativas) {
		this.faseTentativas = faseTentativas;
	}
	
	public int getFaseAcerto() {
		return faseAcerto;
	}
	
	public void setFaseAcerto(int faseAcerto) {
		this.faseAcerto = faseAcerto;
	}
	
	public int getFaseNumero() {
		return faseNumero;
	}
	
	public void setFaseNumero(int faseNumero) {
		this.faseNumero = faseNumero;
	}
}

