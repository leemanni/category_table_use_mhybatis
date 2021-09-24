package com.leemanni.vo;
/**
 * @author cjffy
 *	메인 서브 상관 없이 카테고리에 관한 데이터 1건을 기억하는 클래스
 */
public class CategoryVO {
	
	private int idx; // 카테고리 일련번호
	private String category; // 카테고리 이름
	private int gup; // 카테고리 그룹(레퍼런스)
	private int lev; // 카테고리 레벨
	private int seq; // 같은 카테고리 그룹 내에서 카테고리 출력 순서

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getGup() {
		return gup;
	}

	public void setGup(int gup) {
		this.gup = gup;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "CategoryVO [idx=" + idx + ", category=" + category + ", gup=" + gup + ", lev=" + lev + ", seq=" + seq
				+ "]";
	}
}