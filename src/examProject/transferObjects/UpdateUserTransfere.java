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
		//	if (civic.equals(""))
			//	return null;
		//	else
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
	
		public int getZipCode(){
			
			if (zipCode.equals(""))
				return 0;
			else
				return Integer.parseInt(zipCode);
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
				

		public boolean isAdmin() {
			return isAdmin;
		}

		public boolean isActive() {
			return isActive;
		}
}
