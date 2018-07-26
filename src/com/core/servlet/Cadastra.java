package com.core.servlet;

import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.modelo.Profissional;
import com.core.servico.ProfissionalServicoImple;

public class Cadastra extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Calendar c  = Calendar.getInstance();
		c.setTime(Calendar.getInstance().getTime());
		
		Profissional p = new Profissional();
		ProfissionalServicoImple prof = new ProfissionalServicoImple();
		
		p.setEmail(email);
		p.setNome(nome);
		p.setSenha(senha);
		p.setDataFormacao(c);
		
		prof.insert(p);
		
		System.out.println(p.getNome());
		System.out.println(p.getEmail());
		System.out.println(p.getSenha());
		System.out.println(p.getDataFormacao());
		
		ServletContext sc =  req.getServletContext();
		
        try {
        	sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        }catch(Exception e){
             
        }
		
	}
}
