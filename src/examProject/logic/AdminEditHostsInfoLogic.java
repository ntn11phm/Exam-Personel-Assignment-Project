package examProject.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import examProject.dao.DbManipulator;
import examProject.dao.UpdateUsersInformation;
import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.UpdateUserTransfere;

public class AdminEditHostsInfoLogic {
	private UpdateUserTransfere uppdateUser;
	private DbManipulator dBm;

	public AdminEditHostsInfoLogic(LoggedInUserTO currentUser,
			UpdateUserTransfere uppdateUser, DbManipulator dBm) {
		this.uppdateUser = uppdateUser;
		this.dBm = dBm;

	}

	public boolean AdminEditHostsInfo() {
		dBm.openDb();
		boolean result = false;
		String sqlCommand = "SELECT user_id FROM hosts WHERE first_name='"
				+ uppdateUser.getFirstName() + "';";
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
						+ uppdateUser.isActive() + ";";

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
