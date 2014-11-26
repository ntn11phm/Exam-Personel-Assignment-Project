package examProject.dao;

import java.sql.*;

/**
 * 
 * @author Code skeleton
 *         http://www.tutorialspoint.com/postgresql/postgresql_java.htm
 *
 */
public class JdbcConnect {
	Connection c = null;

	public Connection openDbConnection(Connection c) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Tentamensprojekt",
					"postgres", "Destroyer");
		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return c;
	}

	public boolean closeDbConnection(Connection con) {
		try {
			con.close();
			con = null;
		} catch (Exception e) {
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(0);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException se2) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
//				se.printStackTrace();
			}
		}
//		System.out.println("Closed database successfully");
		return true;
	}
}
