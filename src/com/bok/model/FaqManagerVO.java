package com.bok.model;

public class FaqManagerVO {

	private int faqNum;
	private String faqTitle;
	private String faqContent;

	public FaqManagerVO() {
	}

	public FaqManagerVO(int faqNum, String faqContent) {
		setFaqNum(faqNum);
		setFaqContent(faqContent);
	}
	
	public FaqManagerVO(String faqTitle, String faqContent) {
		setFaqTitle(faqTitle);
		setFaqContent(faqContent);
	}

	public FaqManagerVO(int faqNum, String faqTitle, String faqContent) {
		setFaqNum(faqNum);
		setFaqTitle(faqTitle);
		setFaqContent(faqContent);
	}

	public int getFaqNum() {
		return faqNum;
	}

	public void setFaqNum(int faqNum) {
		this.faqNum = faqNum;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faqContent == null) ? 0 : faqContent.hashCode());
		result = prime * result + faqNum;
		result = prime * result + ((faqTitle == null) ? 0 : faqTitle.hashCode());
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
		FaqManagerVO other = (FaqManagerVO) obj;
		if (faqContent == null) {
			if (other.faqContent != null)
				return false;
		} else if (!faqContent.equals(other.faqContent))
			return false;
		if (faqNum != other.faqNum)
			return false;
		if (faqTitle == null) {
			if (other.faqTitle != null)
				return false;
		} else if (!faqTitle.equals(other.faqTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "faqNum=" + faqNum + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + "\n";
	}

}
