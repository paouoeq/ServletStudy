package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ResponseServlet");
		
		String s = (String)request.getAttribute("request");
		HttpSession session = request.getSession();
		String s2 = (String)session.getAttribute("session");
		
		ServletContext applicaton = getServletContext();
		String s3 = (String)applicaton.getAttribute("applicaton");
		System.out.println("request:" + s);
		System.out.println("session:" + s2);
		System.out.println("applicaton:" + s3);
		
		
		// 응답처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		 
		out.print("<h1>ResponseServlet</h1>");		 
		 
		out.print("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
