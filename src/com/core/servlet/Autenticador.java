package com.core.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.modelo.Profissional;
import com.core.servico.ProfissionalServicoImple;

public class Autenticador extends HttpServlet {

	private static final long serialVersionUID = -31172017030561396L;

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        
		try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
		
        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        ServletContext sc =  req.getServletContext();
        
        Profissional usuario = new Profissional();
	    ProfissionalServicoImple prof = new ProfissionalServicoImple();
	    
	    
        try{
        	usuario = prof.findByNome(nomeUsuario);
        }
        catch (Exception e) {
        	
		}
        Profissional uLogado = null;
        
        if(usuario != null && usuario.getSenha().equals(senha)){
        	uLogado = usuario;
        }
        
        if ( uLogado!= null){ 
            req.setAttribute("usuarioLogado", uLogado);
            try {
                sc.getRequestDispatcher("/jsp/home.jsp").forward(req, resp); 
            }catch(Exception e){
                
            }                       
        }
        else{
            try {
                req.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
            }catch(Exception e){
                
            }  
        }    
    }
}
