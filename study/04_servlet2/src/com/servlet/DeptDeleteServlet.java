package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.DeptDTO;
import com.service.DeptService;
import com.service.DeptServiceImpl;

@WebServlet("/delete")
public class DeptDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptno = request.getParameter("deptno");
		
		DeptService service = new DeptServiceImpl(); // 서비스 연동
		int n = service.deleteDept(Integer.parseInt(deptno)); // 서비스-DAO에 의해 삭제 이루어짐
		
		
		////////////////////// 요청위임 사용하여 바로 페이지 이동하기 //////////////////////
		if(n==1) { // 부서 삭제 성공 -> 바로 페이지 이동(DeptListServlet으로)
			response.sendRedirect("list");
		} else { // 부서 삭제 실패 -> 바로 페이지 이동(부서 정보 화면으로)
			response.sendRedirect("retrieve?deptno="+deptno);
		}
		//////////////////////////////////////////////////////////////////////
		
		

//		// 응답처리
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.write("<html><head>");
//		out.print("<meta charset=\"UTF-8\">");
//		out.print("<title>Insert title here</title>");
//		out.write("</head><body>");
//		
//		if(n==1) {
//			out.write("부서 삭제 성공<br>");
//			out.write("<a href='list'>목록보기</a>"); // 부서 삭제 성공하면 list화면으로 넘어가는 링크 생성
//		} else {
//			out.write("부서 삭제 실패<br>");
//			out.write("<a href='retrieve?deptno="+deptno+"'>다시시도</a>"); // 부서 삭제 실패하면 다시 부서 정보 화면으로 넘어가는 링크 생성
//		}
//		
//		out.write("</body></html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST 한글처리 => 나중에 필터로 구현
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
