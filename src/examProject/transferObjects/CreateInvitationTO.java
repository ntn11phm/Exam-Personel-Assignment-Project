package examProject.transferObjects;

import java.util.List;

import javax.swing.JList;

public class CreateInvitationTO {

	private String fromDate;
	private String toDate;

	public CreateInvitationTO(String fromDate, String toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public String toString(List<CreateInvitationTO> sessionList) {
		return "" + fromDate + "   " + toDate;

	}

}
