package examProject.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import examProject.dao.DbSelect;

public class PasswordHashing {
	private CharToStringConverter conv = new CharToStringConverter();
	private DbSelect dbSelect;
	
	public String createHashedPwd(char [] pwd) {
		String result = "";
		String sqlCommand = "SELECT crypt('" + conv.charToString(pwd) + "', gen_salt('bf', 8));";
		ResultSet rs = dbSelect.select(sqlCommand);
		try {
			while (rs.next()) {
				result = rs.getString(0);
			}
		} catch (SQLException e) {}
		return result;
	}
}
