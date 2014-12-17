package examProject.logic.createInv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.transferObjects.CreateInvitationTO;
import examProject.transferObjects.HsiTO;

public class CreateInvitation {
	private CreateInvitationTO cTo;
	private DbManipulator dBm;

	public CreateInvitation(CreateInvitationTO cTo, DbManipulator dBm) {
		this.cTo = cTo;
		this.dBm = dBm;
	}

	public List<HsiTO> getSessions() {
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

	public List<CreateInvitationTO> getHostId(List<HsiTO> sessionList) {
		List<CreateInvitationTO> hostIdList = null;
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
							+ "', '"
							+ sessionList.get(x).getDate()
							+ "', '"
							+ sessionList.get(x).getTime() + "';";
				}
			}
		} catch (SQLException e) {

		}

		dBm.closeDb();
		return hostIdList;
	}
}
