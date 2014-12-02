package examProject.logic.requestNewPassword;

import java.sql.ResultSet;
import examProject.ActiveUser;
import examProject.dao.DbSelect;
import examProject.dao.GetEmailAddress;
import examProject.logic.LogicStrategy;

public class requestNewPwd implements LogicStrategy {
	private ActiveUser au;
	private DbSelect dbSelectExecutor;
	private String input;
	private GetEmailAddress getEmailAdress = new GetEmailAddress();
	
	public requestNewPwd(ActiveUser au, DbSelect dbSelectExecutor, String input) {
		this.au = au;
		this.dbSelectExecutor = dbSelectExecutor;
		this.input = input;
	}
	
	@Override
	public boolean execute() {
		boolean result = false;
		ResultSet rs = new ResultSet();
		
		return result;
	}

}
