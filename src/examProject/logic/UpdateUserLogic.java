package examProject.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import examProject.dao.DbManipulator;
import examProject.dao.UpdateUsersInformation;
import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.UpdateUserTransfere;

public class UpdateUserLogic {
	private UpdateUserTransfere uppdateUser;
	private DbManipulator dBm;

	public UpdateUserLogic(LoggedInUserTO currentUser,
			UpdateUserTransfere uppdateUser, DbManipulator dBm) {
		this.uppdateUser = uppdateUser;
		this.dBm = dBm;

	}

	public boolean uppdateUser() {
		dBm.openDb();
		boolean result = false;
		System.out.println("Here " + uppdateUser.getFirstName());
		System.out.println("Here " + uppdateUser.getLastName());
		System.out.println("Here " + uppdateUser.getEmail());
		System.out.println("Here " + uppdateUser.getRetypeEmail());
		System.out.println("Here " + uppdateUser.getCivic());
		

		String sqlCommand = "SELECT user_id FROM hosts WHERE first_name = '"
				+ uppdateUser.getFirstName() + "';";
		ResultSet rs = dBm.select(sqlCommand);

		try {
			if (!rs.next()) {
				UpdateUsersInformation updateUser = new UpdateUsersInformation(
						uppdateUser, dBm);
				dBm.insert(updateUser.updateUserStrCommand());
				System.out.println("sosos " + updateUser);

				sqlCommand = "UPDATE hosts SET first_name='"
						+ uppdateUser.getFirstName() + "', last_name ='"
						+ uppdateUser.getLastName() + "', civicnr="
						+ uppdateUser.getCivic() + ", email='"
						/*+ uppdateUser.getEmail() + "', retypeEmail='"*/
						+ uppdateUser.getRetypeEmail() + "', city='"
						+ uppdateUser.getCity() + "', address='"
						+ uppdateUser.getAddress() + "', zipcode="
						+ uppdateUser.getZipCode() + /*"', is_admin="
						+ uppdateUser.isAdmin + "', is_active ="
						+ uppdateUser.isActive +*/ ";";
				dBm.update(sqlCommand);
				result = true;
			}
		} catch (Exception e) {
		} finally {
			dBm.closeDb();
		}
		return result;
	}

}