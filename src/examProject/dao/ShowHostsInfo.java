package examProject.dao;

import examProject.transferObjects.UpdateUserTransfere;

public class ShowHostsInfo {



		private UpdateUserTransfere updateUser;
		private DbManipulator dBm;
		private String sqlCommand = "SELECT first_name, last_name, email, mobil_phone, phone_nr FROM hosts; ";

		public ShowHostsInfo(UpdateUserTransfere updateUser, DbManipulator dBm) {
			this.updateUser = updateUser;
			this.dBm = dBm;
		}

		public String ShowHostsInfoStrCommand(String firstName, String lastName, String email, int phoneNr, int mobilenr) {

			String sqlCommand = "SELECT first_name, lastname, email, mobile_phone, phone_nr FROM hosts;";

			return sqlCommand;
		}

		public String updateUserStrCommand() {

			
			return sqlCommand;

		}

		public String getSqlCommand() {
			return sqlCommand;
		}
	}


