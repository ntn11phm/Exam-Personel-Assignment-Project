package examProject.transferObjects;

public class UpdateUserTransfere {

		public String firstName;
		public String lastName;
		public String civic;
		public String email;
		public String retypeEmail;
		public String city;
		public String Address;
		public String zipCode;
		public String mobileNr;
		public String phoneNr;
		public boolean isAdmin;
		public boolean isActive;

		public UpdateUserTransfere(String firstName, String lastName, String email, String retypeEmail, String city, String address, String mobileNr, String phoneNr, String zipCode, String civic, boolean isActive, boolean isAdmin) {
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
			System.out.println("öö " +firstName);
			return firstName;
		}

		public String getLastName() {
			System.out.println("ööö " +firstName);
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

		public String getZipCode() {
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
