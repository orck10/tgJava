package com.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.api.dao.ProfissionalDao;
import com.api.modelo.Crianca;
import com.api.modelo.Profissional;
import com.api.modelo.Recursos;

public class ProfissionalDaoImp implements ProfissionalDao{
	
	java.sql.Connection conexao;
	Recursos recursos = new Recursos();
	
	public ProfissionalDaoImp() {
		conexao = recursos.devolveAnbiente();
	}

	@Override
	public Profissional insert(Profissional p) {
		try{
			PreparedStatement comandoSQLp = conexao.prepareStatement("insert into psicopedagoga(psico_Nome, psico_Data_Forma艫o, psico_Email, psico_Senha) values(?,?,?,?)");
			comandoSQLp.setString(1, p.getNome());
			comandoSQLp.setDate(2, new java.sql.Date(p.getDataFormacao().getTimeInMillis()));
			comandoSQLp.setString(3, p.getEmail());
			comandoSQLp.setString(4, p.getSenha());
			comandoSQLp.execute();
			System.out.print("\nInserido Profissional");
			comandoSQLp.close();
			return this.findByNome(p.getNome());
		}
		catch (Exception e) {
			System.out.print("\nErro de conex達o... insert");
			return null;
		}
	}

	@Override
	public Profissional findById(Integer id) {
		Profissional p = null;
		try{
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from psicopedagoga where psico_id = ?");
			comandoSQLp.setString(1, id.toString());
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            p = new Profissional();
            p.setProfIdInt(rs.getInt(1));
            p.setNome(rs.getString(2));
            Calendar c = Calendar.getInstance();
            c.setTime(rs.getDate(3));
            p.setDataFormacao(c);
            p.setEmail(rs.getString(4));
            p.setSenha(rs.getString(5));
            rs.close();
            System.out.println(p.getProfId().toString());
            return p;
		}
		catch (Exception e) {
			System.out.print("\nErro de conex達o... find by id");
			return null;
		}
	}

	@Override
	public Profissional findByNome(String nome) {
		Profissional p;
		try{
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from psicopedagoga where psico_Nome = ?");
			comandoSQLp.setString(1, nome);
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            p = new Profissional();
            int x = rs.getInt(1);
            System.out.println(x);
            p.setProfId(x);
            p.setNome(rs.getString(2));
            Calendar c = Calendar.getInstance();
            c.setTime(rs.getDate(3));
            p.setDataFormacao(c);
            p.setEmail(rs.getString(4));
            p.setSenha(rs.getString(5));
            rs.close();
            return p;
		}
		catch (Exception e) {
			System.out.print("\nErro de conex達o... find by nome");
			return null;
		}
	}

	@Override
	public List<Profissional> findAll() {
		try{
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from psicopedagoga");
			List<Profissional> lista = new ArrayList<Profissional>();
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()){
				Profissional p = new Profissional();
				p.setProfIdInt(rs.getInt(1));
				p.setNome(rs.getString(2));
				Calendar c = Calendar.getInstance();
	            c.setTime(rs.getDate(3));
	            p.setDataFormacao(c);
	            p.setEmail(rs.getString(4));
	            p.setSenha(rs.getString(5));
	            System.out.println("add a Lista");
	            lista.add(p);
			}
			return lista;
		}
		catch (Exception e) {
			System.out.print("\nErro de conex達o... find all");
			return null;
		}
	}

	@Override
	public Profissional update(Profissional profissionalAnt, Profissional profissionalAt) {
		try{
			PreparedStatement comandoSQLp = conexao.prepareStatement("update psicopedagoga set psico_Nome = ?, psico_Data_Forma艫o = ?, psico_Email = ?, psico_Senha = ? where psico_Id = ?");
			comandoSQLp.setString(1, profissionalAt.getNome());
			comandoSQLp.setDate(2, new java.sql.Date(profissionalAt.getDataFormacao().getTimeInMillis()));
			comandoSQLp.setString(3, profissionalAt.getEmail());
			comandoSQLp.setString(4, profissionalAt.getSenha());
			comandoSQLp.setString(5, profissionalAnt.getProfId().toString());
			comandoSQLp.execute();
			System.out.println("\nAtualizado... update");
			comandoSQLp.close();
			return this.findById(profissionalAnt.getProfId());
		}
		catch (Exception e) {
			System.out.print("\nErro de conex達o... update");
			return null;
		}
	}

	@Override
	public boolean delete(Profissional profissional) {
		try{
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from psicopedagoga where psico_Id = ?");
			comandoSQLp.setString(1, profissional.getProfId().toString());
			comandoSQLp.execute();
			System.out.println("\nRemovio profissional ... remove");
			comandoSQLp.close();
			return true;
		}
		catch (Exception e) {
			System.out.print("\nErro de conex達o... remove");
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try{
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from psicopedagoga where psico_Id = ?");
			comandoSQLp.setString(1, id.toString());
			comandoSQLp.execute();
			System.out.println("\nRemovio profissional pelo id ... remove");
			comandoSQLp.close();
			return true;
		}
		catch (Exception e) {
			System.out.print("\nErro de conex達o pelo id... remove");
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Crianca> findCriancaProfId(Integer i) {
		try {			
			PreparedStatement comandoSQLp = conexao.prepareStatement("select c.crianca_Id, c.crianca_Nascimento, c.crianca_Nome, c.crianca_Sexo from crianca c where c.crianca_Id in (SELECT t.crianca_Id FROM teste t where t.psico_Id = ? and t.teste_Id not in (select teste_Id from fase f))");
			List<Crianca> lista = new ArrayList<Crianca>();
			comandoSQLp.setInt(1, i);
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()){
				Crianca c = new Crianca();
	            c.setId(rs.getInt(1));
	            c.setNome(rs.getString(3));
	            Calendar d = Calendar.getInstance();
	            d.setTime(rs.getDate(2));
	            c.setCriancaNasc(d);
	            c.setCriancaSexo(rs.getString(4));
	            System.out.println("add a Lista");
	            lista.add(c);
			}
			return lista;
		} catch (Exception e) {
			System.out.print("\nErro de conex達o... Crianca no Teste");
			return null;
		}
	}

}
