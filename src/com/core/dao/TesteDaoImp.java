package com.core.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.api.dao.TesteDao;
import com.api.modelo.Crianca;
import com.api.modelo.Teste;

public class TesteDaoImp implements TesteDao{
	
	java.sql.Connection conexao;
	
	public TesteDaoImp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/torre","root","100889");
            System.out.println("Conectado.. Teste Dao...");
		} catch (Exception e) {
			System.out.print("Erro de conexão...TesteDaoImp");
		}
	}
	
	@Override
	public Teste insert(Teste t) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("insert into teste(teste_Data, Tipo, psico_Id, crianca_Id) values(?,?,?,?);");
			comandoSQLp.setDate(1, new java.sql.Date(t.getTesteData().getTimeInMillis()));
			comandoSQLp.setString(2, t.getTesteTipo());
			comandoSQLp.setInt(3, t.getPsicoId());
			comandoSQLp.setInt(4, t.getCriancaId());
			comandoSQLp.execute();
			System.out.print("\nInserido Teste");
			comandoSQLp.close();
			return this.findCrianca(t.getCriancaId());
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... insert");
			return null;
		}
	}

	@Override
	public Teste findById(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from teste where teste_id = ?;");
			comandoSQLp.setString(1, id.toString());
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            Teste t = new Teste();
            Calendar d = Calendar.getInstance();
            d.setTime(rs.getDate(1));
            t.setTesteData(d);
            t.setTesteTipo(rs.getString(2));
            t.setTesteId(rs.getInt(3));
            t.setPsicoId(rs.getInt(4));
            t.setCriancaId(rs.getInt(5));
            System.out.println(t.getTesteId());
			return t;
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... find by id");
			return null;
		}
	}

	@Override
	public Teste findCrianca(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from teste where crianca_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            Teste t = new Teste();
            Calendar d = Calendar.getInstance();
            d.setTime(rs.getDate(1));
            t.setTesteData(d);
            t.setTesteTipo(rs.getString(2));
            t.setTesteId(rs.getInt(3));
            t.setPsicoId(rs.getInt(4));
            t.setCriancaId(rs.getInt(5));
            System.out.println(t.getTesteId());
			return t;
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... find by crianca");
			return null;
		}
	}

	@Override
	public List<Teste> findProficinal(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from teste where psico_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			ResultSet rs = comandoSQLp.executeQuery();
			List<Teste> lista = new ArrayList<Teste>();
			while(rs.next()) {
				 Teste t = new Teste();
				 Calendar d = Calendar.getInstance();
		         d.setTime(rs.getDate(1));
		         t.setTesteData(d);
		         t.setTesteTipo(rs.getString(2));
		         t.setTesteId(rs.getInt(3));
		         t.setPsicoId(rs.getInt(4));
		         t.setCriancaId(rs.getInt(5));
		         System.out.println("add a Lista");
		         lista.add(t);
			}
			return lista;
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... find Proficinal");
			return null;
		}
	}

	@Override
	public Teste update(Teste ant, Teste atu) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("update teste set teste_Data = ?, Tipo = ?, psico_Id = ?, crianca_Id = ? where teste_Id = ?;");
			comandoSQLp.setDate(1, new java.sql.Date(atu.getTesteData().getTimeInMillis()));
			comandoSQLp.setString(2, atu.getTesteTipo());
			comandoSQLp.setInt(3, atu.getPsicoId());
			comandoSQLp.setInt(4, atu.getCriancaId());
			comandoSQLp.setInt(5, ant.getTesteId());
			comandoSQLp.execute();
			System.out.println("\nAtualizado... update");
			comandoSQLp.close();
			return this.findById(ant.getTesteId());
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... update");
			return null;
		}
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from teste where teste_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			comandoSQLp.execute();
			System.out.println("\nTeste pelo id ... remove");
			comandoSQLp.close();
			return true;
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão ... remove");
			return false;
		}
	}

	@Override
	public List<Crianca> findCriancaProfId(Integer i) {
		try {			PreparedStatement comandoSQLp = conexao.prepareStatement("select c.crianca_Id, c.crianca_Nascimento, c.crianca_Nome, c.crianca_Sexo from crianca c, teste t where t.psico_Id = ? and t.crianca_Id = c.crianca_Id");
			List<Crianca> lista = new ArrayList<Crianca>();
			comandoSQLp.setInt(1, i);
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()){
				Crianca c = new Crianca();
	            c.setId(rs.getInt(1));
	            c.setNome(rs.getString(3));
	            Calendar d = Calendar.getInstance();
	            System.out.println("1111");
	            d.setTime(rs.getDate(2));
	            c.setCriancaNasc(d);
	            c.setCriancaSexo(rs.getString(4));
	            System.out.println("add a Lista");
	            lista.add(c);
			}
			return lista;
		} catch (Exception e) {
			System.out.print("\nErro de conexão... Crianca no Teste");
			return null;
		}
	}

}
