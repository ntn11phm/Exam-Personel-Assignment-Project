package examProject.transferObjects;
/**
 * Transferobject containing stored data about the user.
 * @author Per Hedblom
 */
public class LoggedInUserTO {
	private String username;
	private boolean is_admin;
	private int user_id;
	private boolean has_tmp_pwd;
	private int host_id;
	/**
	 * Constructor.
	 * @param username {@link String}
	 * @param user_id {@link int} the key identifying the user in the users relation.
	 * @param is_admin {@link boolean} true if the uses needs admin-rights in the system.
	 * @param has_tmp_pwd {@link boolean} true if the uses has used the "request new password"-function or just has been created.
	 */
	public LoggedInUserTO(String username, int user_id, boolean is_admin, boolean has_tmp_pwd) {
		this.username = username;
		this.has_tmp_pwd = has_tmp_pwd;
		this.is_admin = is_admin;
		this.user_id = user_id;
	}
	/**
	 * Getter for the username.
	 * @return {@link String}
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Getter for the flag if the uses has admin-rights in the system.
	 * @return {@link boolean}
	 */
	public boolean isIs_admin() {
		return is_admin;
	}
	/**
	 * Getter for the key identifying the user in the users relation.
	 * @return {@link int}
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * Getter for the flag if the uses has used the "request new password"-function or just has been created.
	 * Should be used to force the user to change password when logging in to the system.
	 * @return {@link boolean}
	 */
	public boolean isHas_tmp_pwd() {
		return has_tmp_pwd;
	}
	/**
	 * Getter for the key identifying the user in the hosts relation.
	 * @return {@link int}
	 */
	public int getHost_id() {
		return host_id; 
	}
	/**
	 * Setter for the key identifying the user in the hosts relation.
	 * @param host_id {@link int}
	 */
	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}
}
