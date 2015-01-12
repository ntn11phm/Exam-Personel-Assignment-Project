package examProject.logic;

import java.sql.ResultSet;
import java.sql.Statement;
import examProject.dao.DbManipulator;
import examProject.dao.ShowHostsInfoDao;
import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.ShowHostsInfoTransfere;

	public class ShowHostsInfoLogic {
		private ShowHostsInfoTransfere showHostsInfo;
		private DbManipulator dBm;
		private LoggedInUserTO currentUser;
		Statement updateStatment = null;


		public ShowHostsInfoLogic(ShowHostsInfoTransfere showHostsInfo, DbManipulator dBm) {
		//public ShowHostsInfoLogic(LoggedInUserTO currentUser, ShowHostsInfoTransfere uppdateUser, DbManipulator dBm) {
			this.showHostsInfo = showHostsInfo;
			this.dBm = dBm;
			getLogginUserData();
		}
		
		public ShowHostsInfoTransfere getLogginUserData() {
			ShowHostsInfoTransfere storedUserdata = null;
			dBm.openDb();
			//String sqlCommand = "SELECT first_name, last_name, phone_nr, mobile_phone, email FROM hosts ;";
			String sqlCommand = "SELECT first_name, last_name FROME hosts;";

			ResultSet rs = dBm.select(sqlCommand);
			/*try {
				while (!rs.next())
					storedUserdata = new ShowHostsInfoTransfere(rs.getString("first_name"), rs.getString("last_name"));
						//	rs.getString("email"), rs.getString("mobile_phone"), rs.getString("phone_nr"));
			} catch (SQLException e) {}
			*/
			dBm.closeDb();
			return storedUserdata;
			
		}

		public boolean ShowHostsInfo() {

			dBm.openDb();
			boolean result = false;
			String sqlCommand = "SELECT first_name, last_name FROM hosts;";

			ResultSet rs = dBm.select(sqlCommand);
			try {
				if (rs.next()) {
					ShowHostsInfoDao showHostInfo = new ShowHostsInfoDao(showHostsInfo, dBm);
					dBm.select(showHostInfo.getSqlCommand());
					sqlCommand = "SELECT first_name, last_name FROM hosts;";

					

					dBm.select(sqlCommand);
					result = true;
				}
			} catch (Exception e) {
			} finally {
				dBm.closeDb();
			}

			return result;
		}

	}