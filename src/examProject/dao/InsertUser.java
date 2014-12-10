package examProject.dao;

import examProject.logic.PasswordHashing;
import examProject.transferObjects.AddUser;

public class InsertUser {
	
	public InsertUser(AddUser au, DbManipulator dBm){
		this.au = au;
		this.dBm = dBm;
		hash = new PasswordHashing(dBm);
	}
	private PasswordHashing hash;
	private String sqlCommand = "INSERT INTO users (username, pwd, is_admin) VALUES ('";
	private AddUser au;
	private DbManipulator dBm;

	public String insertUserStrCommand(String username, char[] pwd, boolean is_admin) {
		String sqlCommand = "INSERT INTO users (username, pwd, is_admin) VALUES ('";
		sqlCommand += username + "', '" + hash.createHashedPwd(pwd) + "', '" + is_admin + "');";

		return sqlCommand;

	}
	public String insertUserStrCommand() {
		String sqlCommand = "INSERT INTO users (username, pwd, is_admin) VALUES ('";
		sqlCommand += au.userName + "', '"+ hash.createHashedPwd(au.getPwd()) + "', "+ au.isAdmin + ");";

		return sqlCommand;

	}
	
	public String getSqlCommand(){
		return sqlCommand;
	}
}
