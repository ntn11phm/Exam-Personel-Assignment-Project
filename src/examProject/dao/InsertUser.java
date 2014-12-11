package examProject.dao;

import examProject.logic.CharToStringConverter;
import examProject.logic.PasswordHashingLocal;
import examProject.transferObjects.AddUser;

public class InsertUser {
	private CharToStringConverter c = new CharToStringConverter();
	
	public InsertUser(AddUser au, DbManipulator dBm){
		this.au = au;
		this.dBm = dBm;
		hash = new PasswordHashingLocal();
		
		
	}
	private PasswordHashingLocal hash;
	private String sqlCommand = "INSERT INTO users (username, pwd, is_admin) VALUES ('";
	private AddUser au;
	private DbManipulator dBm;

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
			sqlCommand += au.userName + "', '"+ hash.getSaltedHash(c.charToString(au.pwd)) + "', "+ au.isAdmin + ");";
		} catch (Exception e) {	}

		return sqlCommand;

	}
	
	public String getSqlCommand(){
		return sqlCommand;
	}
}
