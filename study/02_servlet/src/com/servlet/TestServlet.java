package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServle"+getServletName());
		System.out.println("ServletConfig=====================================");
		// ServletConfig의 getInitParameter(name) 메서드 사용
		String dir_path = getInitParameter("dir_path"); // 문자열로 param-name 넣기
		String email = getInitParameter("email"); // 문자열로 param-name 넣기
		System.out.println(dir_path+"\t"+email);
		
		
		System.out.println("ServletContext=====================================");
		// ServletContext의 getInitParaeter(name)
		ServletContext ctx = getServletContext();
		String userid = ctx.getInitParameter("userid"); // 문자열로 param-name 넣기
		String passwd = ctx.getInitParameter("passwd"); // 문자열로 param-name 넣기
		System.out.println(userid+"\t"+passwd);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
