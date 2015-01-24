package examProject.transferObjects;
/**
 * Contains data that shows which hosts are appointed to a given session.
 * @author Per Hedblom
 */
public class HostSessionDataTO implements Comparable<HostSessionDataTO>{
	private String date;
	private String time;
	private String location;
	private String lastname;
	private String firstname;
	private boolean isResponsible;
	/**
	 * Constructor.
	 * @param date {@link String} use dateformat: yyyy-MM-dd.
	 * @param time {@link String} valid values: "08:00" or "15:00".
	 * @param location {@link String}
	 * @param firstname {@link String}
	 * @param lastname {@link String}
	 * @param isResponsible {@link boolean} true if the host is responsible for the session.
	 */
	public HostSessionDataTO(String date, String time, String location, String firstname, String lastname, boolean isResponsible) {
		this.date = date;
		this.time = time;
		this.location = location;
		this.firstname = firstname;
		this.lastname = lastname;
		this.isResponsible = isResponsible;
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
	 * Getter for the location. 
	 * @return {@link String}
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * Getter for the last name.
	 * @return {@link String}
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * Getter for the first name.
	 * @return {@link String}
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Getter for the isResponsible flag.
	 * @return {@link boolean} true if the host is responsible for the session.
	 */
	public boolean isResponsible() {
		return isResponsible;
	}
	/**
	 * Compares date, time and location.
	 * @return 0 if date, time and location are equal, 1 if not.
	 */
	@Override
	public int compareTo(HostSessionDataTO other) {
		int result = -1;
		if (this.date.equals(other.date) && this.time.equals(other.time) && this.location.equals(other.location))
			result = 0;
		else
			result = 1;
		return result;
	}


}
