package examProject.logic.requestNewPassword;

import examProject.ActiveUser;
import examProject.dao.DbSelect;
import examProject.logic.LogicStrategy;

public class requestNewPwd implements LogicStrategy {
	private ActiveUser au;
	private DbSelect dbSelectExecutor;
	private String input;
	
	public requestNewPwd(ActiveUser au, DbSelect dbSelectExecutor, String input) {
		this.au = au;
		this.dbSelectExecutor = dbSelectExecutor;
		this.input = input;
	}
	
	@Override
	public boolean execute() {
		boolean result = false;
		
		return result;
	}

}
