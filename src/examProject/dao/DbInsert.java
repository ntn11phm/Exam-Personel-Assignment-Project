package examProject.dao;

import java.sql.*;

public class DbInsert {
	JdbcConnect jdbc = new JdbcConnect();
	private Connection c;
	private Statement s;
	private ResultSet rs;

	public DbInsert(Connection c) {
		this.c = jdbc.getC();
		this.s = jdbc.getS();
		this.rs = jdbc.getRs();
	}

	public boolean insert(String sqlCommand) {
		boolean result = false;
		try {
			c = jdbc.openDbConnection(c);
			c.setAutoCommit(false);
			s = c.createStatement();
			// String sqlCommand =
			// "INSERT INTO exam_occasion (exam_date, exam_time, exam_location, booking_id) "
			// + "VALUES ('20140613', '0900', 96243, 'b14');";
			s.executeUpdate(sqlCommand);
			c.commit();
			result = true;
		} catch (Exception e) {
			// System.err.println(e.getClass().getName() + ": " +
			// e.getMessage());
			// System.exit(0);
		} finally {
			jdbc.closeDbConnection(c);
		}
		System.out.println("Records created successfully");
		return result;
	}

	public void close() {
		try {
			rs.close();
			s.close();
			c.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}