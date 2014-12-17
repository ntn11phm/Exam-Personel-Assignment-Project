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

	public List<CreateInvitationTO> getSessions() {
		List<CreateInvitationTO> result = null;
		dBm.openDb();
		String sqlCommand = "SELECT session_date, session_time FROM sessions WHERE session_date BETWEEN '"
				+ cTo.getFromDate()
				+ "' AND '"
				+ cTo.getToDate()
				+ "' GROUP BY session_date, session_time;";
		ResultSet rs = dBm.select(sqlCommand);
		try {
			while (rs.next()) {
				result = new ArrayList<CreateInvitationTO>();
				result.add(new CreateInvitationTO(rs.getString("session_date"), rs.getString("session_time")));
			}
			rs.close();
		} catch (SQLException e) {

		}
		dBm.closeDb();
		return result;

	}

}
