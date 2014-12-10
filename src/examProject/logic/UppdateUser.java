package examProject.logic;

public class UppdateUser {

		public String firstName;
		public String lastName;
		public int civic;
		public String email;
		public String retypeEmail;
		public String city;
		public String Address;
		public String zipCode;
		public int mobileNr;
		public int phoneNr;
		public boolean isAdmin;
		public boolean isActive;

		public UppdateUser(String firstName, String lastName, String email, String retypeEmail, String city, String address, int mobileNr, int phoneNr, String zipCode, int civic, boolean isActive, boolean isAdmin) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.civic = civic;
			this.email = email;
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

		public int getCivic() {
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

		public String getZipCode() {
			return zipCode;
		}

		public int getMobileNr() {
			return mobileNr;
		}

		public int getPhoneNr() {
			return phoneNr;
		}

		public boolean isAdmin() {
			return isAdmin;
		}

		public boolean isActive() {
			return isActive;
		}
}
