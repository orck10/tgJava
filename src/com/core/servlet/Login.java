package com.core.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){    
        ServletContext sc = req.getServletContext();
        try{
        	sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
}
