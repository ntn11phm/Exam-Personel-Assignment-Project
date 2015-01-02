package examProject.logic.requestNewPassword;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import examProject.dao.DbManipulator;
import examProject.dao.GetTmpPwdCommand;

public class GetTmpPwd {
	private DbManipulator dbm;
	
	public GetTmpPwd(DbManipulator dbm) {
		this.dbm = dbm;
	}
	
	private int getNoOfTmpPasswords() {
		int result = 0;
		String selectCommand = "SELECT MAX(tp_id) FROM temporary_passwords";
		ResultSet rs = dbm.select(selectCommand);
		try {
			while (rs.next())
				result = rs.getInt("max");
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
			ResultSet rs = dbm.select(sqlCommand);
			try {
				while (rs.next()) {
					result = rs.getString("tmp_pwd");
				}
				rs.close();
			} catch (SQLException e) {}
		}
		return result;
	}
}
