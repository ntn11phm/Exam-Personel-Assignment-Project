package examProject.logic;

import java.sql.ResultSet;

import examProject.dao.DbInsert;
import examProject.dao.DbSelect;

public class AddUserLogic {
	private AddUser au;
	private DbSelect dBs;
	private DbInsert dBi;
	
	public AddUserLogic(AddUser au, DbSelect dBs, DbInsert dBi){
		this.au = au;
		this.dBs = dBs;
		this.dBi = dBi;
	}
	public boolean addUser(){
		boolean result = false;
		String sqlCommand = "SELECT username FROM users WHERE username = '" + au.getUserName() + "';";
		ResultSet rs = dBs.select(sqlCommand);
		try{
			
			
		}catch(Exception e){
			
		}
		return result;
	}
	

}
