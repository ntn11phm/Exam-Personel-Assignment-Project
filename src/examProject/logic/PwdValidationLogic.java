package examProject.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import examProject.ActiveUser;
import examProject.dao.DbSelect;
import examProject.dao.ValidatePwdCommand;

public class PwdValidationLogic implements LogicStrategy{
	private PasswordHashing passwordHashing = new PasswordHashing();
	private ActiveUser au;
	private DbSelect dbSelectExecutor;
	private char [] pwd;

	public PwdValidationLogic(ActiveUser au, DbSelect dbSelectExecutor, char [] pwd) {
		this.au = au;
		this.dbSelectExecutor = dbSelectExecutor;
		this.pwd = pwd;
	}
	
	private String getCurrentUserPwd() {
		ValidatePwdCommand vpc = new ValidatePwdCommand();
		return vpc.validatePwd(au.getUserName());
	}

	@Override
	public boolean execute() {
		boolean result = false;
		ResultSet rs = dbSelectExecutor.select(getCurrentUserPwd());
		try {
			while (rs.next()) {
				if (rs.getString(0).equals(passwordHashing.createHashedPwd(pwd)))
					result = true;
			}
			rs.close();
		} catch (SQLException e) {
		} finally {
			rs = null;
		}
		return result;
	}

}
