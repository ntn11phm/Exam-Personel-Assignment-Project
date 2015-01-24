package examProject.transferObjects;
/**
 * Transferobject containing the data for the exam_occations relation.
 * @author Per Hedblom
 */
public class ExamOccationTO {
	private String examRoom = "";
	private String examDate = "";
	private String examStartTime = "";
	private String bookingId = "";
	private String summary = "";
	/**
	 * Empty constructor.
	 */
	public ExamOccationTO() {
	}
	/**
	 * Constructor.
	 * @param examDate {@link String} use dateformat: yyyy-MM-dd.
	 * @param examStartTime {@link String} valid values: "08:00" or "15:00".
	 * @param bookingId {@link String}
	 * @param examRoom {@link String}
	 * @param summary {@link String}
	 */
	public ExamOccationTO(String examDate, String examStartTime, String bookingId, String examRoom, String summary) {
		this.examDate = examDate;
		this.examStartTime = examStartTime;
		this.bookingId = bookingId;
		this.examRoom = examRoom;
		this.summary = summary;
	}
	/**
	 * Getter for the exam room.
	 * @return {@link String}
	 */
	public String getExamRoom() {
		return examRoom;
	}
	/**
	 * Setter for the exam room.
	 * @param examRoom {@link String}
	 */
	public void setExamRoom(String examRoom) {
		this.examRoom = examRoom;
	}
	/**
	 * Getter for the summary.
	 * @return {@link String}
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * Setter for the summary.
	 * @param summary {@link String}
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * Getter for the exan date.
	 * @return {@link String}
	 */
	public String getExamDate() {
		return examDate;
	}
	/**
	 * Setter for the exam date
	 * @param examDate {@link String} use dateformat: yyyy-MM-dd.
	 */
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	/**
	 * Getter for the exam start time.
	 * @return {@link String}
	 */
	public String getExamStartTime() {
		return examStartTime;
	}
	/**
	 * Setter for the exam start time
	 * @param examStartTime {@link String} valid values: "08:00" or "15:00".
	 */
	public void setExamStartTime(String examStartTime) {
		this.examStartTime = examStartTime;
	}
	/**
	 * Getter for the booking id.
	 * @return {@link String}
	 */
	public String getBookingId() {
		return bookingId;
	}
	/**
	 * Setter for the booking id.
	 * @param bookingId {@link String}
	 */
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * Prints: date, start time, room
	 */
	@Override
	public String toString() {
		return examDate + ", " + examStartTime + ", " + examRoom;
	}
}
