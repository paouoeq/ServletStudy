package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.OrderDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;

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

}
