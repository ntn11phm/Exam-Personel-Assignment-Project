package examProject.logic;

/**
 * BackendFacade for the Exam-Personel-Assignment-Project.
 * @author Magnus Eklund
 * @author Per Hedblom
 * @author Silvana Yacob
 */

import java.util.List;

import examProject.dao.DbManipulator;
import examProject.logic.answerInv.AnswerInvitation;
import examProject.logic.changePassword.ChangePassword;
import examProject.logic.createInv.CreateInvitation;
import examProject.logic.importSchemaData.ImportSchemaData;
import examProject.logic.login.Login;
import examProject.logic.mail.Emailto;
import examProject.logic.mail.Mail_Interface;
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
import examProject.transferObjects.ShowHostsInfoTransfere;
import examProject.transferObjects.UpdateUserTransfere;
import examProject.transferObjects.LoggedInUserTO;
import examProject.ui.updateUserInformation.SetupIncompleteException;

public class BackendFacade {
	private DbManipulator dbManipulator;
	private LoggedInUserTO currentUser;
	private Password_interface hash;
	private Mail_Interface email_eng;
	
	/**
	 * Constructor
	 * @param currentUser {@link LoggedInUserTO} containing data about the user that has logged in.
	 * @throws {@link SetupIncompleteException} if the configuration files are missing the data needed to connect to the database.
	 */
	public BackendFacade(LoggedInUserTO currentUser) throws SetupIncompleteException {
		this(currentUser, new PasswordHashingLocal(), new Emailto());
	}
	/**
	 * Constructor
	 * @param currentUser {@link LoggedInUserTO} containing data about the user that has logged in.
	 * @param hash injection of a hashing function that implements {@link Password_interface}.
	 * @throws {@link SetupIncompleteException} if the configuration files are missing the data needed to connect to the database.
	 */
	public BackendFacade(LoggedInUserTO currentUser, Password_interface hash) throws SetupIncompleteException {
		this(currentUser, hash, new Emailto());		
	}
	public BackendFacade(LoggedInUserTO currentUser, Mail_Interface email_eng) throws SetupIncompleteException {
		this(currentUser, new PasswordHashingLocal(), email_eng);
	}
	public BackendFacade(LoggedInUserTO currentUser, Password_interface hash, Mail_Interface email_eng) throws SetupIncompleteException {
		this.currentUser = currentUser;
		createDbObjects();
		this.hash = hash;
		this.email_eng = email_eng;
	}
	/**
	 * Creates the need objects to create a connection to the database.
	 * @throws {@link SetupIncompleteException} if the configuration files are missing the data needed to connect to the database.
	 */
	private void createDbObjects() throws SetupIncompleteException {
		OptionsFileReader optionsFileReader = new OptionsFileReader();
		optionsFileReader.readOptionFile();
		this.dbManipulator = new DbManipulator(optionsFileReader.getConnTO()); 
	} 
	/**
	 * Change password for the user who is logged in.
	 * @param pwd {@link char[]} containing the password.
	 * @return true if the password was stored correctly.
	 */
	public boolean changePwd(char[] pwd) {
		ChangePassword changePwd = new ChangePassword(dbManipulator);
		return changePwd.changePassword(currentUser.getUsername(), pwd);
	}
	/**
	 * Request a new temporary password.
	 * @param email {@link String} the users registered email address.
	 * @return true if the request was completed successfully.
	 */
	public boolean requestNewPwdEmail(String email) {
		RequestNewPwd rnp = new RequestNewPwd(dbManipulator, email, email_eng);
		return rnp.execute();
	}
	/**
	 * Request a new temporary password.
	 * @param username {@link String} the users registered user-name to the system.
	 * @return true if the request was completed successfully.
	 */
	public boolean requestNewPwdUsername(String username) {
		RequestNewPwd rnp = new RequestNewPwd(dbManipulator, username, email_eng);
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
	 * @param userName {@link String} containing the user-name.
	 * @param firstName {@link String} containing the users first-name.
	 * @param lastName {@link String} containing the users last-name.
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
	 * @return {@link List} of {@link ExamOccationTO} for the selected period.
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
	 * @param firstName {@link String}
	 * @param lastName {@link String}
	 * @param email {@link String}
	 * @param retypeEmail {@link String}
	 * @param civicNr {@link String}
	 * @param mobileNr {@link String}
	 * @param phoneNr {@link String}
	 * @param city {@link String}
	 * @param address {@link String}
	 * @param zipCode {@link String}
	 * @param isActive boolean if the user is currently an active user of the system.
	 * @param isAdmin boolean
	 * @return true if the data was updated successfully.
	 */
	public boolean uppdateUser(String firstName, String lastName, String email, String retypeEmail, String civicNr, String mobileNr, String phoneNr, String city, String address, String zipCode,boolean isActive, boolean isAdmin) {
		return uppdateUser(new UpdateUserTransfere(firstName, lastName, email, retypeEmail, city, address, mobileNr, phoneNr, zipCode, civicNr, isActive, isAdmin));
	}
	/**
	 * Login to the system.
	 * @param username String
	 * @param pwd char[]
	 * @return {@link LoggedInUserTO} containing data about the logged in user.
	 */
	public LoggedInUserTO login(String username, char[] pwd) {
		Login login = new Login(dbManipulator, hash);
		currentUser = login.login(username, pwd); 
		return currentUser;
	}
	/**
	 * Lists all invitations that are up-to-date for the user logged in to the system.
	 * @return {@link List} of {@link HsiTO} with all up-to-date invitations.
	 */
	public List<HsiTO> getHsiList() {
		AnswerInvitation ai = new AnswerInvitation(dbManipulator, currentUser);
		return ai.getInvitations();
	}
	/**
	 * Stores the logged in users answer to invitations.
	 * @param answerList {@link List} of {@link HsiTO} with the users answers to invitations.
	 * @return true if the data was stored successfully.
	 */
	public boolean commitInvitationAnswers(List<HsiTO> answerList) {
		AnswerInvitation ai = new AnswerInvitation(dbManipulator, currentUser);
		return ai.commitAnswers(answerList);
	}
	/**
	 * Returns a list of hosts that are available at a specific date and time.
	 * @param date String with date-format yyyy-MM-dd.
	 * @param time String but either "08:00" or "15:00".
	 * @return {@link List} of {@link HostTO} with the available hosts.
	 */
	public List<HostTO> getAvailableHostsList(String date, String time) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.loadAvailableHosts(date, time);
	}
	/**
	 * Check if a host already has been assigned to a session.
	 * @param date String with date-format yyyy-MM-dd.
	 * @param time String but either "08:00" or "15:00".
	 * @param host_id int
	 * @return true if the host is available.
	 */
	public boolean checkHostSessionAvailabillity(String date, String time, int host_id) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.checkHostSessionAvailabillity(date, time, host_id);
	}
	/**
	 * Creates session-invitations for active hosts.
	 * @param sessionList {@link}List of {@link HsiTO}.
	 * @return true if the session-invitations was done successfully.
	 */
	public boolean createHsi(List<HsiTO> sessionList) {
		CreateInvitation ci = new CreateInvitation(dbManipulator);
		return ci.createHsi(sessionList);
	}
	/**
	 * List all locations that are booked for a specific date and time.
	 * @param date String with date-format yyyy-MM-dd.
	 * @param time String but either "08:00" or "15:00".
	 * @return {@link List} of {@link SessionLocationTO}
	 */
	public List<SessionLocationTO> loadLocations(String date, String time) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.loadLocations(date, time);
	}
	/**
	 * List all sessions between two dates.
	 * @param cTo {@link CreateInvitationTO}
	 * @return {@link List} of {@link HsiTO}
	 */
	public List<HsiTO> getSessions(CreateInvitationTO cTo) {
		CreateInvitation ci = new CreateInvitation(dbManipulator);
		return ci.getSessions(cTo);
	}
	/**
	 * List all sessions on a specific date.
	 * @param date String with date-format yyyy-MM-dd.
	 * @return {@link List} of {@link PrintSessionsTO}
	 */
	public List<PrintSessionsTO> getSessions(String date){
		PrintSessions ps = new PrintSessions(dbManipulator);
		return ps.getSessions(date);
	}
	/**
	 * List all hosts for a specific session id.
	 * @param sessionId int
	 * @return {@link List} of {@link HostTO}
	 */
	public List<HostTO> getHostsForSession(int sessionId) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.getHostsForSession(sessionId);
	}
	/**
	 * Stores data to host_sessions relation.
	 * @param currentList {@link List} of {@link HostSessionTO}
	 * @return true if the data was stored successfully.
	 */
	public boolean storeToSessionHost(List<HostSessionTO> currentList) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.storeToSessionHost(currentList);
	}
	/**
	 * Removes data from the host_sessions relation.
	 * @param host_id int
	 * @param sessionId int
	 * @return true if the data was removed successfully.
	 */
	public boolean removeHostSessionPost(int host_id, int sessionId) {
		PopulateSessions ps = new PopulateSessions(dbManipulator);
		return ps.removeHostSessionPost(host_id, sessionId);
	}
	/**
	 * Loads host-information of the currently logged in host.
	 * @return {@link UpdateUserTransfere}
	 */
	public UpdateUserTransfere getCurrentHostData() {
		UpdateUserLogic uul = new UpdateUserLogic(currentUser, null, dbManipulator);
		return uul.getLogginUserData();
	}
	
	public boolean showHostsInfo(ShowHostsInfoTransfere showHostsInfo){
		ShowHostsInfoLogic showHostsinflogic = new ShowHostsInfoLogic(null, dbManipulator);
		return showHostsinflogic.ShowHostsInfo();
	}
	
	public boolean showHostsInfo(String firstName, String lastName, String email, String mobileNr, String phoneNr) {
		return showHostsInfo(new ShowHostsInfoTransfere(firstName, lastName));
		//return showHostsInfo(new ShowHostsInfoTransfere(firstName, lastName, email, mobileNr, phoneNr));
	}
	
	public ShowHostsInfoTransfere getCurrentHostDataShow(){
		ShowHostsInfoLogic showHostsInfo = new ShowHostsInfoLogic(null, dbManipulator);
		return showHostsInfo.getLogginUserData();
	}
}
