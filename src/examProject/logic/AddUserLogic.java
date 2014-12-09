package examProject.logic;

import java.sql.ResultSet;

import examProject.dao.DbManipulator;
import examProject.dao.InsertUser;

public class AddUserLogic {
	private AddUser au;
	private DbManipulator dBm;

	public AddUserLogic(AddUser au, DbManipulator dBm) {
		this.au = au;
		this.dBm = dBm;

	}

	public boolean addUser() {
		dBm.openDb();
		boolean result = false;
		int userId = 0;
		String sqlCommand = "SELECT username FROM users WHERE username = '"
				+ au.getUserName() + "';";
		ResultSet rs = dBm.select(sqlCommand);
		
		try {
			
			if (!rs.next()) {
				InsertUser iu = new InsertUser(au, dBm);			
				dBm.insert(iu.insertUserStrCommand());			
				sqlCommand = "INSERT INTO hosts (user_id, firstname, lastname) VALUES ((SELECT user_id FROM users WHERE username = '" + au.getUserName() + "'),'" + au.firstName + "', '" + au.lastName +"');";
				dBm.insert(sqlCommand);
				result = true;
			}
		} catch (Exception e) {} finally {
			dBm.closeDb();
		}
		return result;
	}

}
//sqlCommand = "SELECT user_id FROM users WHERE username = '" + au.getUserName() + "';";
//ResultSet rss = dBm.select(sqlCommand);
//while (rss.next()) {
//	userId = rss.getInt(0);
//}
//rss.close();	
