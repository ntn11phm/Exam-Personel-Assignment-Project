package examProject.dao;
import examProject.transferObjects.UpdateUserTransfere;


public class UpdateUsersInformation {
	
	private UpdateUserTransfere updateUser;
	private String sqlCommand = "UPDATE hosts SET first_name " + updateUser.getFirstName() + "last_name = " + updateUser.getLastName() + "civicnr = " + updateUser.getCivic() + "address = " + updateUser.getAddress()+ "zipcode = " + updateUser.getZipCode()+ "city = " + updateUser.getCity() + "email =" + updateUser.getEmail()+ "phone_nr =" + updateUser.getPhoneNr() + "mobile_phone =" + updateUser.getMobileNr() + "is_active= " + updateUser.isActive()+ "is_admin " + updateUser.isAdmin();
	private DbManipulator dBm;
	
			public UpdateUsersInformation(UpdateUserTransfere updateUser, DbManipulator dBm){
			this.updateUser = updateUser;
			this.dBm = dBm;
		}
			//SELECTSATS
		
		public String updateUserStrCommand(String firstName, String lastName, String email, String retypeEmail,String address, String city, String zipCode, int civic, int phoneNr, int mobilenr, boolean isActive, boolean is_admin) {
			String sqlCommand = "UPDATE hosts SET (first_name = ' " + firstName+ "last-name = ' "+ lastName+ 
				"civic = "+ civic +	"email = '" + email+ "retypeEmail '" + retypeEmail + "city = '" + city+ "address = '" + address+ "zipCode =" + zipCode + "is_admin = " + is_admin+ "is_active =" + isActive + "'";
			
			return sqlCommand;

		}
		public String updateUserStrCommand() {
			String sqlCommand = "UPDATE hosts SET (first_name = ' " + updateUser.getFirstName() + "last-name = ' "+ updateUser.getLastName() +  
					"civic = "+ updateUser.getCivic() +	"email = '" + updateUser.getEmail()+ "retypeEmail '" + updateUser.getRetypeEmail()+ "city = '" + updateUser.getCity()+ "address = '" + updateUser.getAddress() + "zipCode =" + updateUser.getZipCode() + "is_admin = " + updateUser.isAdmin() + "is_active =" + updateUser.isActive() + "'";
				
			return sqlCommand;

		}
		
		public String getSqlCommand(){
			return sqlCommand;
		}
	}