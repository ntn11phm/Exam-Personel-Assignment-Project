package examProject.dao;

import java.sql.*;

/**
 * 
 * @author Code skeleton
 *         http://www.tutorialspoint.com/postgresql/postgresql_java.htm
 *
 */
public class JdbcConnect {
	private Connection c = null;

	public Connection getC() {
		return c;
	}

	public Statement getS() {
		return s;
	}

	public ResultSet getRs() {
		return rs;
	}

	private Statement s = null;
	private ResultSet rs = null;

	public Connection openDbConnection(Connection c) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Tentamensprojekt",
					"postgres", "Destroyer");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.err.println(e.getClass().getName() + ": " +
			// e.getMessage());
			// System.exit(0);
		}
		System.out.println("Opened database successfully");
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
				if (rs != null)
					rs.close();
				if (s != null)
					s.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}

		}
		System.out.println("Closed database successfully");
		return true;
	}
}
