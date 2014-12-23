package examProject.transferObjects;

public class HostSessionTO {
	private int session_id;
	private int host_id;
	private boolean isResponsible;
	
	public HostSessionTO(int session_id, int host_id, boolean isResponsible) {
		this.session_id = session_id;
		this.host_id = host_id;
		this.isResponsible = isResponsible;
	}

	public int getSession_id() {
		return session_id;
	}

	public int getHost_id() {
		return host_id;
	}

	public boolean isResponsible() {
		return isResponsible;
	}

}
