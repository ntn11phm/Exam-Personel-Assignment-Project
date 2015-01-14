package examProject.dao;

import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.UpdateUserTransfere;

public class UpdateUsersInformation {

	private UpdateUserTransfere updateUser;
	@SuppressWarnings("unused")
	private DbManipulator dbManipulator;
	private String sqlCommand = "";
	@SuppressWarnings("unused")
	private LoggedInUserTO currentUser;

	public UpdateUsersInformation(UpdateUserTransfere updateUser,DbManipulator dbManipulator) {
		this.updateUser = updateUser;
		this.dbManipulator = dbManipulator;
	}

	public String updateUserStrCommand() {
		String sqlCommand = "UPDATE hosts SET first_name='"
				+ updateUser.getFirstName() + "', last_name='"
				+ updateUser.getLastName() + "',civicnr="
				+ updateUser.getCivic() + ",email='" + updateUser.getEmail()
				+ "',city='" + updateUser.getCity() + "',address='"
				+ updateUser.getAddress() + "',zipcode="
				+ updateUser.getZipCode() + ",phone_nr='"
				+ updateUser.getPhoneNr() + "',mobile_phone='"
				+ updateUser.getMobileNr() + ",'is_active="
				+ updateUser.isActive() + ",is_admin=" + ";";
		return sqlCommand;
	}

	public String getSqlCommand() {
		return sqlCommand;
	}
}