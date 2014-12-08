package examProject.logic;

import java.sql.ResultSet;

import examProject.dao.DbInsert;
import examProject.dao.DbSelect;
import examProject.dao.InsertUser;

public class AddUserLogic {
	private PasswordHashing hash = new PasswordHashing();
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
			int rows = rs.getRow();
			if (rows ==0) {
				InsertUser iu = new InsertUser(au);				
				dBi.insert(iu.insertUserStrCommand());
				sqlCommand = "SELECT user_id FROM users WHERE username = '" + au.getUserName() + "';";
				ResultSet rss = dBs.select(sqlCommand);
				while (rss.next()) {
					userId = rss.getInt(0);
				}
				rss.close();				

				sqlCommand = "INSERT INTO hosts (user_id, firstname, lastname) VALUES ("+userId + ",'" + au.firstName + "', '" + au.lastName +"')";
				dBi.insert(sqlCommand);
				result = true;
			}

		} catch (Exception e) {

		}

		return result;
	}

}
