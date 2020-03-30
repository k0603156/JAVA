package com.myweb.domain;

public class PagingVO {

	private int totalCnt;
	private Criteria cri;
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	public PagingVO() {
	}

	public PagingVO(int totalCnt, Criteria cri) {
		this.totalCnt = totalCnt;
		this.cri = cri;		
		this.endPage=(int)(Math.ceil(cri.getPageNum()/(float)cri.getAmount())*cri.getAmount());
		this.startPage=endPage-(cri.getAmount()-1);
		
		int realEndPage = (int)(Math.ceil((totalCnt*1.0)/cri.getAmount()));
		
		if(realEndPage <= this.endPage) {
			this.endPage = realEndPage;
		}
		this.prev= this.startPage >1;
		this.next= this.endPage <realEndPage;
	}
	
	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}
