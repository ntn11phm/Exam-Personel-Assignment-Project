package examProject.logic;

import java.sql.ResultSet;

import examProject.dao.DbInsert;
import examProject.dao.DbSelect;

public class AddUserLogic {
	private CharToStringConverter conv = new CharToStringConverter();
	private AddUser au;
	private DbSelect dBs;
	private DbInsert dBi;

	public AddUserLogic(AddUser au, DbSelect dBs, DbInsert dBi) {
		this.au = au;
		this.dBs = dBs;
		this.dBi = dBi;
	}

	public boolean addUser() {
		boolean result = false;
		int userId = 0;
		String sqlCommand = "SELECT username FROM users WHERE username = '"
				+ au.getUserName() + "';";
		ResultSet rs = dBs.select(sqlCommand);
		try {
			if (!rs.next()) {
				sqlCommand = "INSERT INTO users (username, pwd, is_admin,) VALUES ('";
				sqlCommand += au.userName + "', '";
				sqlCommand += conv.charToString(au.pwd) + "', '";
				sqlCommand += au.isAdmin + "');";
				dBi.insert(sqlCommand);
				sqlCommand = "SELECT user_id FROM users WHERE username = '" + au.getUserName() + "';";
				ResultSet rss = dBs.select(sqlCommand);
				while (rss.next()) {
					userId = rss.getInt(0);
				}
				rss.close();

				sqlCommand = "INSERT INTO hosts (user_id, firstname, lastname) VALUES (user_id,'" + au.firstName + "', '" + au.lastName +"')";
			}

		} catch (Exception e) {

		}

		return result;
	}

}
