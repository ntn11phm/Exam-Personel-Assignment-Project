package examProject.logic;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import examProject.dao.DbManipulator;
import examProject.dao.InsertUser;
import examProject.transferObjects.AddUser;
import examProject.ui.addUser.AddUserGUI;

public class AddUserLogic {
	private AddUser au;
	private DbManipulator dBm;
	private Password_interface hash;

	public AddUserLogic(AddUser au, DbManipulator dBm, Password_interface hash) {
		this.au = au;
		this.dBm = dBm;
		this.hash = hash;
	}

	public boolean addUser() {
		dBm.openDb();
		boolean result = false;
		String sqlCommand = "SELECT username FROM users WHERE username = '"
				+ au.getUserName() + "';";
		ResultSet rs = dBm.select(sqlCommand);
		
		try {
			
			if (!rs.next()) {
				InsertUser iu = new InsertUser(au, hash);			
				dBm.insert(iu.insertUserStrCommand());			
				sqlCommand = "INSERT INTO hosts (user_id, first_name, last_name) VALUES ((SELECT user_id FROM users WHERE username = '" + au.getUserName() + "'),'" + au.firstName + "', '" + au.lastName +"');";
				dBm.insert(sqlCommand);
				result = true;
			}else {
				JOptionPane.showMessageDialog(null, "Användarnamnet är upptaget!");
				AddUserGUI.getUserNameText().setText("");
			}
		} catch (Exception e) {} finally {
			dBm.closeDb();
		}
		return result;
	}

}

