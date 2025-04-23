package com.bok.model;

public class SprtPersonVO {
		private int sprtpNum;
		private String title;
		private String link;
		private String summary;
		private String date;
		private String start;
		private String end;
		private int fkSprtNum;
		
		public SprtPersonVO(){}
		
		public SprtPersonVO(int sprtpNum, String title, String link, String summary, String date, String start,
				String end, int fkSprtNum) {
			setSprtpNum(sprtpNum);
			setTitle(title);
			setLink(link);
			setSummary(summary);
			setDate(date);
			setStart(start);
			setEnd(end);
			setFkSprtNum(fkSprtNum);
		}
		public int getSprtpNum() {
			return sprtpNum;
		}
		public void setSprtpNum(int sprtpNum) {
			this.sprtpNum = sprtpNum;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getStart() {
			return start;
		}
		public void setStart(String start) {
			this.start = start;
		}
		public String getEnd() {
			return end;
		}
		public void setEnd(String end) {
			this.end = end;
		}
		public int getFkSprtNum() {
			return fkSprtNum;
		}
		public void setFkSprtNum(int fkSprtNum) {
			this.fkSprtNum = fkSprtNum;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result + ((end == null) ? 0 : end.hashCode());
			result = prime * result + fkSprtNum;
			result = prime * result + ((link == null) ? 0 : link.hashCode());
			result = prime * result + sprtpNum;
			result = prime * result + ((start == null) ? 0 : start.hashCode());
			result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
			SprtPersonVO other = (SprtPersonVO) obj;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (end == null) {
				if (other.end != null)
					return false;
			} else if (!end.equals(other.end))
				return false;
			if (fkSprtNum != other.fkSprtNum)
				return false;
			if (link == null) {
				if (other.link != null)
					return false;
			} else if (!link.equals(other.link))
				return false;
			if (sprtpNum != other.sprtpNum)
				return false;
			if (start == null) {
				if (other.start != null)
					return false;
			} else if (!start.equals(other.start))
				return false;
			if (summary == null) {
				if (other.summary != null)
					return false;
			} else if (!summary.equals(other.summary))
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
			return "SprtPersonVO [sprtpNum=" + sprtpNum + ", title=" + title + ", link=" + link + ", summary=" + summary
					+ ", date=" + date + ", start=" + start + ", end=" + end + ", fkSprtNum=" + fkSprtNum + "]";
		}
		


}
