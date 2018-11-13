package com.my.web.domain;

public class PageDTO {
	private int page;    // 현재 페이지 번호
	private int perPage; // 페이지 당 게시글 수
	
	public PageDTO() {
		this.page = 1;
		this.perPage = 10;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page <= 0 ? 1 : page;
	}
	
	public int getPerPage() {
		return perPage;
	}
	
	public void setPerPage(int perPage) {
		this.perPage = perPage <= 0 ? 10 : perPage;
	}
	
	public int getStartNum() {
		return (page - 1) * perPage;
	}
	
}
