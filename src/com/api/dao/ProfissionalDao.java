package com.api.dao;

import java.util.List;

import com.api.modelo.Profissional;

public interface ProfissionalDao {
	public Profissional insert(Profissional p);
	public Profissional findById(Integer id);
	public Profissional findByNome(String nome);
	public List<Profissional> findAll();
	public Profissional update(Profissional profissionalAnt, Profissional profissionalAt);
    public boolean delete(Profissional profissional);
    public boolean delete(Integer id);   
}
