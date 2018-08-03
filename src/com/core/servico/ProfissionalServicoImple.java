package com.core.servico;

import java.util.ArrayList;
import java.util.List;

import com.api.modelo.Crianca;
import com.api.modelo.Profissional;
import com.api.servico.ProfissionalServico;
import com.core.dao.ProfissionalDaoImp;

public class ProfissionalServicoImple implements ProfissionalServico{
	private ProfissionalDaoImp profi = new ProfissionalDaoImp();

	@Override
	public Profissional insert(Profissional p) {
		profi.insert(p);
		return p;
	}

	@Override
	public Profissional findById(Integer id) {
		Profissional p =  new Profissional();
		p = profi.findById(id);
		return p;
	}

	@Override
	public Profissional findByNome(String nome) {
		Profissional p =  new Profissional();
		p = profi.findByNome(nome);
		return p;
	}

	@Override
	public List<Profissional> findAll() {
		List<Profissional> p = new ArrayList<Profissional>();
		p = profi.findAll();
		return p;
	}

	@Override
	public Profissional update(Profissional profissionalAnt, Profissional profissionalAt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Profissional profissional) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		try{
			profi.delete(id);
			return true;
		}
		catch (Exception e) {
			System.out.println("Falhou o delet por id");
		}
		return false;
	}

	@Override
	public List<Crianca> findCriancaProfId(Integer i) {
		List<Crianca> l = new ArrayList<Crianca>();
		l = profi.findCriancaProfId(i);
		return l;
	}

}

