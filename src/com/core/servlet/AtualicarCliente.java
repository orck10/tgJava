package com.core.servlet;

import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.modelo.Crianca;
import com.api.modelo.Data;
import com.api.modelo.Profissional;
import com.core.servico.CriancaServicoImp;
import com.core.servico.ProfissionalServicoImple;

public class AtualicarCliente extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
		ProfissionalServicoImple prof = new ProfissionalServicoImple();
		Profissional uLogado = new Profissional();
		uLogado = prof.findByNome(req.getParameter("nomeUsuario"));
		
		String idS = req.getParameter("id");
		Integer id = Integer.parseInt(idS);
		String nome = req.getParameter("nome");
		Calendar nasc = Calendar.getInstance();
		String sexo = req.getParameter("sexo");
		
		try {
			nasc = new Data().formata(req.getParameter("nasc"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Crianca c = new Crianca();
		c.setNome(nome);
		c.setCriancaNasc(nasc);
		c.setCriancaSexo(sexo);
		
		CriancaServicoImp criServ = new CriancaServicoImp();
		
		//anterior
		Crianca ant = criServ.findById(id); 
		
		try {
			criServ.update(c, ant);
		}
		catch (Exception e) {
			System.out.println("Falhou ao atualizar Crianca");
		}
		
		ServletContext sc =  req.getServletContext();
		req.setAttribute("usuarioLogado", uLogado);
		
		try {
        	sc.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
        }catch(Exception e){
             
        }
	}
}
