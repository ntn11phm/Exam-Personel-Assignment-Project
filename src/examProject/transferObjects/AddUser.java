package examProject.transferObjects;
/**
 * Transferobject containing data needed to create a new user.
 * @author Magnus Eklund
 */
public class AddUser {
	private String userName;
	private String firstName;
	private String lastName;
	private char[] pwd;
	private boolean isAdmin;
	/**
	 * Constructor.
	 * @param userName {@link String}
	 * @param firstName {@link String}
	 * @param lastName {@link String}
	 * @param pwd {@link char[]}
	 * @param isAdmin {@link boolean} true if the uses needs admin-rights in the system. 
	 */
	public AddUser(String userName, String firstName, String lastName, char[] pwd, Boolean isAdmin) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pwd = pwd;
		this.isAdmin = isAdmin;
	}
	/**
	 * Getter for the username.
	 * @return {@link String} the username.
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * Getter for firstname.
	 * @return {@link String}
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Getter for lastname.
	 * @return {@link String}
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Getter for password.
	 * @return {@link char[]}
	 */
	public char[] getPwd() {
		return pwd;
	}
	/**
	 * Getter for isAdmin.
	 * @return {@link boolean}
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

}
