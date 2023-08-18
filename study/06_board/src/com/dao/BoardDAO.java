package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {

	// 전체 목록
	public PageDTO list(SqlSession session, HashMap<String, String> map, int curPage) {
		PageDTO pageDTO = new PageDTO();
		
		// 현재 페이지 정보는 BoardListServlet이 전해줌
		int offset = (curPage-1)*pageDTO.getPerPage(); // 시작위치 -> 페이지마다 다름 -> (현재페이지-1)*페이지당 보여줄 개수
		int limit = pageDTO.getPerPage(); // 한 페이지당 레코드 보여줄 개수
		
		
		List<BoardDTO> list = session.selectList("BoardMapper.list", map, 
				new RowBounds(offset, limit));
		
		
		// PageDTO에 list, totalCount, curPage 저장해야함 //
			// list 저장
		pageDTO.setList(list);
			// curPage 저장
		pageDTO.setCurPage(curPage);
		
			// totalCount 저장 -> sql 필요
		int totalCount = 0; // 초기화
		if(map.get("searchValue") == null) {
			// 검색을 안한 경우
			totalCount = session.selectOne("BoardMapper.totalCount");
		} else {
			// 검색을 한 경우
			totalCount = session.selectOne("BoardMapper.totalCountSearch", map);
		}
		pageDTO.setTotalCount(totalCount);
		
		/* searchName과 searchValue를 PageDTO에 저장해야 함 -> 그래야 검색했을 때 페이징이 적용된다.
			searchName과 searchValue 유지를 시켜야 다른 페이지로 이동해도 검색조건이 유지가 된다.*/
		
		return pageDTO;
	}
	
	// 글저장
	public int write(SqlSession session, BoardDTO dto) {
		int n = session.insert("BoardMapper.write", dto);
		return n;
	}
	
	// 자세히보기
	public BoardDTO retrieve(SqlSession session, int num) {
		BoardDTO dto = session.selectOne("BoardMapper.retrieve", num);
		return dto;
	}
	
	// 조회수 증가
	public int readcnt(SqlSession session, int num) {
		int n = session.update("BoardMapper.readcnt", num);
		return n;
	}
	
	// 글 수정
	public int update(SqlSession session, BoardDTO dto) {
		int n = session.update("BoardMapper.update", dto);
		return n;
	}
	
	// 글 삭제
	public int delete(SqlSession session, int num) {
		int n = session.delete("BoardMapper.delete", num);
		return n;
	}
}
