package examProject.logic.requestNewPassword;

import java.sql.ResultSet;
import java.sql.SQLException;
import examProject.dao.DbSelect;
import examProject.dao.GetEmailAddress;
import examProject.dao.SelectUsernameWithEmail;
import examProject.logic.LogicStrategy;

public class RequestNewPwd implements LogicStrategy {
	private DbSelect dbSelectExecutor;
	private String input;
	private GetEmailAddress getEmailAdress = new GetEmailAddress();
	
	public RequestNewPwd(DbSelect dbSelectExecutor, String input) {
		this.dbSelectExecutor = dbSelectExecutor;
		this.input = input;
	}
	
	private String getEmailAdress() {
		String emailAdress = "";
		ResultSet rs = dbSelectExecutor.select(getEmailAdress.getUserEmailAddress(input));
		try {
			while (rs.next()) {
				emailAdress = rs.getString(0);
			}
			rs.close();
		} catch (SQLException e) {}
		return emailAdress;
	}
	
	private String getUsernameFromEmail(String email) {
		String result = "";
		SelectUsernameWithEmail getUsername = new SelectUsernameWithEmail();
		ResultSet rs = dbSelectExecutor.select(getUsername.getUsername(email));
		try {
			while (rs.next()) {
				result = rs.getString(0);
			}
			rs.close();
		} catch (SQLException e) {}
		return result;
	}
	
	@Override
	public boolean execute() {
		boolean result = false;
		String emailAdress = getEmailAdress();
		if (!emailAdress.equals("")) {
			GetTmpPwd tempPassword = new GetTmpPwd(dbSelectExecutor);
			String tempPwd = tempPassword.getTmpPwd();
			String username = getUsernameFromEmail(emailAdress);
			RequestNewPwdHolder newPwdHolder = new RequestNewPwdHolder(username, tempPwd, "");
			//Email API goes here...
		}
		
		return result;
	}

}
