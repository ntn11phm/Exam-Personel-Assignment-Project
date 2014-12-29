package examProject.transferObjects;

public class SessionLocationTO {
	private String location;
	private int session_id;
	private String date;
	private String time;
	
	public SessionLocationTO(String location, int session_id, String date, String time) {
		this.location = location;
		this.session_id = session_id;
		this.date = date;
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public int getSession_id() {
		return session_id;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "" + location;
	}
}
