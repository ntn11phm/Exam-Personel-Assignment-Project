package examProject.dao;

public class ValidatePwdCommand {
	private String strCommand = "SELECT pwd FROM users WHERE username='";
	// SELECT (pswhash = crypt('entered password', pswhash)) AS pswmatch FROM users;
	
	public String validatePwd(String username) {
		return strCommand += username +"';";
	}
}
