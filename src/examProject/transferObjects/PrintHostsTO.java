package examProject.transferObjects;

public class PrintHostsTO {
	private String firstName;
	private String lastName;
	private int civicNr;
	private String address;
	private String city;
	private int zipCode;
	private String email;
	private int mobileNr;
	private int phoneNr;

	public PrintHostsTO(String firstName, String lastName, int civicNr,
			String address, String city, int zipCode, String email,
			int mobileNr, int phoneNr) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.civicNr = civicNr;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
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

	public int getCivicNr() {
		return civicNr;

	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getEmail() {
		return email;
	}

	public int getMobileNr() {
		return mobileNr;
	}

	public int getPhoneNr() {
		return phoneNr;
	}

}
