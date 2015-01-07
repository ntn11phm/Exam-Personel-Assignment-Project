package examProject.transferObjects;

public class PrintHostsTO {
	private String firstName;
	private String lastName;
	private String civicNr;
	private String address;
	private String city;
	private String zipCode;
	private String email;
	private String mobileNr;
	private String phoneNr;

	public PrintHostsTO(String firstName, String lastName, String civicNr,
			String address, String city, String zipCode, String email,
			String mobileNr, String phoneNr) {
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
		if (civicNr.equals(""))
			return 0;
		else
			return Integer.parseInt(civicNr);
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public int getZipCode() {
		if (zipCode.equals(""))
			return 0;
		else
			return Integer.parseInt(zipCode);
	}

	public String getEmail() {
		return email;
	}

	public int getMobileNr() {
		if (mobileNr.equals(""))
			return 0;
		else
			return Integer.parseInt(mobileNr);
	}

	public int getPhoneNr() {
		if (phoneNr.equals(""))
			return 0;
		else
			return Integer.parseInt(phoneNr);
	}

}
