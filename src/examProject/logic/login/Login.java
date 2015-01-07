package examProject.logic.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import examProject.logic.CharToStringConverter;
import examProject.logic.Password_interface;
import examProject.dao.DbManipulator;
import examProject.transferObjects.LoggedInUserTO;

public class Login {
	private DbManipulator dbm;
	private Password_interface hashingUnit;
	private CharToStringConverter conv = new CharToStringConverter();
	
	public Login(DbManipulator dbm, Password_interface hashingUnit) {
		this.dbm = dbm;
		this.hashingUnit = hashingUnit;
	}
	
	public LoggedInUserTO login(String username, char [] pwd) {
		LoggedInUserTO currentUser = null;
		dbm.openDb();
		String userPwd = "SELECT pwd FROM users WHERE username = '" + username + "';";
		ResultSet pwdRs = dbm.select(userPwd);
		String storedPwd = "";
		try {
			while (pwdRs.next()) {
				storedPwd = pwdRs.getString("pwd");
			}
		} catch (SQLException e1) {}
		try {
			if (hashingUnit.check(conv.charToString(pwd), storedPwd)) {
				String sqlCommand = "SELECT username, user_id, is_admin, has_tmp_pwd FROM users WHERE username = '" + username + "';";
				ResultSet rs = dbm.select(sqlCommand);
				try {
					while (rs.next()) {
						currentUser = new LoggedInUserTO(rs.getString("username"), rs.getInt("user_id"), rs.getBoolean("is_admin"), rs.getBoolean("has_tmp_pwd"));
					}
					sqlCommand = "SELECT host_id FROM hosts WHERE user_id = '" + currentUser.getUser_id() + "';";
					rs = dbm.select(sqlCommand);
					while (rs.next()) {
						currentUser.setHost_id(rs.getInt("host_id"));
					}
				} catch (SQLException e) {}
			}
		} catch (Exception e) {}
		return currentUser;
	}
}