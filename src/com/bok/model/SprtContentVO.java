package com.bok.model;

public class SprtContentVO {
	private int sprtpcNum;
	private String subtitle;
	private String content;
	private int fkSprtpNum;
	
	public SprtContentVO(){}
	public SprtContentVO(int sprtpcNum, String subtitle, String content, int fkSprtpNum) {
		setSprtpcNum(sprtpcNum);
		setSubtitle(subtitle);
		setContent(content);
		setFkSprtpNum(fkSprtpNum);
	}
	
	public int getSprtpcNum() {
		return sprtpcNum;
	}
	public void setSprtpcNum(int sprtpcNum) {
		this.sprtpcNum = sprtpcNum;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFkSprtpNum() {
		return fkSprtpNum;
	}
	public void setFkSprtpNum(int fkSprtpNum) {
		this.fkSprtpNum = fkSprtpNum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + fkSprtpNum;
		result = prime * result + sprtpcNum;
		result = prime * result + ((subtitle == null) ? 0 : subtitle.hashCode());
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
		SprtContentVO other = (SprtContentVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (fkSprtpNum != other.fkSprtpNum)
			return false;
		if (sprtpcNum != other.sprtpcNum)
			return false;
		if (subtitle == null) {
			if (other.subtitle != null)
				return false;
		} else if (!subtitle.equals(other.subtitle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SprtContentVO [sprtpcNum=" + sprtpcNum + ", subtitle=" + subtitle + ", content=" + content
				+ ", fkSprtpNum=" + fkSprtpNum + "]";
	}
}
