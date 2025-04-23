package com.bok.model;

public class CrewVO {
	String crewId;
	String crewPw;
	String crewName;
	
	
	
			
			
	public CrewVO() {
	}
	
	public CrewVO(String crewId, String crewPw) {
		setCrewId(crewId);
		setCrewPw(crewPw);
		
	}
	public CrewVO(String crewId, String crewPw, String crewName) {
		setCrewId(crewId);
		setCrewPw(crewPw);
		setCrewName(crewName);
	}
	public String getCrewId() {
		return crewId;
	}
	public void setCrewId(String crewId) {
		this.crewId = crewId;
	}
	public String getCrewPw() {
		return crewPw;
	}
	public void setCrewPw(String crewPw) {
		this.crewPw = crewPw;
	}
	public String getCrewName() {
		return crewName;
	}
	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crewId == null) ? 0 : crewId.hashCode());
		result = prime * result + ((crewName == null) ? 0 : crewName.hashCode());
		result = prime * result + ((crewPw == null) ? 0 : crewPw.hashCode());
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
		CrewVO other = (CrewVO) obj;
		if (crewId == null) {
			if (other.crewId != null)
				return false;
		} else if (!crewId.equals(other.crewId))
			return false;
		if (crewName == null) {
			if (other.crewName != null)
				return false;
		} else if (!crewName.equals(other.crewName))
			return false;
		if (crewPw == null) {
			if (other.crewPw != null)
				return false;
		} else if (!crewPw.equals(other.crewPw))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CrewVO [crewId=" + crewId + ", crewPw=" + crewPw + ", crewName=" + crewName + "]";
	}

	
	
}
