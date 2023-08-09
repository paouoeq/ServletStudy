package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		 out.print("<html><head>");
		 out.print("<meta charset=\"UTF-8\">");
		 out.print("<title>Insert title here</title>");
		 out.print("</head>");
		 out.print("<body>");
		 
		 out.print("hello_s의 서블릿 실습~~~");		 
		 
		 out.print("</body></html>");
	}

}
