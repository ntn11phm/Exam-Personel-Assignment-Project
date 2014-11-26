package examProject.dao;

public class ValidatePwdCommand {
	private String strCommand = "SELECT pwd FROM users WHERE username='";
	
	public String validatePwd(String username) {
		return strCommand += username +"';";
	}
}
