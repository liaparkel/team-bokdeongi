package com.bok.model;

public class CkVO {
	private int ckNum;
	private String category;
	private String tip;
	private String date;
	
	public CkVO(){}
	public CkVO(int ckNum, String category, String tip, String date) {
		setCkNum(ckNum);
		setCategory(category);
		setTip(tip);
		setDate(date);
	}
	
	public int getCkNum() {
		return ckNum;
	}
	public void setCkNum(int ckNum) {
		this.ckNum = ckNum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ckNum;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((tip == null) ? 0 : tip.hashCode());
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
		CkVO other = (CkVO) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (ckNum != other.ckNum)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (tip == null) {
			if (other.tip != null)
				return false;
		} else if (!tip.equals(other.tip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CkVO [ckNum=" + ckNum + ", category=" + category + ", tip=" + tip + ", date=" + date + "]";
	}
}