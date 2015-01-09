package examProject.transferObjects;
/**
 * Transferobject for requesting a new password.
 * Contains the username, a temporary password and a message to send to the user.
 * @author Per Hedblom
 *
 */
public class RequestNewPwdTO {
	private String username;
	private String password;
	private String message;
	/**
	 * Constructor.
	 * @param username {@link String}
	 * @param password {@link String}
	 * @param message {@link String}
	 */
	public RequestNewPwdTO(String username, String password, String message) {
		this.username = username;
		this.password = password;
		this.message = message;
	}
	/**
	 * Getter for the username.
	 * @return {@link String}
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Getter for the password.
	 * @return {@link String}
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Getter for the message.
	 * @return {@link String}
	 */
	public String getMessage() {
		return message;
	}
}
