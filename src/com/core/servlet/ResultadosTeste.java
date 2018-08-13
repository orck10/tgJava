package com.core.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.modelo.Crianca;
import com.api.modelo.Profissional;
import com.core.servico.CriancaServicoImp;
import com.core.servico.ProfissionalServicoImple;

public class ResultadosTeste extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		ProfissionalServicoImple prof = new ProfissionalServicoImple();
		Profissional uLogado = new Profissional();
		uLogado = prof.findByNome(req.getParameter("nomeUsuario"));
		
		String idS = req.getParameter("id");
		Integer id = Integer.parseInt(idS);
		
		CriancaServicoImp criServ = new CriancaServicoImp();
		
		Crianca cri = criServ.findById(id);
		
		ServletContext sc =  req.getServletContext();
		
		try {
			req.setAttribute("usuarioLogado", uLogado);
			req.setAttribute("crianca", cri);
			sc.getRequestDispatcher("/jsp/resultado.jsp").forward(req, resp);
	    }
		catch(Exception e){
			sc.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
		}
	}

}
