package com.my.web.domain;

public class Pagination {
	private PageDTO pdto; // 현재 페이지, 페이지 당 게시글 수
	private int totalCnt; // 총 게시글 수
	private int perBlock; // 블록당 페이지 수
	private int curBlock; // 현재 블록
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private int prevPage; // 이전 페이지
	private int nextPage; // 다음 페이지
	private int pageCnt; // 총 페이지 수
	private int blockCnt; // 블록 수
	
	public Pagination(PageDTO pdto) {
		this.pdto = pdto;
		this.perBlock = 10;
	}
	
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		calcPaging();
	}
	
	private void calcPaging() {
		// 총 페이지 수 계산
		this.pageCnt = (int) Math.ceil(totalCnt*1.0/ pdto.getPerPage()); // double로 계산하고 올림(math.ceil) 후 int로 캐스팅
		// 총 블록 계산
		this.blockCnt = (int) Math.ceil(pageCnt*1.0 / perBlock);
		// 현재 블록 계산
		this.curBlock = ((pdto.getPage()-1)/perBlock) + 1;
		// 시작 페이지
		startPage = (curBlock - 1) * perBlock + 1;
		// 끝 페이지
		endPage = startPage + perBlock - 1;		
		if(endPage > pageCnt) {
			this.endPage = pageCnt;
		}
		prevPage = pdto.getPage() - 1;
		nextPage = pdto.getPage() + 1;
	}

	public PageDTO getPdto() {
		return pdto;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public int getPerBlock() {
		return perBlock;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getBlockCnt() {
		return blockCnt;
	}
	
}
