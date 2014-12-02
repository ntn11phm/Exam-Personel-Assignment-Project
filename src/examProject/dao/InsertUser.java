package examProject.dao;

import examProject.logic.PasswordHashing;

public class InsertUser {
	private PasswordHashing hash = new PasswordHashing();
	private String sqlCommand = "INSERT INTO users (username, pwd, is_admin,) VALUES ('";

	public String insertUserStrCommand(String username, char[] pwd,
			boolean is_admin) {
		sqlCommand += username + "', '";
		sqlCommand += hash.createHashedPwd(pwd) + "', '";
		sqlCommand += is_admin + "');";

		return sqlCommand;

	}

}
