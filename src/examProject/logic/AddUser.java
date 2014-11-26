package examProject.logic;

public class AddUser {
	public String userName;
	public String firstName;
	public String lastName;
	public char[] pwd;
	public boolean isAdmin;

	public AddUser(String userName, String firstName, String lastName, char[] pwd, Boolean isAdmin) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pwd = pwd;
		this.isAdmin = isAdmin;
	}

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public char[] getPwd() {
		return pwd;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

}
