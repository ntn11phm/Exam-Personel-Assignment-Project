package examProject.dao;

public class InsertUser {
	private String sqlCommand = "INSERT INTO users (username, pwd, is_admin,) VALUES ('";

	private String insertUserStrCommand(String username, char[] pwd, boolean is_admin) {
		sqlCommand += username + "', '";
		sqlCommand += pwd + "', '";
		sqlCommand += is_admin + "');";

		return sqlCommand;

	}

}
