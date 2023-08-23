package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {
	// 카테고리에 해당하는 상품목록 모두 출력
	public List<GoodsDTO> goodsList(SqlSession session, String gCategory) {
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsList", gCategory);
		return list;
	}
	
	// 상품 자세히 보기
	public GoodsDTO goodsRetrieve(SqlSession session, String gCode) {
		GoodsDTO dto = session.selectOne("GoodsMapper.goodsRetrieve", gCode);
		return dto;
	}
}
