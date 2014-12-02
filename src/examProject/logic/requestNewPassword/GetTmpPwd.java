package examProject.logic.requestNewPassword;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import examProject.dao.DbSelect;
import examProject.dao.GetTmpPwdCommand;

public class GetTmpPwd {
	private DbSelect dbSelectExecutor;
	
	public GetTmpPwd(DbSelect dbSelectExecutor) {
		this.dbSelectExecutor = dbSelectExecutor;
	}
	
	private int getNoOfTmpPasswords() {
		int result = 0;
		String selectCommand = "SELECT MAX(tp_id) FROM temporary_password";
		ResultSet rs = dbSelectExecutor.select(selectCommand);
		try {
			while (rs.next())
				result = rs.getInt(0);
			rs.close();
		} catch (SQLException e) {}
		return result;
	}
	
	public String getTmpPwd() {
		String result = "";
		int seeder = getNoOfTmpPasswords();
		if (seeder > 0) {
			Random rand = new Random();
			int randomNumber = rand.nextInt(seeder + 1);
			GetTmpPwdCommand getTmpPwdCommand = new GetTmpPwdCommand();
			String sqlCommand = getTmpPwdCommand.getTmpPwdSqlCommand(randomNumber);
			ResultSet rs = dbSelectExecutor.select(sqlCommand);
			try {
				while (rs.next()) {
					result = rs.getString(0);
				}
				rs.close();
			} catch (SQLException e) {}
		}
		return result;
	}
}
