package examProject.logic;

import java.util.List;

import examProject.dao.DbManipulator;
import examProject.logic.answerInv.AnswerInvitation;
import examProject.logic.createInv.CreateInvitation;
import examProject.logic.importSchemaData.ImportSchemaData;
import examProject.logic.login.Login;
import examProject.logic.schemaReader.KronoxImporter;
import examProject.transferObjects.AddUser;
import examProject.transferObjects.CreateInvitationTO;
import examProject.transferObjects.ExamImportSelectionTO;
import examProject.transferObjects.ExamOccationTO;
import examProject.transferObjects.HostTO;
import examProject.transferObjects.HsiTO;
import examProject.transferObjects.UpdateUserTransfere;
import examProject.transferObjects.LoggedInUserTO;
import examProject.ui.updateUserInformation.SetupIncompleteException;

public class BackendFacade {
	private DbManipulator dbManipulator;
	private LoggedInUserTO currentUser;
	
	public BackendFacade() throws SetupIncompleteException {
		createDbObjects();
	}
	private void createDbObjects() throws SetupIncompleteException {
		OptionsFileReader optionsFileReader = new OptionsFileReader();
		optionsFileReader.readOptionFile();
		this.dbManipulator = new DbManipulator(optionsFileReader.getConnTO()); 
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
		ImportSchemaData isd = new ImportSchemaData(dbManipulator, arrList);
		return isd.execute();
	}
	public boolean uppdateUser(UpdateUserTransfere updateUser) {
		UpdateUserLogic updateUserLogic= new UpdateUserLogic(updateUser, dbManipulator);
		
		return updateUserLogic.uppdateUser();
	}
		
	public boolean uppdateUser(String firstName, String lastName, String email, String retypeEmail, String civicNr, String mobileNr, String phoneNr, String city, String address, String zipCode,boolean isActive, boolean isAdmin) {
		return uppdateUser(new UpdateUserTransfere(firstName, lastName, email, retypeEmail, city, address, mobileNr, phoneNr, zipCode, civicNr, isActive, isAdmin));
	}
	
	public LoggedInUserTO login(String username, char[] pwd) {
		Login login = new Login(dbManipulator);
		currentUser = login.login(username, pwd); 
		return currentUser;
	}

	public List<HsiTO> getHsiList() {
		AnswerInvitation ai = new AnswerInvitation(dbManipulator, currentUser);
		return ai.getInvitations();
	}
		
	public boolean commitInvitationAnswers(List<HsiTO> answerList) {
		boolean result = false;
		
		return result;
	}
	
	public List<HostTO> getAvailableHostsList(String date) {
		
		return null;
	}
	public boolean checkHostSessionAvailabillity(String text, int host_id) {
		
		return false;
	}
	
	public boolean createHsi(List<HsiTO> sessionList) {
		CreateInvitation ci = new CreateInvitation( dbManipulator);
		return ci.createHsi(sessionList);
	}
	
	public List<HsiTO> getSessions(CreateInvitationTO cTo) {
		CreateInvitation ci = new CreateInvitation(dbManipulator);
		return ci.getSessions(cTo);
	}

}
