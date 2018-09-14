package com.core.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.api.dao.FaseDao;
import com.api.modelo.Fase;

public class FaseDaoImp implements FaseDao{
	
	java.sql.Connection conexao;
	
	public FaseDaoImp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/torre","root","100889");
            System.out.println("Conectado.. Fase Dao...");
		} catch (Exception e) {
			System.out.print("Erro de conexão...ProblemaDaoImp");
		}
	}
	
	@Override
	public Fase insert(Fase f) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("insert into fase(fase_tentativas, fase_acerto, fase_numero, teste_Id) values(?,?,?,?);");
			comandoSQLp.setInt(1, f.getFaseTentativas());
			comandoSQLp.setInt(2, f.getFaseAcerto());
			comandoSQLp.setInt(3, f.getFaseNumero());
			comandoSQLp.setInt(4, f.getTesteId());
			comandoSQLp.execute();
			System.out.print("\nInserido Fase");
			comandoSQLp.close();
			return this.findById(f.getTesteId());
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... insert");
			return null;
		}
	}

	@Override
	public Fase findById(Integer id) {
		Fase f = null;
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select * from fase where fase_id = ?;");
			comandoSQLp.setString(1, id.toString());
			ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            f = new Fase();
            f.setFaseId(rs.getInt(1));
            f.setFaseTentativas(rs.getInt(2));
            f.setFaseAcerto(rs.getInt(3));
            f.setFaseNumero(rs.getInt(4));
            f.setTesteId(rs.getInt(5));
            rs.close();
            System.out.println(f.getFaseId());
            return f;
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... findById");
			return null;
		}
	}

	@Override
	public List<Fase> findByTesteId(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("select fase_Id, fase_Tentativas, fase_acerto, fase_Numero, fase.teste_Id from fase where teste_id = ?;");
			comandoSQLp.setString(1, id.toString());
			List<Fase> lista = new ArrayList<Fase>();
			ResultSet rs = comandoSQLp.executeQuery();
			while(rs.next()) {
				Fase f = new Fase();
				f.setFaseId(rs.getInt(1));
	            f.setFaseTentativas(rs.getInt(2));
	            f.setFaseAcerto(rs.getInt(3));
	            f.setFaseNumero(rs.getInt(4));
	            f.setTesteId(rs.getInt(5));
	            System.out.println("add a Lista");
	            lista.add(f);
			}
			return lista;
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão...  find by testeId");
			return null;
		}
	}

	@Override
	public Boolean deletar(Integer id) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("delete from fase where fase_Id = ?;");
			comandoSQLp.setString(1, id.toString());
			comandoSQLp.execute();
			System.out.println("\nFase pelo id ... remove");
			comandoSQLp.close();
			return true;
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... deletar all");
			System.out.println(e);
			return false;
		}
	}
	
	@Override
	public Fase update(Fase atu, Fase ant) {
		try {
			PreparedStatement comandoSQLp = conexao.prepareStatement("update fase set fase_tentativas = 2, fase_acerto = 1, fase_numero = 1, teste_Id = 1 where fase_Id = 1");
			comandoSQLp.setInt(1, ant.getFaseTentativas());
			comandoSQLp.setInt(2, ant.getFaseAcerto());
			comandoSQLp.setInt(3, ant.getFaseNumero());
			comandoSQLp.setInt(4, ant.getTesteId());
			comandoSQLp.setInt(4, atu.getFaseId());
			comandoSQLp.execute();
			System.out.print("\nAtualizado... update");
			comandoSQLp.close();
			return this.findById(atu.getTesteId());
		}
		catch (Exception e) {
			System.out.print("\nErro de conexão... insert");
			return null;
		}
	}
}
