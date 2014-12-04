package examProject.logic;

import java.util.List;
import examProject.transferObjects.ExamImportSelectionTO;
import examProject.transferObjects.ExamOccationStorer;

public class BackendFacade {

	public boolean validateCurrentPwd(char[] pwd) {

		return false;
	}

	public boolean changePwd(char[] pwd) {

		return false;
	}

	public boolean requestNewPwdEmail(String email) {

		return false;
	}

	public boolean requestNewPwdUsername(String username) {

		return false;
	}

	public boolean addUser(AddUser addUser) {
		return false;
	}
	
	public boolean addUser(String userName, String firstName, String lastName, char[] pwd, boolean isAdmin) {
		return addUser(new AddUser(userName, firstName, lastName, pwd, isAdmin));
	}
	
	public boolean validateUserNameAvailibility(AddUser addUser) {

		return false;
	}
	
	public List<ExamOccationStorer> readSchemaFromKronox(ExamImportSelectionTO examImportSelection) {
		
		return null;
	}
}
