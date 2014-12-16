package examProject.logic.createInv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.transferObjects.HsiTO;

public class CreateInvitation {
	private HsiTO hsiTo;
	private DbManipulator dBm;

	public CreateInvitation(HsiTO hsiTo, DbManipulator dBm) {
		this.hsiTo = hsiTo;
		this.dBm = dBm;

	}

	public List<HsiTO> getSessions() {
		List<HsiTO> result = null;
		dBm.openDb();
		String sqlCommand = "SELECT session_date, session_time FROM sessions WHERE session_date BETWEEN '"
				+ hsiTo.getDate()
				+ "' AND '"
				+ hsiTo.getDate()
				+ "' GROUP BY session_date, session_time;";
		ResultSet rs = dBm.select(sqlCommand);
		try {
			while (rs.next()) {
				if (result == null)
					result = new ArrayList<HsiTO>();
				result.add(new HsiTO(rs.getString("hsi_date"), rs
						.getString("hsi_time"), rs.getBoolean("can_host")));
			}
			rs.close();
		} catch (SQLException e) {

		}
		dBm.closeDb();
		return result;

	}

}
