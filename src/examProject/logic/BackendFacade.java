package examProject.logic;

import java.util.List;

import examProject.dao.DbManipulator;
import examProject.logic.answerInv.AnswerInvitation;
import examProject.logic.changePassword.ChangePassword;
import examProject.logic.createInv.CreateInvitation;
import examProject.logic.importSchemaData.ImportSchemaData;
import examProject.logic.login.Login;
import examProject.logic.populateSessions.PopulateSessions;
import examProject.logic.printSessions.PrintSessions;
import examProject.logic.requestNewPassword.RequestNewPwd;
import examProject.logic.schemaReader.KronoxImporter;
import examProject.transferObjects.AddUser;
import examProject.transferObjects.CreateInvitationTO;
import examProject.transferObjects.ExamImportSelectionTO;
import examProject.transferObjects.ExamOccationTO;
import examProject.transferObjects.HostSessionTO;
import examProject.transferObjects.HostTO;
import examProject.transferObjects.HsiTO;
import examProject.transferObjects.PrintSessionsTO;
import examProject.transferObjects.SessionLocationTO;
import examProject.transferObjects.UpdateUserTransfere;
import examProject.transferObjects.LoggedInUserTO;
import examProject.ui.updateUserInformation.SetupIncompleteException;

public class BackendFacade {
	private DbManipulator dbManipulator;
	private LoggedInUserTO currentUser;
	private Password_interface hash;
	
	public BackendFacade(LoggedInUserTO currentUser) throws SetupIncompleteException {
		this.currentUser = currentUser;
		createDbObjects();
		this.hash = new PasswordHashingLocal();
	}
	
	public BackendFacade(LoggedInUserTO currentUser, Password_interface hash) throws SetupIncompleteException {
		this.currentUser = currentUser;
		createDbObjects();
		this.hash = hash;
	}
	
	private void createDbObjects() throws SetupIncompleteException {
		OptionsFileReader optionsFileReader = new OptionsFileReader();
		optionsFileReader.readOptionFile();
		this.dbManipulator = new DbManipulator(optionsFileReader.getConnTO()); 
	} 

	public boolean changePwd(char[] pwd) {
		ChangePassword changePwd = new ChangePassword(dbManipulator);
		return changePwd.changePassword(currentUser.getUsername(), pwd);
	}

	public boolean requestNewPwdEmail(String email) {
		RequestNewPwd rnp = new RequestNewPwd(dbManipulator, email);
		return rnp.execute();
	}

	public boolean requestNewPwdUsername(String username) {
		RequestNewPwd rnp = new RequestNewPwd(dbManipulator, username);
		return rnp.execute();
	}

	public boolean addUser(AddUser addUser) {
		AddUserLogic aul = new AddUserLogic(addUser, dbManipulator, hash);
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
		UpdateUserLogic updateUserLogic= new UpdateUserLogic(currentUser, updateUser, dbManipulator);
		
		return updateUserLogic.uppdateUser();
	}
		
	public boolean uppdateUser(String firstName, String lastName, String email, String retypeEmail, String civicNr, String mobileNr, String phoneNr, String city, String address, String zipCode,boolean isActive, boolean isAdmin) {
		return uppdateUser(new UpdateUserTransfere(firstName, lastName, email, retypeEmail, city, address, mobileNr, phoneNr, zipCode, civicNr, isActive, isAdmin));
	}
	
	public LoggedInUserTO login(String username, char[] pwd) {
		Login login = new Login(dbManipulator, hash);
		currentUser = login.login(username, pwd); 
		return currentUser;
	}

	public List<HsiTO> getHsiList() {
		AnswerInvitation ai = new AnswerInvitation(dbManipulator, currentUser);
		return ai.getInvitations();
	}
		
	public boolean commitInvitationAnswers(List<HsiTO> answerList) {
		AnswerInvitation ai = new AnswerInvitation(dbManipulator, currentUser);
		return ai.commitAnswers(answerList);
	}
	
	public List<HostTO> getAvailableHostsList(String date, String time) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.loadAvailableHosts(date, time);
	}
	
	public boolean checkHostSessionAvailabillity(String date, String time, int host_id) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.checkHostSessionAvailabillity(date, time, host_id);
	}
	
	public boolean createHsi(List<HsiTO> sessionList) {
		CreateInvitation ci = new CreateInvitation( dbManipulator);
		return ci.createHsi(sessionList);
	}
	
	public List<SessionLocationTO> loadLocations(String date, String time) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.loadLocations(date, time);
	}
	public List<HsiTO> getSessions(CreateInvitationTO cTo) {
		CreateInvitation ci = new CreateInvitation(dbManipulator);
		return ci.getSessions(cTo);
	}
	public List<PrintSessionsTO>getSessions(String date){
		PrintSessions ps = new PrintSessions(dbManipulator);
		return ps.getSessions(date);
	}
	public List<HostTO> getHostsForSession(int sessionId) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.getHostsForSession(sessionId);
	}
	
	public boolean storeToSessionHost(List<HostSessionTO> currentList) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.storeToSessionHost(currentList);
	}
	public boolean removeHostSessionPost(int host_id, int sessionId) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.removeHostSessionPost(host_id, sessionId);
	}
	public UpdateUserTransfere getCurrentHostData() {
		UpdateUserLogic uul = new UpdateUserLogic(currentUser, null, dbManipulator);
		return uul.getLogginUserData();
	}

}
