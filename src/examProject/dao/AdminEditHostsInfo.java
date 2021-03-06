package examProject.dao;
import examProject.transferObjects.UpdateUserTransfere;


public class AdminEditHostsInfo {
	
		private UpdateUserTransfere updateUser;
		private DbManipulator dbManipulator;
		private String sqlCommand = "UPDATE hosts SET first_name ='";

		public AdminEditHostsInfo(UpdateUserTransfere updateUser,
				DbManipulator dbManipulator) {
			this.updateUser = updateUser;
			this.dbManipulator = dbManipulator;
		}

		public String AdminEditHostsInfoStrCommand(String firstName, String lastName,
				String email, String retypeEmail, String address, String city,
				String zipCode, int civic, int phoneNr, int mobilenr,
				boolean isActive, boolean is_admin) {

			String sqlCommand = "UPDATE hosts SET first_name='" + firstName
					+ "',last_name='" + lastName + "',civicnr=" + civic
					+ ",email='" + email + "',city='" + city + "',address='"
					+ address + "',zipcode=" + zipCode + ",phone_nr='" + phoneNr
					+ "',mobile_phone='" + mobilenr + "',is_active=" + isActive
					+ ";";
			return sqlCommand;

		}

		public String AdminEditHostsInfoStrCommand() {

			String sqlCommand = "UPDATE hosts SET first_name='"
					+ updateUser.getFirstName() + "', last_name='"
					+ updateUser.getLastName() + "',civicnr="
					+ updateUser.getCivic() + ",email='" + updateUser.getEmail()
					+ "',city='" + updateUser.getCity() + "',address='"
					+ updateUser.getAddress() + "',zipcode="
					+ updateUser.getZipCode() + ",phone_nr='"
					+ updateUser.getPhoneNr() + "',mobile_phone='"
					+ updateUser.getMobileNr() + ",'is_active="
					+ updateUser.isActive() + ";";

			return sqlCommand;
		}

		public String getSqlCommand() {
			return sqlCommand;
		}
	}