package examProject.logic.printSessions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.transferObjects.HsiTO;
import examProject.transferObjects.PrintSessionsTO;

public class PrintSessions {
	private DbManipulator dBm;

	public PrintSessions(DbManipulator dBm) {
		this.dBm = dBm;
	}

	public List<HsiTO> getSessions(PrintSessionsTO pTo) {
		List<HsiTO> dateLocation = null;
		dBm.openDb();
		String sqlCommand = "SELECT session_date, session_location FROM sessions WHERE session_date = '"
				+ pTo.getSessionTime()
				+ "' GROUP BY session_date, session_time ORDER BY session_date;";
		ResultSet rs = dBm.select(sqlCommand);
		try {
			dateLocation = new ArrayList<HsiTO>();
			while (rs.next()) {
				dateLocation.add(new HsiTO(rs.getString("session_date"), rs
						.getString("session_time")));
			}
			rs.close();
		} catch (SQLException e) {

		}
		dBm.closeDb();
		return dateLocation;

	}
}
