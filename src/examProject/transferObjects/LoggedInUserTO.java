package examProject.transferObjects;

public class LoggedInUserTO {
	private String username;
	private boolean is_admin;
	private int user_id;
	private boolean has_tmp_pwd;
	
	public LoggedInUserTO(String username, int user_id, boolean is_admin, boolean has_tmp_pwd) {
		this.username = username;
		this.has_tmp_pwd = has_tmp_pwd;
		this.is_admin = is_admin;
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public int getUser_id() {
		return user_id;
	}

	public boolean isHas_tmp_pwd() {
		return has_tmp_pwd;
	}
}
