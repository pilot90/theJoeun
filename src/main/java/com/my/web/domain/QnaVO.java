package com.my.web.domain;

public class QnaVO extends BoardVO {
	private int group;
	private int seq;
	private int level;
	private int replycnt;
	
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	
	@Override
	public String toString() {
		return "QnaVO [" + super.toString() 
			+ " group=" + group + ", seq=" + seq 
			+ ", level=" + level + ", replycnt" + replycnt + "]";
	}
	
}
