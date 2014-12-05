package examProject.logic;

import java.sql.Connection;
import java.util.List;

import examProject.dao.DbDelete;
import examProject.dao.DbInsert;
import examProject.dao.DbSelect;
import examProject.dao.DbUpdate;
import examProject.dao.JdbcConnect;
import examProject.logic.schemaReader.KronoxImporter;
import examProject.transferObjects.ExamImportSelectionTO;
import examProject.transferObjects.ExamOccationTO;

public class BackendFacade {
	private JdbcConnect con = new JdbcConnect();
	private Connection c = null;
	private DbSelect dbSelect;
	private DbUpdate dbUpdate;
	private DbInsert dbInsert;
	private DbDelete dbDelete;
	
	public BackendFacade() {
		c = con.openDbConnection(c);
		createDbObjects();
		con.closeDbConnection(c);
		
	}
	
	private void createDbObjects() {
		this.dbDelete = new DbDelete(c);
		this.dbInsert = new DbInsert(c);
		this.dbSelect = new DbSelect(c);
		this.dbUpdate = new DbUpdate(c);
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
		AddUserLogic aul = new AddUserLogic(addUser, dbSelect, dbInsert);
		
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
}
