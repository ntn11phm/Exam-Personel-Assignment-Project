package examProject.logic.createInv;

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
	public List<HsiTO>getSessions() {
		List<HsiTO> result = null;
		dBm.openDb();
		String sqlCommand = "SELECT session_date, session_time FROM sessions WHERE session_date BETWEEN '"+ hsiTo.getDate()""' AND '' GROUP BY session_date, session_time;";
		
		
		
		return result;
		
	}

}
