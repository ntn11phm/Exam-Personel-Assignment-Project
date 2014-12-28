package examProject.transferObjects;

public class SessionLocationTO {
	private String location;
	private int session_id;
	
	public SessionLocationTO(String location, int session_id) {
		this.location = location;
		this.session_id = session_id;
	}

	public String getLocation() {
		return location;
	}

	public int getSession_id() {
		return session_id;
	}

	@Override
	public String toString() {
		return "" + location;
	}
}
