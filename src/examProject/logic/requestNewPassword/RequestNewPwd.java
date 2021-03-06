package examProject.logic.requestNewPassword;

import java.sql.ResultSet;
import java.sql.SQLException;
import examProject.dao.DbManipulator;
import examProject.dao.GetEmailAddress;
import examProject.dao.SelectUsernameWithEmail;
import examProject.logic.LogicStrategy;
import examProject.logic.PasswordHashingLocal;
import examProject.logic.mail.Mail_Interface;
import examProject.transferObjects.RequestNewPwdTO;

public class RequestNewPwd implements LogicStrategy {
	private DbManipulator dbm;
	private String input;
	private GetEmailAddress getEmailAdress = new GetEmailAddress();
	private PasswordHashingLocal hash = new PasswordHashingLocal();
	private final String EMAIL_SUBJECT = "Begäran om nytt lösenord till Tentamensvärdar";
	private String emailBody = "Du har begärt ett nytt lösenord till systemet för Tentamensvärdar.\n";
	private Mail_Interface email_eng;
	
	public RequestNewPwd(DbManipulator dbm, String input, Mail_Interface email_eng) {
		this.dbm = dbm;
		this.input = input;
		this.email_eng = email_eng;
	}
	
	private String getEmailAdress() {
		String emailAdress = "";
		ResultSet rs = dbm.select(getEmailAdress.getUserEmailAddress(input));
		try {
			while (rs.next()) {
				emailAdress = rs.getString("email");
			}
			rs.close();
		} catch (SQLException e) {}
		if (emailAdress==null)
			emailAdress = "";
		return emailAdress;
	}
	
	private String getUsernameFromEmail(String email) {
		String result = "";
		SelectUsernameWithEmail getUsername = new SelectUsernameWithEmail();
		ResultSet rs = dbm.select(getUsername.getUsername(email));
		try {
			while (rs.next()) {
				result = rs.getString("username");
			}
			rs.close();
		} catch (SQLException e) {}
		return result;
	}
	
	private boolean storeTmpPwd(RequestNewPwdTO tmpPwd) {
		boolean result = false;
		String sqlCommand = "";
		try {
			sqlCommand = "UPDATE users SET pwd = '" + hash.getSaltedHash(tmpPwd.getPassword()) + "', has_tmp_pwd = true WHERE username = '" + tmpPwd.getUsername() + "';";
		} catch (Exception e) {}
		result = dbm.update(sqlCommand);
		return result;
	}
	
	@Override
	public boolean execute() {
		boolean result = false;
		dbm.openDb();
		String emailAdress = getEmailAdress();
		if (!emailAdress.equals("")) {
			GetTmpPwd tempPassword = new GetTmpPwd(dbm);
			String tempPwd = tempPassword.getTmpPwd();
			String username = getUsernameFromEmail(emailAdress);
			RequestNewPwdTO newPwdHolder = new RequestNewPwdTO(username, tempPwd, "");
			storeTmpPwd(newPwdHolder);
			emailBody += "Användarnamn: " + username + "\nNytt lösenord: " + tempPwd;
			email_eng.send(emailAdress, emailBody, EMAIL_SUBJECT);
		}
		dbm.closeDb();
		return result;
	}
}
