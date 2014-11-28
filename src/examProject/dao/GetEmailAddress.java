package examProject.dao;

public class GetEmailAddress {
	private String strCommand = "SELECT email FROM users, hosts WHERE username='";
	
	public String getUserEmailAddress(String usernameOrEmail) {
		strCommand += usernameOrEmail + "' OR email='" + usernameOrEmail + "';";
		return strCommand;
	}

}
