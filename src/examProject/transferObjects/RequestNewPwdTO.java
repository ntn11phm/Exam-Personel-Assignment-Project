package examProject.transferObjects;

public class RequestNewPwdTO {
	private String username;
	private String password;
	private String message;
	
	public RequestNewPwdTO(String username, String password, String message) {
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
