package examProject.transferObjects;

public class CreateInvitationTO {

	private String date;
	private String time;

	public CreateInvitationTO(String date, String time) {
		this.date = date;
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "" + date + "   " + time;
	}

}
