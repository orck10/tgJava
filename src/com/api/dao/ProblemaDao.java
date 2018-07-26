package com.api.dao;

import java.util.List;

import com.api.modelo.Problema;

public interface ProblemaDao {
	public Problema insert(Problema p);
	public Problema findById(Integer  id);
	public Problema findByNome(String  nome);
	public List<Problema> findAll();
	public Problema update(Problema atu, Problema ant);
	public boolean deletar(Integer id);
	public boolean deletar(Problema problema);
}
