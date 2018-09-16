package com.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.api.dao.TemCDao;
import com.api.modelo.Recursos;
import com.api.modelo.TemC;

public class TemCDaoImp implements TemCDao{
	
	java.sql.Connection conexao;
	Recursos recursos = new Recursos();
	
	public TemCDaoImp() {
		conexao = recursos.devolveAnbiente();
	}
	
	@Override
	public List<TemC> porProblema(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from temc where problema_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			List<TemC> lista = new ArrayList<TemC>();
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()) {
				TemC t = new TemC();
				t.setProbId(rs.getInt(1));
				t.setCriId(rs.getInt(2));
				System.out.println("add a Lista");
				lista.add(t);
			}
			return lista;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... por problema all");
			return null;
		}
	}

	@Override
	public List<TemC> porCrianca(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from temc where crianca_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			List<TemC> lista = new ArrayList<TemC>();
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()) {
				TemC t = new TemC();
				t.setProbId(rs.getInt(1));
				t.setCriId(rs.getInt(2));
				System.out.println("add a Lista");
				lista.add(t);
			}
			return lista;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... por problema all");
			return null;
		}
	}

	@Override
	public List<TemC> todos() {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from temc;");
			List<TemC> lista = new ArrayList<TemC>();
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()) {
				TemC t = new TemC();
				t.setProbId(rs.getInt(1));
				t.setCriId(rs.getInt(2));
				System.out.println("add a Lista");
				lista.add(t);
			}
			return lista;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... por problema all");
			return null;
		}
	}

	@Override
	public boolean deletePorCrianca(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from temc where crianca_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			comandoSQLp.execute();
			return true;
		} catch (Exception e) {
			System.out.print("\nErro de conexão pelo id... remove");
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deletePorProblema(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from temc where problema_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			comandoSQLp.execute();
			return true;
		} catch (Exception e) {
			System.out.print("\nErro de conexão pelo id... remove");
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deletePorCriPro(Integer idC, Integer idP) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from temc where problema_Id = ? and crianca_Id = ?;");
			comandoSQLp.setString(1, idC.toString());
			comandoSQLp.setString(2, idC.toString());
			comandoSQLp.execute();
			return true;
		} catch (Exception e) {
			System.out.print("\nErro de conexão pelo id... remove");
			System.out.println(e);
			return false;
		}
	}

}
