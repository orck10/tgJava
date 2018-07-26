package com.api.dao;

import java.util.List;
import com.api.modelo.TemC;

public interface TemCDao {
	public List<TemC> porProblema(Integer id);
	public List<TemC> porCrianca(Integer id);
	public List<TemC> todos();
	public boolean deletePorCrianca(Integer id);
	public boolean deletePorProblema(Integer id);
	public boolean deletePorCriPro(Integer idC, Integer idP);
}
