package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {
	
	public int cartAdd(SqlSession session, CartDTO dto) {
//		int n = session.insert("CartMapper.cartAdd", dto);
		return session.insert("CartMapper.cartAdd", dto);
	}
	
	public List<CartDTO> cartList(SqlSession session, String userid) {
//		List<CartDTO> list = session.selectList("CartMapper.cartList", userid);
		return session.selectList("CartMapper.cartList", userid);
	}
}
