package com.core.servico;

import java.util.ArrayList;
import java.util.List;

import com.api.modelo.Crianca;
import com.api.modelo.Teste;
import com.api.servico.TesteServico;
import com.core.dao.TesteDaoImp;

public class TesteServicoImp implements TesteServico{
	
	private TesteDaoImp teste = new TesteDaoImp();
	
	@Override
	public Teste insert(Teste t) {
		Teste teste = new Teste();
		teste = this.teste.insert(t);
		return teste;
	}

	@Override
	public Teste findById(Integer id) {
		Teste teste = new Teste();
		teste = this.teste.findById(id);
		return teste;
	}

	@Override
	public Teste findCrianca(Integer id) {
		Teste teste = new Teste();
		teste = this.teste.findCrianca(id);
		return teste;
	}

	@Override
	public List<Teste> findProficinal(Integer id) {
		List<Teste> lista = new ArrayList<Teste>();
		lista = this.teste.findProficinal(id);
		return lista;
	}

	@Override
	public Teste update(Teste ant, Teste atu) {
		Teste teste = new Teste();
		teste = this.teste.update(ant, atu);
		return teste;
	}

	@Override
	public Boolean delete(Integer id) {
		return this.teste.delete(id);
	}

	@Override
	public List<Crianca> findCriancaProfId(Integer i) {
		return this.teste.findCriancaProfId(i);
	}

}
