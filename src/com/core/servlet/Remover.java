package com.core.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.modelo.Profissional;
import com.core.servico.ProfissionalServicoImple;

public class Remover extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
		ProfissionalServicoImple prof = new ProfissionalServicoImple();
		Profissional uDeletado = new Profissional();
		Integer i = Integer.parseInt(req.getParameter("id"));
		uDeletado = prof.findById(i);
		Profissional uLogado = new Profissional();
		uLogado = prof.findByNome(req.getParameter("nomeUsuario"));
		
		System.out.println(uDeletado.getNome()+"--");
		System.out.println(uLogado.getNome()+"--");
		System.out.println(i);
		
		if(!uDeletado.getNome().equals(uLogado.getNome())){
			System.out.println(i);
			prof.delete(i);
		}
		
		ServletContext sc =  req.getServletContext();
		req.setAttribute("usuarioLogado", uLogado);
        try {
        	sc.getRequestDispatcher("/jsp/home.jsp").forward(req, resp); 
        }catch(Exception e){
             
        } 
	}
}
