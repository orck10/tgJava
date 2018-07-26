package com.api.modelo;


public class Problema {
	private Identificador problemaId;
	private String problemaNome;
	
	public Integer getProblemaId() {
		return problemaId.getId();
	}
	public void setProblemaId(Integer problemaId) {
		this.problemaId.setId(problemaId);
	}
	public String getProblemaNome() {
		return problemaNome;
	}
	public void setProblemaNome(String problemaNome) {
		this.problemaNome = problemaNome;
	}
}
