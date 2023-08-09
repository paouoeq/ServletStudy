package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청URL : http://localhost:8090/01_sevlet/test2
@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
	
	int num; // 인스턴스 변수 -> 한번만 생성, 사용자간 공유 가능, thread-unsafe

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num2 = 0;// 로컬변수 -> 공유X 나혼자 사용한다, thread-safe
		
		num++;
		num2++;
		
		System.out.println("thread-unsafe : "+num);
		System.out.println("thread-safe : "+num2);
		
	}

}
