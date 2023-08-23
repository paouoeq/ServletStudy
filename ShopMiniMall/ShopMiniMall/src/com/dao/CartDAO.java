package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {
	
	public int cartAdd(SqlSession session, CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}
}
