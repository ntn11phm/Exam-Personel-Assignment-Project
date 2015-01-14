package examProject.dao;

import examProject.transferObjects.ShowHostsInfoTransfere;

public class ShowHostsInfoDao {
		private ShowHostsInfoTransfere showHostsInfo;
		private DbManipulator dbManipulator;
		private String sqlCommand = "SELECT first_name, last_name FROM hosts;";

		public ShowHostsInfoDao(ShowHostsInfoTransfere showHostsInfo, DbManipulator dbManipulator) {
			this.showHostsInfo = showHostsInfo;
			this.dbManipulator = dbManipulator;
		}

		public String ShowHostsInfoStrCommand(String firstName, String lastName, String email, int phoneNr, int mobilenr) {
			String sqlCommand = "SELECT first_name, lastname, email, mobile_phone, phone_nr FROM hosts;";
			return sqlCommand;
		}

		public String showHostsInfoStrCommand() {
			String sqlCommand = "SELECT first_name, lastname FROM hosts;";
			return sqlCommand;
		}

		public String getSqlCommand() {
			return sqlCommand;
		}
	}