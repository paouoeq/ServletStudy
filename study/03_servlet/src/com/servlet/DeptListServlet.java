package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.DeptDTO;
import com.service.DeptService;
import com.service.DeptServiceImpl;

// Dept 목록을 보여줌
// 현재 : http://localhost:8090/03_servlet/list
// 타겟 : http://localhost:8090/03_servlet/deptForm.jsp
@WebServlet("/list")
public class DeptListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService service = new DeptServiceImpl();
		List<DeptDTO> list = service.findAll();
		
		// 응답처리
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.write("</head><body>");
		
		out.write("<h1>Dept 목록</h1>");
		out.write("<table border='1'>"
				+ "<tr>"
				+ "<th>부서번호</th>"
				+ "<th>부서명</th>"
				+ "<th>위치</th>"
				+ "</tr>");
		
		// 번호를 클릭하면 누른 번호의 정보만 보이도록 만듦, 거기서 수정/삭제 작업
		// DeptRetrieveServlet으로 부서번호를 같이 넘김 -> qeuryString이용
		// qeuryString 이용 : get방식으로 사용자 입력 데이터를 넘길 때 url을 살펴보면 자동으로 쿼리스트링을 통해 넘어감. 이를 수동으로 명시해준것
		//out.print("<td><a href='retrieve?deptno="+dto.getDeptno()+"'>"+dto.getDeptno()+"</a></td>"); 따옴표가 많이 쓰였기 때문에 주의!
		for(DeptDTO dto : list) {
			out.write("<tr>"
					+ "<td><a href='retrieve?deptno="+dto.getDeptno()+"'>" +dto.getDeptno()+ "</a></td>"
					+ "<td>" +dto.getDname()+ "</td>"
					+ "<td>" +dto.getLoc()+ "</td>"
					+ "</tr>");
		}
				
		out.write("</table>");
		
		out.write("<a href='deptForm.jsp'>[부서등록]</a>"); // 상대경로
		out.write("<a href='/03_servlet/deptForm.jsp'>[부서등록]</a>"); // 절대경로
		
		out.write("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
