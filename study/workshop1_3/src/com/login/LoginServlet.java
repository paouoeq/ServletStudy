package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myLogin")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청처리
		System.out.println("LoginServlet.doGet");
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		// 응답처리
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.write("</head><body>");
		out.write("이름은 "+userid+" 이고 비밀번호는 "+passwd);
		out.write("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
