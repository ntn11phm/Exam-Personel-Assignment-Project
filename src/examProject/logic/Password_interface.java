package examProject.logic;
/**
 * Interface for hashing of passwords.
 * @author Per Hedblom
 *
 */
public interface Password_interface {
	/**
	 * Generates a hashed password.
	 * @param password {@link String} 
	 * @return {@link String} the hashed password.
	 * @throws Exception
	 */
	public String getSaltedHash(String password) throws Exception;
	/**
	 * Function for validating a password.
	 * @param password {@link String}
	 * @param stored {@link String} 
	 * @return {@link boolean} true if the passwords are the same.
	 * @throws Exception
	 */
	public boolean check(String password, String stored) throws Exception;
}
