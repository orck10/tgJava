package com.core.servlet;

import java.io.BufferedReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.api.modelo.Profissional;
import com.core.servico.ProfissionalServicoImple;


public class PersistirTestes extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
		String nomeUsuario = req.getHeader("nomeUsuario");
        String senha = req.getHeader("senha");
        
		ProfissionalServicoImple prof = new ProfissionalServicoImple();
		Profissional uLogado = new Profissional();
		uLogado = prof.findByNome(nomeUsuario);
		
		if(uLogado != null && uLogado.getSenha().equals(senha)) {
			try {
				// Read from request
			    StringBuilder buffer = new StringBuilder();
			    BufferedReader reader = req.getReader();
			    String line;
			    while ((line = reader.readLine()) != null) {
			        buffer.append(line);
			    }
			    String data = buffer.toString();
			    
			    System.out.println(data);
			    System.out.println(data);
			    
			}
			catch(Exception e){	
			}
		}
	}
}
