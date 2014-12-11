package examProject.logic;

import java.sql.Connection;
import java.util.List;

import examProject.dao.DbManipulator;
import examProject.dao.JdbcConnect;
import examProject.logic.schemaReader.KronoxImporter;
import examProject.transferObjects.AddUser;
import examProject.transferObjects.ExamImportSelectionTO;
import examProject.transferObjects.ExamOccationTO;
import examProject.transferObjects.UpdateUser;
import examProject.ui.updateUserInformation.UI_LoadUserInformation;

public class BackendFacade {
	private JdbcConnect con = new JdbcConnect();
	private Connection c = null;
	private DbManipulator dbManipulator;
	
	public BackendFacade() {
		createDbObjects();
	}
	
	private void createDbObjects() {
//		this.dbDelete = new DbDelete(c);
//		this.dbInsert = new DbInsert(c);
//		this.dbSelect = new DbSelect();
//		this.dbUpdate = new DbUpdate(c);
		this.dbManipulator = new DbManipulator();
	}
	
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
		AddUserLogic aul = new AddUserLogic(addUser, dbManipulator);
		
		return aul.addUser();
	}
	
	public boolean addUser(String userName, String firstName, String lastName, char[] pwd, boolean isAdmin) {
		return addUser(new AddUser(userName, firstName, lastName, pwd, isAdmin));
	}
	
	public boolean validateUserNameAvailibility(AddUser addUser) {

		return false;
	}
	
	public List<ExamOccationTO> readSchemaFromKronox(ExamImportSelectionTO examImportSelection) {
		KronoxImporter kronoxImporter = new KronoxImporter(examImportSelection);
		kronoxImporter.executeImport();
		return kronoxImporter.getImportedData();
	}
	
	public boolean importSchemaData(List<ExamOccationTO> arrList) {
		
		return false;
	}
	public boolean uppdateUser(UpdateUser updateUser) {
		UpdateUserLogic updateUserLogic= new UpdateUserLogic(updateUser, dbManipulator);
		
		return updateUserLogic.uppdateUser();
	}
		
	public boolean uppdateUser(String firstName, String lastName, String email, String retypeEmail, int civicNr, int mobileNr, int phoneNr, String city, String address, String zipCode,boolean isActive, boolean isAdmin) {
		return uppdateUser(new UpdateUser(firstName, lastName, email, retypeEmail, city, address, mobileNr, phoneNr, zipCode, civicNr, isActive, isAdmin));
	}
}
