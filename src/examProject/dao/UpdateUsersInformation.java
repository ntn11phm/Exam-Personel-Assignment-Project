package examProject.dao;

import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.UpdateUserTransfere;

public class UpdateUsersInformation {

	private UpdateUserTransfere updateUser;
	private DbManipulator dBm;
	private String sqlCommand = "";
	private LoggedInUserTO currentUser;

	public UpdateUsersInformation(UpdateUserTransfere updateUser, DbManipulator dBm) {
		this.updateUser = updateUser;
		this.dBm = dBm;
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
				+ updateUser.getMobileNr()  +",'is_active="
				+ updateUser.isActive() +",is_admin="
				+ updateUser.isAdmin()+";";
				

		return sqlCommand;

	}

	public String getSqlCommand() {
		return sqlCommand;
	}
}