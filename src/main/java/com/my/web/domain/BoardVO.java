package com.my.web.domain;

import java.util.Date;

public class BoardVO {
	private int code; // 게시번호
    private String title; // 글 제목
    private String content; // 글 내용
    private String writer; // 작성자
    private Date reg_datetime; // 작성 날짜
    private int view_cnt; // 조회 수
	
    public int getCode() {
		return code;
	}
    
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Date getReg_datetime() {
		return reg_datetime;
	}
	
	public void setReg_datetime(Date reg_datetime) {
		this.reg_datetime = reg_datetime;
	}
	
	
	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	@Override
	public String toString() {
		return "BoardVO [code=" + code + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", reg_datetime=" + reg_datetime + ", view_cnt=" + view_cnt + "]";
	}	
}
