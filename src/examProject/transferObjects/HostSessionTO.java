package examProject.transferObjects;
/**
 * Transferobject for the host_sessions relation. 
 * @author Per Hedblom
 *
 */
public class HostSessionTO {
	private int session_id;
	private int host_id;
	private boolean isResponsible;
	/**
	 * Constructor.
	 * @param session_id {@link int}
	 * @param host_id {@link int}
	 * @param isResponsible {@link boolean} true if the host is responsible for the session.
	 */
	public HostSessionTO(int session_id, int host_id, boolean isResponsible) {
		this.session_id = session_id;
		this.host_id = host_id;
		this.isResponsible = isResponsible;
	}
	/**
	 * Getter for the session_id.
	 * @return {@link int}
	 */
	public int getSession_id() {
		return session_id;
	}
	/**
	 * Getter for the host_id.
	 * @return {@link int}
	 */
	public int getHost_id() {
		return host_id;
	}
	/**
	 * Getter for the isResponsible flag.
	 * @return {@link boolean} true if the host is responsible for the session.
	 */
	public boolean isResponsible() {
		return isResponsible;
	}

}
