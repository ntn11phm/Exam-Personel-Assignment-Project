package examProject.dao;

import examProject.logic.CharToStringConverter;
import examProject.logic.Password_interface;
import examProject.transferObjects.AddUser;

public class InsertUser {
	private CharToStringConverter c = new CharToStringConverter();
	private Password_interface hash;
	private String sqlCommand = "INSERT INTO users (username, pwd, is_admin) VALUES ('";
	private AddUser au;
	
	public InsertUser(AddUser au, Password_interface hash){
		this.au = au;
		this.hash = hash;
	}

	public String insertUserStrCommand(String username, char[] pwd, boolean is_admin) {
		String sqlCommand = "INSERT INTO users (username, pwd, is_admin) VALUES ('";
		try {
			sqlCommand += username + "', '" + hash.getSaltedHash(c.charToString(pwd)) + "', '" + is_admin + "');";
		} catch (Exception e) {	}
		return sqlCommand;
	}
	
	public String insertUserStrCommand() {
		String sqlCommand = "INSERT INTO users (username, pwd, is_admin) VALUES ('";
		try {
			sqlCommand += au.getUserName() + "', '"+ hash.getSaltedHash(c.charToString(au.getPwd())) + "', "+ au.isAdmin() + ");";
		} catch (Exception e) {	}
		return sqlCommand;
	}
	
	public String getSqlCommand(){
		return sqlCommand;
	}
}
