package examProject.dao;

import examProject.logic.CharToStringConverter;

public class InsertUser {
	private CharToStringConverter conv = new CharToStringConverter();
	private String sqlCommand = "INSERT INTO users (username, pwd, is_admin,) VALUES ('";

	private String insertUserStrCommand(String username, char[] pwd, boolean is_admin) {
		sqlCommand += username + "', '";
		sqlCommand += conv.charToString(pwd)+ "', '";
		sqlCommand += is_admin + "');";

		return sqlCommand;

	}

}
