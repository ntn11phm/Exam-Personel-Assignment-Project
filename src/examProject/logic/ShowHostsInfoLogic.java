package examProject.logic;

import java.sql.ResultSet;
import java.sql.Statement;
import examProject.dao.DbManipulator;
import examProject.dao.ShowHostsInfoDao;
import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.ShowHostsInfoTransfere;

	public class ShowHostsInfoLogic {
		private ShowHostsInfoTransfere showHostsInfo;
		private DbManipulator dbManipulator;
		private LoggedInUserTO currentUser;
		Statement updateStatment = null;


		public ShowHostsInfoLogic(ShowHostsInfoTransfere showHostsInfo, DbManipulator dbManipulator) {
			this.showHostsInfo = showHostsInfo;
			this.dbManipulator = dbManipulator;
			getLogginUserData();
		}
		
		public ShowHostsInfoTransfere getLogginUserData() {
			ShowHostsInfoTransfere storedUserdata = null;
			dbManipulator.openDb();
			String sqlCommand = "SELECT first_name, last_name, phone_nr, mobile_phone, email FROM hosts ;";
			ResultSet resultSet = dbManipulator.select(sqlCommand);
			dbManipulator.closeDb();
			return storedUserdata;
			}

		public boolean ShowHostsInfo() {
			dbManipulator.openDb();
			boolean result = false;
			String sqlCommand = "SELECT first_name, last_name FROM hosts;";

			ResultSet resultSet = dbManipulator.select(sqlCommand);
			try {
				if (resultSet.next()) {
					ShowHostsInfoDao showHostInfo = new ShowHostsInfoDao(showHostsInfo, dbManipulator);
					dbManipulator.select(showHostInfo.getSqlCommand());
					sqlCommand = "SELECT first_name, last_name FROM hosts;";
					dbManipulator.select(sqlCommand);
					result = true;
				}
			} catch (Exception e) {
			} finally {
				dbManipulator.closeDb();
			}
			return result;
		}
}