package com.api.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Recursos {
	
	/*
	private static String banco = "jdbc:mysql://localhost:3306/torre";
	private static String usuario = "root";
	private static String senha = "100889";
	*/
	
	private static String banco = "jdbc:mysql://torre.mysql.uhserver.com:3306/torre";
	private static String usuario = "orck10";
	private static String senha = "8077@Beh";
	
	/**
	 * @return the banco
	 */
	public static String getBanco() {
		return banco;
	}
	/**
	 * @return the usuario
	 */
	public static String getUsuario() {
		return usuario;
	}
	/**
	 * @return the senha
	 */
	public static String getSenha() {
		return senha;
	}
	
	public Connection devolveAmbiente(){
		Connection conexao = null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(banco, usuario, senha);
            System.out.println("Conectado.. Entidade Dao...");
		} catch (Exception e) {
			System.out.print("Erro de conexão...ProblemaDaoImp");
		}
		
		return conexao;
	}
}
