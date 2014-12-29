package examProject.logic.populateSessions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.transferObjects.HostSessionTO;
import examProject.transferObjects.HostTO;
import examProject.transferObjects.SessionLocationTO;

public class PopulateSessions {
	private DbManipulator dbm;
	
	public PopulateSessions(DbManipulator dbm) {
		this.dbm = dbm;
	}
	
	public List<HostTO> loadAvailableHosts(String date, String time) {
		List<HostTO> result = new ArrayList<HostTO>();
		dbm.openDb();
		String sqlCommand = "SELECT hosts_sessions_invitations.host_id, first_name, last_name FROM hosts_sessions_invitations, hosts WHERE hosts_sessions_invitations.host_id = hosts.host_id AND hsi_date = '" + date 
				+ "' AND hsi_time = '" + time + "' AND NOT answer_date = '1970-01-01'" + " AND can_host=true;";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next()){
				result.add(new HostTO(rs.getInt("host_id"), rs.getString("first_name"), rs.getString("last_name")));
			}
		} catch (SQLException e) {}
		dbm.closeDb();
		return result;
	}
	
	public boolean checkHostSessionAvailabillity(String date, String time, int host_id) {
		boolean isAvailable = true;
		dbm.openDb();
		String sqlCommand = "SELECT host_sessions.host_id FROM host_sessions, sessions WHERE session_date =  '" + date 
				+ "' AND session_time = '" + time + "' AND host_id = " + host_id + " AND host_sessions.session_id = sessions.session_id;";
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
	
	public List<SessionLocationTO> loadLocations(String date, String time) {
		List<SessionLocationTO> result = new ArrayList<SessionLocationTO>();
		dbm.openDb();
		String sqlCommand = "SELECT session_location, session_id FROM sessions WHERE session_date = '" + date 
				+ "' AND session_time ='" + time + "';";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next()){
				result.add(new SessionLocationTO(rs.getString("session_location"), rs.getInt("session_id"), date, time));
			}
		} catch (SQLException e) {}
		dbm.closeDb();
		return result;
	}

	public boolean storeToSessionHost(List<HostSessionTO> currentList) {
		boolean result = false;
		dbm.openDb();
		for (int i = 0; i < currentList.size(); i++) {
			String sqlCommand = "INSERT INTO host_sessions (session_id, host_id, is_responsible) VALUES (" 
					+ currentList.get(i).getSession_id() + ", " + currentList.get(i).getHost_id() + ", " 
					+ currentList.get(i).isResponsible() + ");";
			result = dbm.insert(sqlCommand);
		}
		dbm.closeDb();
		return result;
	}
}
