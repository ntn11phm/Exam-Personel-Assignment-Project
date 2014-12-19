package examProject.logic.populateSessions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import examProject.dao.DbManipulator;

public class PopulateSessions {
	private DbManipulator dbm;
	
	public PopulateSessions(DbManipulator dbm) {
		this.dbm = dbm;
	}
	
	public List<String> loadAvailableHosts(String date, String time) {
		dbm.openDb();
		String sqlCommand = "SELECT host_id FROM hosts_sessions_invitation WHERE hsi_date = '" + date 
				+ "' AND hsi_time = '" + time + "' AND answer_date = '1970-01-01'" + ";";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next()){
				
			}
		} catch (SQLException e) {}
		dbm.closeDb();
		return null;
	}
	
	public boolean checkHostSessionAvailabillity(String date, int host_id) {
		boolean isAvailable = true;
		dbm.openDb();
		String sqlCommand = "SELECT answer_date FROM hosts_sessions_invitation WHERE hsi_date = '" + date 
				+ "' AND host_id = " + host_id + " AND NOT answer_date = '1970-01-01';";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next()){
				//if (!rs.getString("answer_date").equals("1970-01-01"))
					isAvailable = false;
			}
		} catch (SQLException e) {}
		dbm.closeDb();
		return isAvailable;
	}

}
