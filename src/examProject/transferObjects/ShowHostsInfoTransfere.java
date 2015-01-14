package examProject.transferObjects;

public class ShowHostsInfoTransfere {
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNr;
	private String phoneNr;

	public ShowHostsInfoTransfere(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public ShowHostsInfoTransfere(String firstName, String lastName, String email,String mobileNr, String phoneNr ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNr = mobileNr;
		this.phoneNr = phoneNr;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNr() {
		return mobileNr;
	}

	public String getPhoneNr() {
		return phoneNr;
	}
}