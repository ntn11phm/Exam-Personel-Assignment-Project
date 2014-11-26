package examProject;

public class ActiveUser {
	private String userName;
	private int user_id;
	private boolean isAdmin;

	public ActiveUser(String userName, int user_id, boolean isAdmin) {
		this.userName = userName;
		this.user_id = user_id;
		this.isAdmin = isAdmin;
	}

	public String getUserName() {
		return userName;
	}

	public int getUser_id() {
		return user_id;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
}
