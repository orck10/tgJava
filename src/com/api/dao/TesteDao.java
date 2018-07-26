package com.api.dao;

import java.util.List;

import com.api.modelo.Crianca;
import com.api.modelo.Teste;

public interface TesteDao {
	public Teste insert(Teste t);
	public Teste findById(Integer id);
	public Teste findCrianca(Integer id);
	public List<Teste> findProficinal(Integer id);
	public Teste update(Teste ant, Teste atu);
	public Boolean delete(Integer id);
	public List<Crianca> findCriancaProfId(Integer i);
}
