package com.core.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import com.api.modelo.Profissional;

import com.core.servico.ProfissionalServicoImple;
import com.core.servico.TesteServicoImp;

public class AutenticarApp extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
		try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
		
		String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        
        Profissional usuario = new Profissional();
	    ProfissionalServicoImple prof = new ProfissionalServicoImple();
	    
	    TesteServicoImp teste = new TesteServicoImp();
	    
	    Gson gson = new Gson();
	    
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
            try {
            	
            	resp.setContentType("application/json");
            	resp.setCharacterEncoding("UTF-8");
            	String jsonUsu = gson.toJson(uLogado);
            	int x = uLogado.getProfId().intValue();
            	String jsonCri = gson.toJson(teste.findCriancaProfId(x));
                //resp.getWriter().write("{\"error\":\"false\",\"name\":\""+uLogado.getNome()+"\"}");
            	resp.getWriter().write("{\"error\":\"false\", \"usuario\":"+jsonUsu+", \"criancas\":"+jsonCri+"}");
            }catch(Exception e){
                
            }                       
        }
        else{
            try {
            	resp.setContentType("application/json");
            	resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("{\"error\":\"true\", \"type\":\"Usuario ou senha Invalidos\"}");
            }catch(Exception e){
                
            }  
        }
	}
}
