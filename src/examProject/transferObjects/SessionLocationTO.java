package examProject.transferObjects;
/**
 * Transferobject for sessions to use when populating the sessions.
 * @author Per Hedblom
 *
 */
public class SessionLocationTO {
	private String location;
	private int session_id;
	private String date;
	private String time;
	/**
	 * Constructor.
	 * @param location {@link String}
	 * @param session_id {@link int}
	 * @param date {@link String} use dateformat: yyyy-MM-dd.
	 * @param time {@link String} valid values: "08:00" or "15:00".
	 */
	public SessionLocationTO(String location, int session_id, String date, String time) {
		this.location = location;
		this.session_id = session_id;
		this.date = date;
		this.time = time;
	}
	/**
	 * Getter for the location. 
	 * @return {@link String}
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * Getter for the session id.
	 * @return {@link int}
	 */
	public int getSession_id() {
		return session_id;
	}
	/**
	 * Getter for the date.
	 * @return {@link String}
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
	 * Prints: location
	 */
	@Override
	public String toString() {
		return "" + location;
	}
}
