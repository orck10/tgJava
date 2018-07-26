package com.core.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.modelo.Crianca;
import com.api.modelo.Profissional;
import com.api.modelo.Teste;
import com.core.servico.CriancaServicoImp;
import com.core.servico.ProfissionalServicoImple;
import com.core.servico.TesteServicoImp;

public class RemoverCrianca extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		ProfissionalServicoImple prof = new ProfissionalServicoImple();
		CriancaServicoImp cri = new CriancaServicoImp();

		Crianca cDeletada = new Crianca();
		Integer i = Integer.parseInt(req.getParameter("id"));
		cDeletada = cri.findById(i);
		
		Profissional uLogado = new Profissional();
		uLogado = prof.findByNome(req.getParameter("nomeUsuario"));
		
		TesteServicoImp teste = new TesteServicoImp();
		Teste t = new Teste();
		t = teste.findCrianca(i);
		
		System.out.println(t.getTesteId() + "--");
		System.out.println(cDeletada.getNome() + "--");
		System.out.println(uLogado.getNome() + "--");
		System.out.println(i);
		
		try {
			teste.delete(t.getTesteId());
		}catch (Exception e) {
			System.out.println("Falha ao deletar teste");
		}
		
		try {
			System.out.println(i);
			cri.deletar(i);
		}
		catch (Exception e) {
			System.out.println("Falha ao deletar crianca");
		}
		

		ServletContext sc = req.getServletContext();
		req.setAttribute("usuarioLogado", uLogado);
		try {
			sc.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
		} catch (Exception e) {

		}

	}
}
