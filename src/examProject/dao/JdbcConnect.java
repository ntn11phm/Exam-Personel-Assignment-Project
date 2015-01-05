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
					"jdbc:" + dbConnectionTo.getDatabaseDriver() + "://" + dbConnectionTo.getDatabasePath() + ":" + dbConnectionTo.getDatabasePort() + "/" + dbConnectionTo.getDatabaseName(), 
					username, pwd);
			
			System.out.println("Opened database successfully");
		} 
		 
		// original kod nedan bara try-sats		
		/*
		 * try { Class.forName("org.postgresql.Driver");
		 * Class.forName(dbConnectionTo.getDatabaseDriver()); c =
		 * DriverManager.getConnection(
		 * "jdbc:postgresql://localhost:5432/Tentamensprojekt", "postgres",
		 * "Destroyer"); System.out.println("Opened database successfully"); }
		 */ 
		
		catch (Exception e) {}
		
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
				System.out.println("Closed database successfully");
			} catch (SQLException se) {	}
		}
		
		return true;
	}
}
