package com.api.servico;

import java.util.List;

import com.api.modelo.Crianca;
import com.api.modelo.Fase;
import com.api.modelo.Teste;

public interface TesteServico {
	public Teste insert(Teste t);
	public Teste findById(Integer id);
	public Teste findCrianca(Integer id);
	public List<Teste> findProficinal(Integer id);
	public Teste update(Teste ant, Teste atu);
	public Boolean delete(Integer id);
	public List<Crianca> findCriancaProfId(Integer i);
	public boolean persistirFase(String crianca, List<Fase> fases);
}
