package examProject.logic.createInv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.transferObjects.CreateInvitationTO;
import examProject.transferObjects.HsiTO;

public class CreateInvitation {
	private DbManipulator dBm;

	public CreateInvitation( DbManipulator dBm) {
		this.dBm = dBm;
	}

	public List<HsiTO> getSessions(CreateInvitationTO cTo) {
		List<HsiTO> dateTime = null;
		dBm.openDb();
		String sqlCommand = "SELECT session_date, session_time FROM sessions WHERE session_date BETWEEN '"
				+ cTo.getFromDate()
				+ "' AND '"
				+ cTo.getToDate()
				+ "' GROUP BY session_date, session_time;";
		ResultSet rs = dBm.select(sqlCommand);
		try {
			dateTime = new ArrayList<HsiTO>();
			while (rs.next()) {
				dateTime.add(new HsiTO(rs.getString("session_date"), rs
						.getString("session_time")));
			}
			rs.close();
		} catch (SQLException e) {

		}
		dBm.closeDb();
		return dateTime;

	}

	public boolean createHsi(List<HsiTO> sessionList) {
		
		boolean result = true;
		dBm.openDb();
		String sqlCommand = "SELECT host_id FROM hosts Where is_active = TRUE;";
		ResultSet rs = dBm.select(sqlCommand);
		List<Integer> hostList = new ArrayList<Integer>();

		try {
			while (rs.next()) {
				hostList.add(rs.getInt("host_id"));
			}
			for (int i = 0; i < hostList.size(); i++) {
				for (int x = 0; x < sessionList.size(); x++) {
					sqlCommand = "INSERT INTO hosts_sessions_invitations (host_id, hsi_date, hsi_time) VALUES ('"
							+ hostList.get(i)
							+ "','"
							+ sessionList.get(x).getDate()
							+ "','"
							+ sessionList.get(x).getTime() + "');";
					String currentHsi = "SELECT hsi_time FROM hosts_sessions_invitations WHERE host_id = '"
							+ hostList.get(i)
							+ "'AND hsi_date ='"
							+ sessionList.get(x).getDate()
							+ "'AND  hsi_time ='"
							+ sessionList.get(x).getTime() + "';";
					rs = dBm.select(currentHsi);
					boolean notFound = true;
					try {
						while (rs.next()) {
							notFound = false;

						}
						if (notFound) {
							dBm.insert(sqlCommand);
						}
					} catch (SQLException e) {
						result = false;
					}
				}
			}
		} catch (SQLException e) {
			result = false;

		}

		dBm.closeDb();
		return result;
	}
}
