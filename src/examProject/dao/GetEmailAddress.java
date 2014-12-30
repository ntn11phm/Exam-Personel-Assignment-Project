package examProject.dao;

public class GetEmailAddress {
	private String strCommand = "SELECT email FROM users, hosts WHERE username='";
	
	public String getUserEmailAddress(String usernameOrEmail) {
		strCommand += usernameOrEmail + "'  AND hosts.user_id = users.user_id OR email='" + usernameOrEmail + "' AND hosts.user_id = users.user_id;";
		return strCommand;
	}

}
