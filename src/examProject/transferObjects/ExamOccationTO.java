package examProject.transferObjects;

public class ExamOccationTO {
	private String examRoom = "";
	private String examDate = "";
	private String examStartTime = "";
	private String bookingId = "";
	private String summary = "";
	
	public ExamOccationTO() {
		
	}
	
	public ExamOccationTO(String examDate, String examStartTime, String bookingId, String examRoom, String summary) {
		this.examDate = examDate;
		this.examStartTime = examStartTime;
		this.bookingId = bookingId;
		this.examRoom = examRoom;
		this.summary = summary;
	}

	public String getExamRoom() {
		return examRoom;
	}

	public void setExamRoom(String examRoom) {
		this.examRoom = examRoom;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getExamStartTime() {
		return examStartTime;
	}

	public void setExamStartTime(String examStartTime) {
		this.examStartTime = examStartTime;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return examDate + ", " + examStartTime + ", " + examRoom;
	}
}
