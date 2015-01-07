package examProject.transferObjects;

public class UpdateUserTransfere {
	private String firstName;
	private String lastName;
	private String civic;
	private String email;
	private String retypeEmail;
	private String city;
	private String Address;
	private String zipCode;
	private String mobileNr;
	private String phoneNr;
	private boolean isAdmin;
	private boolean isActive;

	public UpdateUserTransfere(String firstName, String lastName, String email, String retypeEmail, String city, String address, String mobileNr, String phoneNr, String zipCode, String civic, boolean isActive, boolean isAdmin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.civic = civic;
		this.email = email;
		this.Address = address;
		this.retypeEmail = retypeEmail;
		this.city = city;
		this.zipCode = zipCode;
		this.mobileNr = mobileNr;
		this.phoneNr= phoneNr;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCivic() {
		return civic;
	}		

	public String getEmail() {
		return email;
	}

	public String getRetypeEmail() {
		return retypeEmail;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return Address;
	}

	public String getZipCode(){
		return zipCode;
	}
	
	
	public String getMobileNr() {
		return mobileNr;
	}
			

	public String getPhoneNr() {
		return phoneNr;
	}
			
	public boolean isAdmin() {
		return isAdmin;
	}

	public boolean isActive() {
		return isActive;
	}
}
