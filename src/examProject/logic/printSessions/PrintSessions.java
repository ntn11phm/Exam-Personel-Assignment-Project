package examProject.logic.printSessions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.transferObjects.PrintSessionsTO;

public class PrintSessions {
	private DbManipulator dBm;

	public PrintSessions(DbManipulator dBm) {
		this.dBm = dBm;
	}

	public List<PrintSessionsTO> getSessions(String date) {
		List<PrintSessionsTO> dateLocation = null;
		dBm.openDb();
		String sqlCommand = "SELECT session_time, session_location, session_id FROM sessions WHERE session_date = '"
				+ date
				+ "' GROUP BY session_time, session_location, session_id ORDER BY session_date;";
		ResultSet rs = dBm.select(sqlCommand);
		try {
			dateLocation = new ArrayList<PrintSessionsTO>();
			while (rs.next()) {
				dateLocation
						.add(new PrintSessionsTO(rs.getString("session_time"),
								rs.getString("session_location"), rs
										.getInt("session_id")));
			}
			rs.close();
		} catch (SQLException e) {

		}
		dBm.closeDb();
		return dateLocation;

	}
}
