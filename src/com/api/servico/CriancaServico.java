package com.api.servico;

import java.util.List;

import com.api.modelo.Crianca;

public interface CriancaServico {
	public Crianca insert(Crianca p);
	public Crianca findById(Integer  id);
	public Crianca findByNome(String  nome);
	public List<Crianca> findAll();
	public Crianca update(Crianca atu, Crianca ant);
	public boolean deletar(Integer id);
}
