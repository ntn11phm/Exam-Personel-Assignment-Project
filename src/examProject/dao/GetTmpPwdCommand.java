package examProject.dao;

public class GetTmpPwdCommand {
	private String sqlCommand = "SELECT tmp_pwd FROM temporary_password WHERE tp_id=";
	
	public String getTmpPwdSqlCommand(int tp_id) {
		return sqlCommand += tp_id + ";";
	}
}
