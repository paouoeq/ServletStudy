package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	// id 중복체크
	public MemberDTO idCheck(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.idCheck", userid);
		return dto;
	}
	
	// 회원가입
	public int memberAdd(SqlSession session, MemberDTO dto) {
		int n = session.insert("MemberMapper.memberAdd", dto);
		return n;
	}
	
	// 로그인
	public MemberDTO login(SqlSession session, HashMap<String,String> map) {
		MemberDTO dto = session.selectOne("MemberMapper.login", map);
		return dto;
	}
	
	// 마이페이지 - id에 해당하는 유저 정보 반환
	public MemberDTO mypage(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.mypage", userid);
		return dto;
	}
}
