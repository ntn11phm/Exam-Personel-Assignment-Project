package examProject.transferObjects;
/**
 * Transferobject for answering to invitations. 
 * @author Per Hedblom
 * @author Magnus Eklund
 */
public class HsiTO {
	private String date;
	private String time;
	private boolean answer;
	/**
	 * Constructor.
	 * @param date {@link String} use dateformat: yyyy-MM-dd.
	 * @param time {@link String} valid values: "08:00" or "15:00".
	 */
	public HsiTO(String date, String time) {
		this(date, time, false);
	}
	/**
	 * Constructor.
	 * @param date {@link String} use dateformat: yyyy-MM-dd.
	 * @param time {@link String} valid values: "08:00" or "15:00".
	 * @param answer {@link boolean} true if the host can work the given date and time.
	 */
	public HsiTO(String date, String time, boolean answer) {
		this.date = date;
		this.time = time;
		this.answer = answer;
	}
	/**
	 * Getter for the date.
	 * @return {@link String} use dateformat: yyyy-MM-dd.
	 */
	public String getDate() {
		return date;
	}
	/**
	 * Getter for the time.
	 * @return {@link String} valid values: "08:00" or "15:00".
	 */
	public String getTime() {
		return time;
	}
	/**
	 * Getter for the answer.
	 * @return true if the host can work the given date and time.
	 */
	public boolean getAnswer() {
		return answer;
	}
	/**
	 * Prints: date   time
	 */
	@Override
	public String toString() {
		return "" + date + "   "+ time;
	}
}
