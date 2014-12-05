package examProject.dao;

import examProject.logic.AddUser;
import examProject.logic.PasswordHashing;

public class InsertUser {
	
	public InsertUser(AddUser au){
		this.au = au;
	}
	private PasswordHashing hash = new PasswordHashing();
	private String sqlCommand = "INSERT INTO users (username, pwd, is_admin,) VALUES ('";
	private AddUser au;

	public String insertUserStrCommand(String username, char[] pwd, boolean is_admin) {
		sqlCommand += username + "', '";
		sqlCommand += hash.createHashedPwd(pwd) + "', '";
		sqlCommand += is_admin + "');";

		return sqlCommand;

	}
	public String insertUserStrCommand() {
		sqlCommand += au.userName + "', '";
		sqlCommand += hash.createHashedPwd(au.getPwd()) + "', ";
		sqlCommand += au.isAdmin + ");";

		return sqlCommand;

	}
}
