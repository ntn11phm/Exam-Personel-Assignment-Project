package examProject.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import examProject.dao.DbManipulator;
import examProject.dao.UpdateUsersInformation;
import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.UpdateUserTransfere;

public class AdminEditHostsInfoLogic {
	private UpdateUserTransfere updateUserTransfere;
	private DbManipulator dbManipulator;

	public AdminEditHostsInfoLogic(LoggedInUserTO currentUser,
			UpdateUserTransfere uppdateUser, DbManipulator dbManipulator) {
		this.updateUserTransfere = uppdateUser;
		this.dbManipulator = dbManipulator;
	}

	public boolean AdminEditHostsInfo() {
		dbManipulator.openDb();
		boolean result = false;
		String sqlCommand = "SELECT user_id FROM hosts WHERE first_name='"
				+ updateUserTransfere.getFirstName() + "';";
		ResultSet resultSet = dbManipulator.select(sqlCommand);
		try {
			if (!resultSet.next()) {
				UpdateUsersInformation updateUser = new UpdateUsersInformation(
						updateUserTransfere, dbManipulator);
				dbManipulator.insert(updateUser.updateUserStrCommand());

				sqlCommand = "UPDATE hosts SET first_name='"
						+ updateUserTransfere.getFirstName() + "',last_name='"
						+ updateUserTransfere.getLastName() + "',civicnr="
						+ updateUserTransfere.getCivic() + ",email='"
						+ updateUserTransfere.getEmail() + "',city='"
						+ updateUserTransfere.getCity() + "',address='"
						+ updateUserTransfere.getAddress() + "',zipcode="
						+ updateUserTransfere.getZipCode() + ",phone_nr='"
						+ updateUserTransfere.getPhoneNr() + "',mobile_phone='"
						+ updateUserTransfere.getMobileNr() + "',is_active="
						+ updateUserTransfere.isActive() + ";";
				dbManipulator.update(sqlCommand);
				result = true;
			}
		} catch (Exception e) {
		} finally {
			dbManipulator.closeDb();
		}
		return result;
	}
}