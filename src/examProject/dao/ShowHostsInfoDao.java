package examProject.dao;

import examProject.transferObjects.ShowHostsInfoTransfere;

public class ShowHostsInfoDao {



		private ShowHostsInfoTransfere showHostsInfo;
		private DbManipulator dBm;
		//private String sqlCommand = "SELECT first_name, last_name, email, mobile_phone, phone_nr FROM hosts;";
		private String sqlCommand = "SELECT first_name, last_name FROM hosts;";

		public ShowHostsInfoDao(ShowHostsInfoTransfere showHostsInfo, DbManipulator dBm) {
			this.showHostsInfo = showHostsInfo;
			this.dBm = dBm;
		}

		public String ShowHostsInfoStrCommand(String firstName, String lastName, String email, int phoneNr, int mobilenr) {

			//String sqlCommand = "SELECT first_name, lastname, email, mobile_phone, phone_nr FROM hosts;";
			String sqlCommand = "SELECT first_name, lastname FROM hosts;";
			System.out.println(sqlCommand);
			return sqlCommand;
		}

		public String showHostsInfoStrCommand() {
			String sqlCommand = "SELECT first_name, lastname FROM hosts;";
			System.out.println(sqlCommand);

			return sqlCommand;

		}

		public String getSqlCommand() {
			return sqlCommand;
		}
	}


