package com.bok.model;

public class SoloAskManagerVO {

	private String askNum;
	private String email;
	private String askPw;
	private String askTitle;
	private String soloDate;
	private int soloSecret;
	private String soloContent;
	private String soloAnswer;
	private String crewId;

	
	
	
	
	
	public SoloAskManagerVO() {
	}

	
	
	public SoloAskManagerVO(String askNum) {
		setAskNum(askNum);
	}

	public SoloAskManagerVO(String askNum, String soloAnswer, String crewId) {
		setAskNum(askNum);
		setSoloAnswer(soloAnswer);
		setCrewId(crewId);
	}

	public SoloAskManagerVO(String email, String askPw, String askTitle, int soloSecret, String soloContent) {
		setEmail(email);
		setAskPw(askPw);
		setAskTitle(askTitle);
		setSoloSecret(soloSecret);
		setSoloContent(soloContent);
	}

	public SoloAskManagerVO(String askNum, String email, String askTitle, String soloDate, String soloContent,
			String soloAnswer, String crewId) {
		setAskNum(askNum);
		setEmail(email);
		setAskTitle(askTitle);
		setSoloDate(soloDate);
		setSoloContent(soloContent);
		setSoloAnswer(soloAnswer);
		setCrewId(crewId);
	}

	public SoloAskManagerVO(String askNum, String email, String askPw, String askTitle, String soloDate, int soloSecret,
			String soloContent, String soloAnswer, String crewId) {
		setAskNum(askNum);
		setEmail(email);
		setAskPw(askPw);
		setAskTitle(askTitle);
		setSoloDate(soloDate);
		setSoloSecret(soloSecret);
		setSoloContent(soloContent);
		setSoloAnswer(soloAnswer);
		setCrewId(crewId);
	}



	public String getAskNum() {
		return askNum;
	}



	public void setAskNum(String askNum) {
		this.askNum = askNum;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAskPw() {
		return askPw;
	}



	public void setAskPw(String askPw) {
		this.askPw = askPw;
	}



	public String getAskTitle() {
		return askTitle;
	}



	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}



	public String getSoloDate() {
		return soloDate;
	}



	public void setSoloDate(String soloDate) {
		this.soloDate = soloDate;
	}



	public int getSoloSecret() {
		return soloSecret;
	}



	public void setSoloSecret(int soloSecret) {
		this.soloSecret = soloSecret;
	}



	public String getSoloContent() {
		return soloContent;
	}



	public void setSoloContent(String soloContent) {
		this.soloContent = soloContent;
	}



	public String getSoloAnswer() {
		return soloAnswer;
	}



	public void setSoloAnswer(String soloAnswer) {
		this.soloAnswer = soloAnswer;
	}



	public String getCrewId() {
		return crewId;
	}



	public void setCrewId(String crewId) {
		this.crewId = crewId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((askNum == null) ? 0 : askNum.hashCode());
		result = prime * result + ((askPw == null) ? 0 : askPw.hashCode());
		result = prime * result + ((askTitle == null) ? 0 : askTitle.hashCode());
		result = prime * result + ((crewId == null) ? 0 : crewId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((soloAnswer == null) ? 0 : soloAnswer.hashCode());
		result = prime * result + ((soloContent == null) ? 0 : soloContent.hashCode());
		result = prime * result + ((soloDate == null) ? 0 : soloDate.hashCode());
		result = prime * result + soloSecret;
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
		SoloAskManagerVO other = (SoloAskManagerVO) obj;
		if (askNum == null) {
			if (other.askNum != null)
				return false;
		} else if (!askNum.equals(other.askNum))
			return false;
		if (askPw == null) {
			if (other.askPw != null)
				return false;
		} else if (!askPw.equals(other.askPw))
			return false;
		if (askTitle == null) {
			if (other.askTitle != null)
				return false;
		} else if (!askTitle.equals(other.askTitle))
			return false;
		if (crewId == null) {
			if (other.crewId != null)
				return false;
		} else if (!crewId.equals(other.crewId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (soloAnswer == null) {
			if (other.soloAnswer != null)
				return false;
		} else if (!soloAnswer.equals(other.soloAnswer))
			return false;
		if (soloContent == null) {
			if (other.soloContent != null)
				return false;
		} else if (!soloContent.equals(other.soloContent))
			return false;
		if (soloDate == null) {
			if (other.soloDate != null)
				return false;
		} else if (!soloDate.equals(other.soloDate))
			return false;
		if (soloSecret != other.soloSecret)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "askNum= " + askNum + ", email= " + email + ", askPw= " + askPw + ", askTitle= " + askTitle
				+ ", soloDate= " + soloDate + ", soloSecret= " + soloSecret + ", soloContent= " + soloContent
				+ ", soloAnswer= " + soloAnswer + ", crewId= " + crewId + "\n";
	}

	

}
