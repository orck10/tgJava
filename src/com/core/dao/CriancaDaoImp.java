package com.core.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.api.dao.CriancaDao;
import com.api.modelo.Crianca;
import com.api.modelo.Recursos;

public class CriancaDaoImp implements CriancaDao{
	
	java.sql.Connection conexao;
	Recursos recursos = new Recursos();
	
	public CriancaDaoImp() {
		conexao = recursos.devolveAmbiente();
	}
	
	@Override
	public Crianca insert(Crianca c) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("insert into crianca(crianca_Nome, crianca_Nascimento, crianca_Sexo) values(?,?,?);");
			comandoSQLp.setString(1, c.getNome());
			comandoSQLp.setDate(2, new java.sql.Date(c.getCriancaNasc().getTimeInMillis()));
			comandoSQLp.setString(3, c.getCriancaSexo());
			comandoSQLp.execute();
			System.out.print("\nInserido Crianca");
			comandoSQLp.close();
			return this.findByNome(c.getNome());
		} catch (Exception e) {
			System.out.print("\nErro de conexão... insert");
			return null;
		}
	}

	@Override
	public Crianca findById(Integer id) {
		Crianca c = null;
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from crianca where crianca_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            c = new Crianca();
            c.setId(rs.getInt(1));
            c.setNome(rs.getString(2));
            Calendar d = Calendar.getInstance();
            d.setTime(rs.getDate(3));
            c.setCriancaNasc(d);
            c.setCriancaSexo(rs.getString(4));
            rs.close();
            System.out.println(c.getId().toString());
            return c;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... find by id");
			return null;
		}
	}

	@Override
	public Crianca findByNome(String nome) {
		Crianca c = null;
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from crianca where crianca_Nome = ?;");
			comandoSQLp.setString(1, nome);
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            c = new Crianca();
            c.setId(rs.getInt(1));
            c.setNome(rs.getString(2));
            Calendar d = Calendar.getInstance();
            d.setTime(rs.getDate(3));
            c.setCriancaNasc(d);
            c.setCriancaSexo(rs.getString(4));
            rs.close();
            System.out.println(c.getId().toString());
            return c;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... find by nome");
			return null;
		}
	}

	@Override
	public List<Crianca> findAll() {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from crianca");
			List<Crianca> lista = new ArrayList<Crianca>();
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()){
				Crianca c = new Crianca();
	            c.setId(rs.getInt(1));
	            c.setNome(rs.getString(2));
	            Calendar d = Calendar.getInstance();
	            d.setTime(rs.getDate(3));
	            c.setCriancaNasc(d);
	            c.setCriancaSexo(rs.getString(4));
	            System.out.println("add a Lista");
	            lista.add(c);
			}
			return lista;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... find all");
			return null;
		}
	}

	@Override
	public Crianca update(Crianca atu, Crianca ant) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("update crianca set crianca_Nome = ?, crianca_Nascimento = ?, crianca_Sexo = ? where crianca_Id = ?;");
			comandoSQLp.setString(1, atu.getNome());
			comandoSQLp.setDate(2, new java.sql.Date(atu.getCriancaNasc().getTimeInMillis()));
			comandoSQLp.setString(3, atu.getCriancaSexo());
			comandoSQLp.setString(4, ant.getId().toString());
			comandoSQLp.execute();
			System.out.println("\nAtualizado... update");
			comandoSQLp.close();
			return this.findById(ant.getId());
		} catch (Exception e) {
			System.out.print("\nErro de conexão... update");
			return null;
		}
	}

	@Override
	public boolean deletar(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from crianca where crianca_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			comandoSQLp.execute();
			System.out.println("\nCrianca pelo id ... remove");
			comandoSQLp.close();
			return true;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... remove");
			return false;
		}
	}
}
