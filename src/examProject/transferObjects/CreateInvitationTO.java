package examProject.transferObjects;

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

	@Override
	public String toString() {
		return "" + fromDate + "   " + toDate;
	}

}
