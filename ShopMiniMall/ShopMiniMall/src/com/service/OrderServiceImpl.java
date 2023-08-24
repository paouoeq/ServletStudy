package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.OrderDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

public class OrderServiceImpl implements OrderService {

	@Override
	public CartDTO cartByNum(int num) {
		CartDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			OrderDAO dao = new OrderDAO();
			dto = dao.cartByNum(session, num);
		} finally {
			session.close();
		}
		return dto;
	}

	@Override
	public MemberDTO memberByUserid(String userid) {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			OrderDAO dao = new OrderDAO();
			dto = dao.memberByUserid(session, userid);
		} finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int orderDone(OrderDTO dto, int del_num) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			OrderDAO dao = new OrderDAO();
			
		// 트랜잭션 시작
			
			// orderinfo에 저장
			n = dao.orderDone(session, dto);
			
			// cart에서 삭제
			n = dao.cartDel(session, del_num);
			
			session.commit();
			
		// 트랜잭션 종료
		}catch (Exception e) { // 둘 중 하나라도 실패하면 예외 발생
			session.rollback(); // 롤백으로 작업 모두 취소
		}finally {
			session.close();
		}
		return n;
	}	

}
