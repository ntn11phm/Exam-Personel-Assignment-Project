package examProject.logic.answerInv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.transferObjects.HsiTO;
import examProject.transferObjects.LoggedInUserTO;

public class AnswerInvitation {
	private LoggedInUserTO currentUser;
	private DbManipulator dbm;
	
	public AnswerInvitation(DbManipulator dbm,LoggedInUserTO currentUser) {
		this.currentUser = currentUser;
		this.dbm = dbm;
	}
	
	public List<HsiTO> getInvitations() {
		List<HsiTO> result = null;
		dbm.openDb();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String sqlCommand = "SELECT hsi_date, hsi_time FROM hosts_sessions_invitation WHERE host_id = (SELECT host_id FROM hosts WHERE user_id = "
				+ currentUser.getUser_id() + ") AND hsi_date > '" + timeStamp + "' ORDER BY hsi_date, hsi_time;";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next()) {
				if (result == null)
					result = new ArrayList<HsiTO>();
				result.add(new HsiTO(rs.getString("hsi_date"), rs.getString("hsi_time")));
			}
			rs.close();
		} catch (SQLException e) {}
		dbm.closeDb();
		return result;
	}
}
