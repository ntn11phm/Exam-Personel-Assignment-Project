package examProject.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import examProject.dao.DbManipulator;
import examProject.dao.UpdateUsersInformation;
import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.UpdateUserTransfere;

public class UpdateUserLogic {
	private UpdateUserTransfere updateUserTransfere;
	private DbManipulator dbManipulator;
	private LoggedInUserTO currentUser;
	Statement updateStatment = null;

	public UpdateUserLogic(LoggedInUserTO currentUser, UpdateUserTransfere updateUserTransfere, DbManipulator dbManipulator) {
		this.updateUserTransfere = updateUserTransfere;
		this.currentUser = currentUser;
		this.dbManipulator = dbManipulator;
		getLogginUserData();
	}
	
	public UpdateUserTransfere getLogginUserData() {
		UpdateUserTransfere storedUserdata = null;
		dbManipulator.openDb();
		String sqlCommand = "SELECT first_name, last_name, civicnr, address, zipcode, city, phone_nr, mobile_phone, email, is_active FROM hosts WHERE host_id =" + currentUser.getHost_id() + ";";

		ResultSet resultSet = dbManipulator.select(sqlCommand);
		try {
			while (resultSet.next())
				storedUserdata = new UpdateUserTransfere(resultSet.getString("first_name"), resultSet.getString("last_name"),
						resultSet.getString("email"), resultSet.getString("email"), resultSet.getString("city"),
						resultSet.getString("address"), resultSet.getString("mobile_phone"), resultSet.getString("phone_nr"),
						resultSet.getString("zipcode"), resultSet.getString("civicnr"),resultSet.getBoolean("is_active"),  currentUser.isIs_admin());
		} catch (SQLException e) {}
		dbManipulator.closeDb();
		return storedUserdata;
	}

	public boolean uppdateUser() {
		dbManipulator.openDb();
		boolean result = false;
		String sqlCommand = "SELECT user_id FROM hosts WHERE host_id=" + currentUser.getHost_id() + ";";
		ResultSet resultSet = dbManipulator.select(sqlCommand);
		try {
			if (resultSet.next()) {
				UpdateUsersInformation updateUser = new UpdateUsersInformation(updateUserTransfere, dbManipulator);
				dbManipulator.update(updateUser.getSqlCommand());

				sqlCommand = "UPDATE hosts SET first_name='"
						+ updateUserTransfere.getFirstName() + "',last_name='"
						+ updateUserTransfere.getLastName() + "',civicnr='"
						+ updateUserTransfere.getCivic() + "',email='"
						+ updateUserTransfere.getEmail() + "',city='"
						+ updateUserTransfere.getCity() + "',address='"
						+ updateUserTransfere.getAddress() + "',zipcode='"
						+ updateUserTransfere.getZipCode() + "',phone_nr='"
						+ updateUserTransfere.getPhoneNr() + "',mobile_phone='"
						+ updateUserTransfere.getMobileNr() + "',is_active="
						+ updateUserTransfere.isActive()  +" WHERE host_id=" 
						+ currentUser.getHost_id()  +";";
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