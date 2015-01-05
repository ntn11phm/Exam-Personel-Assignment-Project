package examProject.dao;

import java.sql.*;

import examProject.transferObjects.DBConnectionTO;
import examProject.ui.firstTimeSetup.FirstTimeLaunchLogic;

/**
 * 
 * @author Code skeleton
 *         http://www.tutorialspoint.com/postgresql/postgresql_java.htm
 *
 */
public class JdbcConnect {
	private Connection c = null;
	private DBConnectionTO dbConnectionTo ;
	private String username;
	private String pwd;
	
	public JdbcConnect(DBConnectionTO dbConnectionTo){
		this.dbConnectionTo= dbConnectionTo;
		FirstTimeLaunchLogic ftl = new FirstTimeLaunchLogic();
		ftl.openFile();
		username = ftl.getUsername();
		pwd = ftl.getPwd();
	}
	public Connection getC() {
		return c;
	}

	public Connection openDbConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:" + dbConnectionTo.getDatabaseDriver() 
					+ "://" + dbConnectionTo.getDatabasePath() 
					+ ":" + dbConnectionTo.getDatabasePort() 
					+ "/" + dbConnectionTo.getDatabaseName(), username, pwd);
		} catch (Exception e) {}
		
		return c;
	}

	public boolean closeDbConnection(Connection con) {
		try {
			con.close();
			con = null;
		} catch (Exception e) {
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {	}
		}
		return true;
	}
}
