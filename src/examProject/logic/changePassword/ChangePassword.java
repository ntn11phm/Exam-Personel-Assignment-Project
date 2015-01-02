package examProject.logic.changePassword;

import examProject.dao.DbManipulator;
import examProject.logic.CharToStringConverter;
import examProject.logic.PasswordHashingLocal;

public class ChangePassword {
	private DbManipulator dbm;
	private PasswordHashingLocal hashingUnit = new PasswordHashingLocal();
	private CharToStringConverter conv = new CharToStringConverter();
	
	public ChangePassword(DbManipulator dbm) {
		this.dbm = dbm;
	}
	
	public boolean changePassword(String username, char [] pwd) {
		boolean result = false;
		dbm.openDb();
		try {
			String sqlCommand = "UPDATE users SET has_tmp_pwd = false, pwd='" + hashingUnit.getSaltedHash(conv.charToString(pwd)) + "' WHERE username ='" + username + "';";
			result = dbm.update(sqlCommand);
		} catch (Exception e) {}
		dbm.closeDb();
		return result;
	}
}
