package com.api.modelo;

public class TemC {
	public Integer criId;
	public Integer probId;
	
	public TemC() {}
	
	public TemC(Integer criId, Integer probId) {
		super();
		this.criId = criId;
		this.probId = probId;
	}

	public Integer getCriId() {
		return criId;
	}

	public void setCriId(Integer criId) {
		this.criId = criId;
	}

	public Integer getProbId() {
		return probId;
	}

	public void setProbId(Integer probId) {
		this.probId = probId;
	}
}
