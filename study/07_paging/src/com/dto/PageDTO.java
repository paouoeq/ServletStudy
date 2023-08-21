package com.dto;

import java.util.List;

public class PageDTO {
	
	// list.jsp에서 필요한 4개의 정보
	List<BoardDTO> list;
	
	int perPage = 3; // 페이지당 보여줄 레코드 개수
	int curPage; // 현재 page 번호, 맨 처음 요청시에는 1로 설정됨
	int totalCount; // 전체 레코드 수, select count(*) from board

	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
