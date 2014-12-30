package examProject.logic;

import java.sql.ResultSet;
import examProject.dao.DbManipulator;
import examProject.dao.UpdateUsersInformation;
import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.UpdateUserTransfere;

public class UpdateUserLogic {
	private UpdateUserTransfere uppdateUser;
	private DbManipulator dBm;
	private LoggedInUserTO currentUser;

	public UpdateUserLogic(LoggedInUserTO currentUser,
			UpdateUserTransfere uppdateUser, DbManipulator dBm) {
		this.uppdateUser = uppdateUser;
		this.dBm = dBm;

	}

	public boolean uppdateUser() {
		dBm.openDb();
		boolean result = false;
		String sqlCommand = "SELECT user_id FROM hosts WHERE first_name='" + uppdateUser.getFirstName() + "';";
		ResultSet rs = dBm.select(sqlCommand);

		try {
			if (!rs.next()) {
				UpdateUsersInformation updateUser = new UpdateUsersInformation(
						uppdateUser, dBm);
				dBm.insert(updateUser.updateUserStrCommand());

				sqlCommand = "UPDATE hosts SET first_name='"
						+ uppdateUser.getFirstName() + "',last_name='"
						+ uppdateUser.getLastName() + "',civicnr="
						+ uppdateUser.getCivic() + ",email='"
						+ uppdateUser.getEmail() + "',city='"
						+ uppdateUser.getCity() + "',address='"
						+ uppdateUser.getAddress() + "',zipcode="
						+ uppdateUser.getZipCode() + ",phone_nr='"
						+ uppdateUser.getPhoneNr() + "',mobile_phone='"
						+ uppdateUser.getMobileNr() + "',is_active="
						+ uppdateUser.isActive() + " WHERE host_id=" + currentUser.getHost_id() + ";";

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