package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("GetServlet");
		
		//1. request scope에서 값 조회
		String x = (String)request.getAttribute("request");
		
		//2. session scope에서 값 조회
		HttpSession session = request.getSession();
		String x2 = (String)session.getAttribute("session");
		
		//3. application scope에서 값 조회
		ServletContext ctx = request.getServletContext();
		String x3 = (String)ctx.getAttribute("application");
		
		System.out.println("request : " + x);
		System.out.println("session : " + x2);
		System.out.println("application : " + x3);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
