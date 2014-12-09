package examProject.logic;

import java.sql.ResultSet;

import examProject.dao.DbInsert;
import examProject.dao.DbManipulator;
import examProject.dao.DbSelect;
import examProject.dao.InsertUser;

public class AddUserLogic {
	private PasswordHashing hash = new PasswordHashing();
	private AddUser au;
//	private DbSelect dBs;
//	private DbInsert dBi;
	private DbManipulator dBm;

	public AddUserLogic(AddUser au, DbManipulator dBm) {
		this.au = au;
		this.dBm = dBm;
//		this.dBs = dBs;
//		this.dBi = dBi;
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
				InsertUser iu = new InsertUser(au);				
				dBm.insert(iu.insertUserStrCommand());
//				sqlCommand = "SELECT user_id FROM users WHERE username = '" + au.getUserName() + "';";
//				ResultSet rss = dBm.select(sqlCommand);
//				while (rss.next()) {
//					userId = rss.getInt(0);
//				}
//				rss.close();				
				sqlCommand = "INSERT INTO hosts (user_id, firstname, lastname) VALUES ((SELECT user_id FROM users WHERE username = '" + au.getUserName() + "),'" + au.firstName + "', '" + au.lastName +"')";
				dBm.insert(sqlCommand);
				//dBs.close();
				result = true;
			}
		} catch (Exception e) {} finally {
			dBm.closeDb();
		}
		return result;
	}

}
