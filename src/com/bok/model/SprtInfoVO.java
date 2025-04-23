package com.bok.model;

public class SprtInfoVO {
	private int sprtNum;
	private String category;
	
	public SprtInfoVO(){}
	public SprtInfoVO(int sprtNum, String category) {
		setSprtNum(sprtNum);
		setCategory(category);
	}
	
	public int getSprtNum() {
		return sprtNum;
	}
	public void setSprtNum(int sprtNum) {
		this.sprtNum = sprtNum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + sprtNum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SprtInfoVO other = (SprtInfoVO) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (sprtNum != other.sprtNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SprtInfoVO [sprtNum=" + sprtNum + ", category=" + category + "]";
	}
}
