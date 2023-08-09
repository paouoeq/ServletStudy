package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청URL : http://localhost:8090/01_sevlet/test
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	@Override
	public void destroy() {
		System.out.println("TestServlet.destroy");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TestServlet.init");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 웹브라우저가 아닌 Tomcat 서버 콘솔에 출력됨
		System.out.println("TestServlet.doGet");
		
	}

}
