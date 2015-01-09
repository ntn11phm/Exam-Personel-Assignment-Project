package examProject.transferObjects;
/**
 * Traanferobject for updating or reading user-information.
 * @author Silvana Yacob
 *
 */
public class UpdateUserTransfere {
	private String firstName;
	private String lastName;
	private String civic;
	private String email;
	private String retypeEmail;
	private String city;
	private String Address;
	private String zipCode;
	private String mobileNr;
	private String phoneNr;
	private boolean isAdmin;
	private boolean isActive;
	/**
	 * Constructor.
	 * @param firstName {@link String}
	 * @param lastName {@link String}
	 * @param email {@link String}
	 * @param retypeEmail {@link String}
	 * @param city {@link String}
	 * @param address {@link String}
	 * @param mobileNr {@link String}
	 * @param phoneNr {@link String}
	 * @param zipCode {@link String}
	 * @param civic {@link String}
	 * @param isActive {@link boolean} true if the user is an active host and should receive invitations to sessions.
	 * @param isAdmin {@link boolean} true if the uses needs admin-rights in the system.
	 */
	public UpdateUserTransfere(String firstName, String lastName, String email, String retypeEmail, String city, String address, String mobileNr, String phoneNr, String zipCode, String civic, boolean isActive, boolean isAdmin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.civic = civic;
		this.email = email;
		this.Address = address;
		this.retypeEmail = retypeEmail;
		this.city = city;
		this.zipCode = zipCode;
		this.mobileNr = mobileNr;
		this.phoneNr= phoneNr;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
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
	 * Getter for the civic number.
	 * @return {@link String}
	 */
	public String getCivic() {
		return civic;
	}		
	/**
	 * Getter for the email address.
	 * @return {@link String}
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Getter for the email address.
	 * @return {@link String}
	 */
	public String getRetypeEmail() {
		return retypeEmail;
	}
	/**
	 * Getter for the city.
	 * @return {@link String}
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Getter for the address.
	 * @return {@link String}
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * Getter for the zip code.
	 * @return {@link String}
	 */
	public String getZipCode(){
		return zipCode;
	}
	/**
	 * Getter for the mobile phonenumber.
	 * @return {@link String}
	 */
	public String getMobileNr() {
		return mobileNr;
	}
	/**
	 * Getter for the phonenumber.
	 * @return {@link String}
	 */
	public String getPhoneNr() {
		return phoneNr;
	}
	/**
	 * Getter for the isAdmin flag.
	 * @return {@link boolean} true if the uses needs admin-rights in the system.
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	/**
	 * Getter for the isActive flag.
	 * @return {@link boolean} true if the user is an active host and should receive invitations to sessions.
	 */
	public boolean isActive() {
		return isActive;
	}
}
