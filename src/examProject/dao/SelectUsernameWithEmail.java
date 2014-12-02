package examProject.dao;

public class SelectUsernameWithEmail {
	private String selectCommand = "SELECT username FROM users WHERE user_id=(SELECT user_id FROM hosts WHERE email='";
	
	public String getUsername(String email) {
		return selectCommand += email + "');";
	}
}
