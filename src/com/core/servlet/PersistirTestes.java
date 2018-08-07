package com.core.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.modelo.Profissional;
import com.core.servico.ProfissionalServicoImple;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class PersistirTestes extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
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
			    
			    JsonParser jsonParser = new JsonParser();
			    JsonObject object = jsonParser.parse(data).getAsJsonObject();
			    String crianca = object.get("cricanca").getAsString();
			    JsonArray array = object.get("resultados").getAsJsonArray();
			    
			    System.out.println(crianca);
			    for(Object n : array) {
			    	JsonArray r = jsonParser.parse(n.toString()).getAsJsonArray();
			    	for(Object i: r) {
			    		System.out.println(i);	
			    	}
			    }
			    
			    
			    resp.setContentType("application/json");
			    resp.setCharacterEncoding("UTF-8");
			    resp.getWriter().write("{\"error\":\"false\"}");
			    
			}
			catch(Exception e){
				resp.setContentType("application/json");
			    resp.setCharacterEncoding("UTF-8");
			    resp.getWriter().write("{\"error\":\"true\"}");
			}
		}
	}
}
