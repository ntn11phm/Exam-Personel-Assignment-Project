package examProject.dao;

import examProject.ActiveUser;
import examProject.logic.PasswordHashing;

public class GetUserID {

	private String userID = "SELECT user_id FROM hosts WHERE username='";
		
		public String getUserId(String userId) {
			this.userID = userID;
			return userID;
		}

}
/*
public class SelectUsernameWithEmail {
private String selectCommand = "SELECT username FROM users WHERE user_id=(SELECT user_id FROM hosts WHERE email='";

public String getUsername(String email) {
	return selectCommand += email + "');";
}
}*/


/*
public class ValidatePwdCommand {
private String strCommand = "SELECT pwd FROM users WHERE username='";

public String validatePwd(String username) {
	return strCommand += username +"';";
}
}


private PasswordHashing passwordHashing = new PasswordHashing(null);
	private ActiveUser au;
	private DbManipulator dbm;
	private char [] pwd;

	public PwdValidationLogic(ActiveUser au, DbManipulator dbSelectExecutor, char [] pwd) {
		this.au = au;
		this.dbm = dbSelectExecutor;
		this.pwd = pwd;
	}
	
private String getCurrentUserPwd() {
		ValidatePwdCommand vpc = new ValidatePwdCommand();
		return vpc.validatePwd(au.getUserName());
	}
*/