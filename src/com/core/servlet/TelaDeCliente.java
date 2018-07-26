package com.core.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.modelo.Crianca;
import com.api.modelo.Profissional;
import com.core.servico.CriancaServicoImp;
import com.core.servico.ProfissionalServicoImple;

public class TelaDeCliente extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){    
        ServletContext sc = req.getServletContext();
        
        try {
			req.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
        
        String idS = req.getParameter("id");
        String profS = req.getParameter("prof");
        
        int id = Integer.parseInt(idS);
        CriancaServicoImp servCri = new CriancaServicoImp();
        Crianca cri =  servCri.findById(id);
        
        ProfissionalServicoImple servProf = new ProfissionalServicoImple();
        Profissional prof = servProf.findByNome(profS);
        
        req.setAttribute("usuarioLogado", prof);
        req.setAttribute("cri", cri);
        try{
        	sc.getRequestDispatcher("/jsp/cliente.jsp").forward(req, resp);            
        }
        catch (Exception e) {
			System.out.println("Falha ao ir para tela de Cliente");
		}
    }
}
