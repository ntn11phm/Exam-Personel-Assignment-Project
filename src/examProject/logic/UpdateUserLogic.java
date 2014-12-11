package examProject.logic;
import examProject.dao.DbManipulator;
import examProject.transferObjects.UpdateUser;

public class UpdateUserLogic {

	private UpdateUser uppdateUser;
	private DbManipulator dBm;
	
	public UpdateUserLogic(UpdateUser uppdateUser, DbManipulator dBm) {
		this.uppdateUser = uppdateUser;
		this.dBm = dBm;

	}

	public boolean uppdateUser() {
		return false;
	}
}