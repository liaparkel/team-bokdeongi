package com.bok.model;

public class CkContentVO {
	private int ckContentNum;
	private String title;
	private String content;
	private int fkCkNum;
	
	public CkContentVO(){}
	public CkContentVO(int ckContentNum, String title, String content, int fkCkNum) {
		setCkContentNum(ckContentNum);
		setTitle(title);
		setContent(content);
		setFkCkNum(fkCkNum);
	}
	
	public int getCkContentNum() {
		return ckContentNum;
	}
	public void setCkContentNum(int ckContentNum) {
		this.ckContentNum = ckContentNum;
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
	public int getFkCkNum() {
		return fkCkNum;
	}
	public void setFkCkNum(int fkCkNum) {
		this.fkCkNum = fkCkNum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ckContentNum;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + fkCkNum;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		CkContentVO other = (CkContentVO) obj;
		if (ckContentNum != other.ckContentNum)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (fkCkNum != other.fkCkNum)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CkContentVO [ckContentNum=" + ckContentNum + ", title=" + title + ", content=" + content + ", fkCkNum="
				+ fkCkNum + "]";
	}
}
