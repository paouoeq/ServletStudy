package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {
	
	// 장바구니 추가
	public int cartAdd(SqlSession session, CartDTO dto) {
//		int n = session.insert("CartMapper.cartAdd", dto);
		return session.insert("CartMapper.cartAdd", dto);
	}
	
	// 장바구니 목록
	public List<CartDTO> cartList(SqlSession session, String userid) {
//		List<CartDTO> list = session.selectList("CartMapper.cartList", userid);
		return session.selectList("CartMapper.cartList", userid);
	}
	
	// 수량 수정
	public int cartUpdate(SqlSession session, HashMap<String,Integer> map) {
		return session.update("CartMapper.cartUpdate", map);
	}
	
	// 단일 삭제
	public int cartDelete(SqlSession session, int num) {
		return session.delete("CartMapper.cartDelete", num);
	}
}
