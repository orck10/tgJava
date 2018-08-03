package com.api.servico;

import java.util.List;

import com.api.modelo.Fase;

public interface FasesServico {
	public Fase insert(Fase f);
	public Fase update(Fase atu, Fase ant);
	public Fase findById(Integer id);
	public List<Fase> findByTesteId(Integer id);
	public Boolean deletar(Integer id);
}
