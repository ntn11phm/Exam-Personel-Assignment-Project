package examProject.logic;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import examProject.dao.DbManipulator;
import examProject.dao.InsertUser;
import examProject.dao.UpdateUsersInformation;
import examProject.transferObjects.UpdateUserTransfere;
import examProject.ui.addUser.AddUserGUI;

public class UpdateUserLogic {

	private UpdateUserTransfere uppdateUser;
	private DbManipulator dBm;
	
	public UpdateUserLogic(UpdateUserTransfere uppdateUser, DbManipulator dBm) {
		this.uppdateUser = uppdateUser;
		this.dBm = dBm;

	}

	public boolean uppdateUser() {
		dBm.openDb();
		boolean result = false;
		String sqlCommand = "SELECT userid FROM hosts WHERE first_name = '"
						+ uppdateUser.getFirstName() + "';";
		ResultSet rs = dBm.select(sqlCommand);
		
					
			try {
				if (!rs.next()) {
					UpdateUsersInformation updateUser = new UpdateUsersInformation(uppdateUser, dBm);			
					dBm.insert(updateUser.updateUserStrCommand());	// här vilke metod ska användas med eller utan parameter		
					sqlCommand = "UPDATE hosts SET (first_name = ' " + uppdateUser.getFirstName()+ "last-name = ' "+ uppdateUser.getLastName()+ 
					"civic = "+ uppdateUser.getCivic() +	"email = '" + uppdateUser.getEmail()+ "retypeEmail '" + uppdateUser.getRetypeEmail() + "city = '" + uppdateUser.getCity()+ "address = '" + uppdateUser.getAddress()+ "zipCode =" + uppdateUser.getZipCode() + "is_admin = " + uppdateUser.isAdmin+ "is_active =" + uppdateUser.isActive + "'";
					dBm.update(sqlCommand);
					result = true;
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}

}