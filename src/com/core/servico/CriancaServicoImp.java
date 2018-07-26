package com.core.servico;

import java.util.ArrayList;
import java.util.List;

import com.api.modelo.Crianca;
import com.api.servico.CriancaServico;
import com.core.dao.CriancaDaoImp;

public class CriancaServicoImp implements CriancaServico{
	private CriancaDaoImp crianca = new CriancaDaoImp();
	
	@Override
	public Crianca insert(Crianca p) {
		Crianca c = new Crianca();
		c = this.crianca.insert(p);
		return c;
	}

	@Override
	public Crianca findById(Integer id) {
		Crianca c = new Crianca();
		c = this.crianca.findById(id);
		return c;
	}

	@Override
	public Crianca findByNome(String nome) {
		Crianca c = new Crianca();
		c = this.crianca.findByNome(nome);
		return c;
	}

	@Override
	public List<Crianca> findAll() {
		List<Crianca> lista = new ArrayList<Crianca>();
		lista = this.crianca.findAll();
		return lista;
	}

	@Override
	public Crianca update(Crianca atu, Crianca ant) {
		Crianca c = new Crianca();
		c = this.crianca.update(atu, ant);
		return c;
	}

	@Override
	public boolean deletar(Integer id) {
		Boolean d = this.crianca.deletar(id);
		return d;
	}
	
}
