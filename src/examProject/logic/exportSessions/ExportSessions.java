package examProject.logic.exportSessions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.transferObjects.HostSessionDataTO;

public class ExportSessions {
	private DbManipulator dbManipulator;
	
	public ExportSessions(DbManipulator dbManipulator) {
		this.dbManipulator = dbManipulator;
	}
	
	public List<HostSessionDataTO> exportSessions(String fromDate, String toDate) {
		List<HostSessionDataTO> arr = new ArrayList<HostSessionDataTO>();
		String selectCommand = "SELECT session_date, session_time, session_location, first_name, last_name, is_responsible FROM hosts, sessions, host_sessions WHERE hosts.host_id = host_sessions.host_id AND sessions.session_id = host_sessions.session_id AND session_date between '"+ fromDate + "' AND '"+ toDate + "' ORDER BY session_date, session_time, session_location, is_responsible desc;";
		dbManipulator.openDb();
		ResultSet rs = dbManipulator.select(selectCommand);
		try {
			while(rs.next())
				arr.add(new HostSessionDataTO(rs.getString("session_date"), rs.getString("session_time"), rs.getString("session_location"), rs.getString("first_name"), rs.getString("last_name"), rs.getBoolean("is_responsible")));
			rs.close();
		} catch (SQLException e) {}
		dbManipulator.closeDb();
		return arr;
	}	
}
