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

public class TestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("TestServlet");
		
		// 응답처리
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("<html><head>");
				out.print("<meta charset=\"UTF-8\">");
				out.print("<title>Insert title here</title>");
				out.write("</head><body>");
				
				out.write("<h1>TestServlet</h1>");
				
				out.write("</body></html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
