package examProject.logic;

import java.sql.ResultSet;
import examProject.dao.DbManipulator;

public class PasswordHashing {
	private CharToStringConverter conv = new CharToStringConverter();
	private DbManipulator dbm;
	
	public PasswordHashing(DbManipulator dbm){
		this.dbm = dbm;
	}
	
	public String createHashedPwd(char [] pwd) {
		String result = "";
		String sqlCommand = "SELECT crypt('" + conv.charToString(pwd) + "', gen_salt('bf', 8));";
		ResultSet rs = dbm.select(sqlCommand);
		
		
		try {
			rs.first();
			while (rs.next()) {
				result = rs.getString("crypt");
			}
			rs.close();
		} catch (Exception e) {System.out.println(e);}
		
		return result;
	}
}
