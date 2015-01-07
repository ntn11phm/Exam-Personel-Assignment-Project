package examProject.logic;

/**
 * 
 */

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
	
	/**
	 * Constructor
	 * @param currentUser {@link LoggedInUserTO} containing data about the user that has logged in.
	 * @throws SetupIncompleteException if the configuration files are missing the data needed to connect to the database.
	 */
	public BackendFacade(LoggedInUserTO currentUser) throws SetupIncompleteException {
		this(currentUser, new PasswordHashingLocal());
	}
	/**
	 * Constructor
	 * @param currentUser {@link LoggedInUserTO} containing data about the user that has logged in.
	 * @param hash injection of a hashing function that implements {@link Password_interface}.
	 * @throws SetupIncompleteException if the configuration files are missing the data needed to connect to the database.
	 */
	public BackendFacade(LoggedInUserTO currentUser, Password_interface hash) throws SetupIncompleteException {
		this.currentUser = currentUser;
		createDbObjects();
		this.hash = hash;
	}
	/**
	 * Creates the need objects to create a connection to the database.
	 * @throws SetupIncompleteException if the configuration files are missing the data needed to connect to the database.
	 */
	private void createDbObjects() throws SetupIncompleteException {
		OptionsFileReader optionsFileReader = new OptionsFileReader();
		optionsFileReader.readOptionFile();
		this.dbManipulator = new DbManipulator(optionsFileReader.getConnTO()); 
	} 
	/**
	 * Change password for the user who is logged in.
	 * @param pwd char[] containing the password.
	 * @return true if the password was stored correctly.
	 */
	public boolean changePwd(char[] pwd) {
		ChangePassword changePwd = new ChangePassword(dbManipulator);
		return changePwd.changePassword(currentUser.getUsername(), pwd);
	}
	/**
	 * Request a new temporary password.
	 * @param email the users registered email address.
	 * @return true if the request was completed successfully.
	 */
	public boolean requestNewPwdEmail(String email) {
		RequestNewPwd rnp = new RequestNewPwd(dbManipulator, email);
		return rnp.execute();
	}
	/**
	 * Request a new temporary password.
	 * @param username the users registered user-name to the system.
	 * @return true if the request was completed successfully.
	 */
	public boolean requestNewPwdUsername(String username) {
		RequestNewPwd rnp = new RequestNewPwd(dbManipulator, username);
		return rnp.execute();
	}
	/**
	 * Adds a new user to the system.
	 * @param addUser {@link AddUser} object containing the needed data.
	 * @return true if the user was added successfully.
	 */
	public boolean addUser(AddUser addUser) {
		AddUserLogic aul = new AddUserLogic(addUser, dbManipulator, hash);
		return aul.addUser();
	}
	/**
	 * Adds a new user to the system.
	 * @param userName String containing the user-name.
	 * @param firstName String containing the users first-name.
	 * @param lastName String containing the users last-name.
	 * @param pwd char[] containing the password.
	 * @param isAdmin boolean true if the user should have admin-rights in the system.
	 * @return true if the user was added successfully.
	 */
	public boolean addUser(String userName, String firstName, String lastName, char[] pwd, boolean isAdmin) {
		return addUser(new AddUser(userName, firstName, lastName, pwd, isAdmin));
	}
	/**
	 * Imports data from kronox using a selected period.
	 * @param examImportSelection {@link ExamImportSelectionTO} containing the needed data.
	 * @return List of {@link ExamOccationTO} for the selected period.
	 */
	public List<ExamOccationTO> readSchemaFromKronox(ExamImportSelectionTO examImportSelection) {
		KronoxImporter kronoxImporter = new KronoxImporter(examImportSelection);
		kronoxImporter.executeImport();
		return kronoxImporter.getImportedData();
	}
	/**
	 * Stores kronox-data that have been modified by the user to the database. 
	 * @param arrList List of {@link ExamOccationTO} containing the data that shall be stored in the database.
	 * @return true if the data was stored successfully.
	 */
	public boolean importSchemaData(List<ExamOccationTO> arrList) {
		ImportSchemaData isd = new ImportSchemaData(dbManipulator, arrList);
		return isd.execute();
	}
	/**
	 * Updates personal data of the currently logged in user.
	 * @param updateUser {@link UpdateUserTransfere} containing the data to update.
	 * @return true if the data was updated successfully.
	 */
	public boolean uppdateUser(UpdateUserTransfere updateUser) {
		UpdateUserLogic updateUserLogic= new UpdateUserLogic(currentUser, updateUser, dbManipulator);
		return updateUserLogic.uppdateUser();
	}
	/**
	 * Updates personal data of the currently logged in user.
	 * @param firstName String
	 * @param lastName String
	 * @param email String
	 * @param retypeEmail String
	 * @param civicNr String
	 * @param mobileNr String
	 * @param phoneNr String
	 * @param city String
	 * @param address String
	 * @param zipCode String
	 * @param isActive boolean if the user is currently an active user of the system.
	 * @param isAdmin boolean
	 * @return true if the data was updated successfully.
	 */
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
