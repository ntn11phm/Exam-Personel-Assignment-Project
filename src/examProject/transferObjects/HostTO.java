package examProject.transferObjects;
/**
 * Transferobject for the hosts_sessions_invitations relation.
 * @author Per Hedblom
 *
 */
public class HostTO {
	private int host_id;
	private String firstName;
	private String lastName;
	private boolean isResponsible;
	/**
	 * Constructor.
	 * @param host_id {@link int}
	 * @param firstName {@link String}
	 * @param lastName {@link String}
	 */
	public HostTO(int host_id, String firstName, String lastName) {
		this(host_id, firstName, lastName, false);
	}
	/**
	 * Constructor.
	 * @param host_id {@link int}
	 * @param firstName {@link String}
	 * @param lastName {@link String}
	 * @param isResponsble {@link boolean} true if the host is responsible for the session.
	 */
	public HostTO(int host_id, String firstName, String lastName, boolean isResponsble) {
		this.host_id = host_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isResponsible = isResponsble;
	}
	/**
	 * Getter for the host id.
	 * @return {@link int}
	 */
	public int getHost_id() {
		return host_id;
	}
	/**
	 * Getter for the first name.
	 * @return {@link String}
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Getter for the last name.
	 * @return {@link String}
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Getter for the isResponsible flag.
	 * @return {@link boolean} true if the host is responsible for the session.
	 */
	public boolean isResponsible() {
		return isResponsible;
	}
	/**
	 * Prints: firstname lastname host_id
	 */
	@Override
	public String toString() {
		return "" + firstName + " " + lastName + " " + host_id;
	}
}
