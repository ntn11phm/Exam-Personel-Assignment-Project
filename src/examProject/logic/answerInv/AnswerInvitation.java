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
	private String timeStamp;
	
	public AnswerInvitation(DbManipulator dbm,LoggedInUserTO currentUser) {
		this.currentUser = currentUser;
		this.dbm = dbm;
		this.timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	}
	
	public List<HsiTO> getInvitations() {
		List<HsiTO> result = null;
		dbm.openDb();
		String sqlCommand = "SELECT hsi_date, hsi_time, can_host FROM hosts_sessions_invitations WHERE host_id = "
				+ currentUser.getHost_id() + " AND hsi_date > '" + timeStamp + "' ORDER BY hsi_date, hsi_time;";
		ResultSet rs = dbm.select(sqlCommand);
		try {
			while (rs.next()) {
				if (result == null)
					result = new ArrayList<HsiTO>();
				result.add(new HsiTO(rs.getString("hsi_date"), rs.getString("hsi_time"), rs.getBoolean("can_host")));
			}
			rs.close();
		} catch (SQLException e) {}
		dbm.closeDb();
		return result;
	}
	
	public boolean commitAnswers(List<HsiTO> answerList) {
		boolean result = false;
		int updates = 0;
		if (answerList != null) {
			dbm.openDb();
			for (int i = 0; i < answerList.size(); i++) {
				String sqlCommand = "UPDATE hosts_sessions_invitations SET answer_date = '" 
						+ timeStamp + "', can_host = " + answerList.get(i).getAnswer() 
						+ " WHERE host_id = " + currentUser.getHost_id() + " AND hsi_date = '" 
						+ answerList.get(i).getDate() + "' AND hsi_time = '" + answerList.get(i).getTime() + "';";
				result = dbm.insert(sqlCommand);
				if (result)
					updates++;
			}
			dbm.closeDb();
		}
		if (updates == answerList.size())
			result = true;
		else
			result = false;
		return result;
	}
}
