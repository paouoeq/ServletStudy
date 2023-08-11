package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("SetServlet");
		//1. request scope에 값 저장
		request.setAttribute("request","request scope");
		
		//2. session scope에 값 저장
		HttpSession session = request.getSession();
		session.setAttribute("session", "session scope");
		
		//3. application scope에 값 저장
		ServletContext ctx = request.getServletContext();
		ctx.setAttribute("application", "application scope");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
