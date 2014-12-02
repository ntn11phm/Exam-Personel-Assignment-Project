package examProject.logic.requestNewPassword;

public class RequestNewPwdHolder {
	private String username;
	private String password;
	private String message;
	
	public RequestNewPwdHolder(String username, String password, String message) {
		this.username = username;
		this.password = password;
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getMessage() {
		return message;
	}
}
