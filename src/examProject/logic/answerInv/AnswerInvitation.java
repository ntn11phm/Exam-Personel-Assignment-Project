package examProject.logic.answerInv;

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
		String sqlCommand = "SELECT hsi_date, hsi_time FROM hosts_sessions_invitation WHERE host_id = (SELECT host_id FROM hosts WHERE user_id = " + currentUser.getUser_id() + ");";
		return result;
	}
}
