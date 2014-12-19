package examProject.dao;

import java.sql.*;

import examProject.transferObjects.DBConnectionTO;

/**
 * 
 * @author Code skeleton
 *         http://www.tutorialspoint.com/postgresql/postgresql_java.htm
 *
 */
public class JdbcConnect {
	private Connection c = null;
//	private Statement s = null;
//	private ResultSet rs = null;
	private DBConnectionTO dbConnectionTo ;
	
	public JdbcConnect(DBConnectionTO dbConnectionTo){
		this.dbConnectionTo= dbConnectionTo;
	
	}
	public Connection getC() {
		return c;
	}
//
//	public Statement getS() {
//		return s;
//	}
//
//	public ResultSet getRs() {
//		return rs;
//	}

	public Connection openDbConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:" + dbConnectionTo.getDatabaseDriver() + "://" + dbConnectionTo.getDatabasePath() + ":" + dbConnectionTo.getDatabasePort() + "/" + dbConnectionTo.getDatabaseName(), 
					"postgres", "Destroyer");
			
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
		
		catch (Exception e) {
			// e.printStackTrace();
			// System.err.println(e.getClass().getName() + ": " +
			// e.getMessage());
			// System.exit(0);
		}
		
		return c;
	}

	public boolean closeDbConnection(Connection con) {
		try {
			con.close();
			con = null;
		} catch (Exception e) {
			// System.err.println(e.getClass().getName() + ": " +
			// e.getMessage());
			// System.exit(0);
		} finally {
			try {
//				if (rs != null)
//					rs.close();
//				if (s != null)
//					s.close();
				if (con != null)
					con.close();
				System.out.println("Closed database successfully");
			} catch (SQLException se) {
			}

		}
		
		return true;
	}
}
