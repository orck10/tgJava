package com.core.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.api.dao.ProblemaDao;
import com.api.modelo.Problema;

public class ProblemaDaoImp implements ProblemaDao{

	java.sql.Connection conexao;
	
	public ProblemaDaoImp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/torre","root","100889");
            System.out.println("Conectado.. Problema Dao...");
		} catch (Exception e) {
			System.out.print("Erro de conexão...ProblemaDaoImp");
		}
	}
	
	@Override
	public Problema insert(Problema p){
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("insert into problemas_apresentados(?);");
			comandoSQLp.setString(1, p.getProblemaNome());
			comandoSQLp.execute();
			System.out.print("\nInserido Problema");
			comandoSQLp.close();
			return this.findByNome(p.getProblemaNome());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Problema findById(Integer id) {
		Problema p = null;
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from problemas_apresentados where problema_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            p = new Problema();
            p.setProblemaId(rs.getInt(1));
            p.setProblemaNome(rs.getString(2));
            rs.close();
            System.out.println(p.getProblemaId().toString());
            return p;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... find by id");
			return null;
		}	
	}

	@Override
	public Problema findByNome(String nome) {
		Problema p = null;
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from problemas_apresentados where problema_Nome = ?;");
			comandoSQLp.setString(1, nome);
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            p = new Problema();
            p.setProblemaId(rs.getInt(1));
            p.setProblemaNome(rs.getString(2));
            rs.close();
            System.out.println(p.getProblemaId().toString());
            return p;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... find by nome");
			return null;
		}
	}

	@Override
	public List<Problema> findAll() {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from problemas_apresentados;");
			List<Problema> lista = new ArrayList<Problema>();
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()) {
				Problema p = new Problema();
				p.setProblemaId(rs.getInt(1));
		        p.setProblemaNome(rs.getString(2));
		        System.out.println("add a Lista");
	            lista.add(p);
			}
			return lista;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... find all");
		}
		return null;
	}

	@Override
	public Problema update(Problema atu, Problema ant) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("update problemas_apresentados set problema_Nome = ? where problema_Id = ?;");
			comandoSQLp.setString(1, atu.getProblemaNome());
			comandoSQLp.setString(2, ant.getProblemaId().toString());
			comandoSQLp.execute();
			System.out.println("\nAtualizado... update");
			comandoSQLp.close();
			return this.findById(ant.getProblemaId());
		} catch (Exception e) {
			System.out.print("\nErro de conexão... update");
			return null;
		}
	}

	@Override
	public boolean deletar(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from problemas_apresentados where problema_Id = ? ;");
			comandoSQLp.setString(1, id.toString());
			comandoSQLp.execute();
			System.out.println("\nRemovio problema pelo id ... remove");
			comandoSQLp.close();
		} catch (Exception e) {
			System.out.print("\nErro de conexão pelo id... remove");
		}
		return false;
	}

	@Override
	public boolean deletar(Problema problema) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from problemas_apresentados where problema_Id = ? ;");
			comandoSQLp.setString(1, problema.getProblemaId().toString());
			comandoSQLp.execute();
			System.out.println("\nRemovio problema pelo id ... remove");
			comandoSQLp.close();
		} catch (Exception e) {
			System.out.print("\nErro de conexão pelo id... remove");
		}
		return false;
	}

}
