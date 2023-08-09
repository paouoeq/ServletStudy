package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청URL : http://localhost:8090/01_sevlet/login
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식 http://localhost:8090/01_servlet/login?userid=aaa&passwd=1234
		System.out.println("LoginServlet.doGet");
		
		// 사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String xxx = request.getParameter("addr"); // 없는 name -> null
		
		System.out.println("userid : "+userid+", passwd : "+passwd+", addr : "+xxx);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식 http://localhost:8090/01_servlet/login
		System.out.println("LoginServlet.doPost");
		
		// post 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String xxx = request.getParameter("addr"); // 없는 name -> null
		
		System.out.println("userid : "+userid+", passwd : "+passwd+", addr : "+xxx);
	}

}
