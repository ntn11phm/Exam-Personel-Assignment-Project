package examProject.dao;

import java.sql.*;


public class DbInsert {
	JdbcConnect jdbc = new JdbcConnect();
	Connection c = null;
	PreparedStatement ins = null;

	public DbInsert(Connection c) {
		this.c = c;
	}

	public boolean insert(String sqlCommand) {
		boolean result = false;
		try {
			c = jdbc.openDbConnection(c);
			c.setAutoCommit(false);
			ins = c.prepareStatement(sqlCommand);
			//String sqlCommand = "INSERT INTO exam_occasion (exam_date, exam_time, exam_location, booking_id) " + "VALUES ('20140613', '0900', 96243, 'b14');";
			ins.executeUpdate();
			ins.close();
			c.commit();
			result = true;
		} catch (Exception e) {
			//System.err.println(e.getClass().getName() + ": " + e.getMessage());
			//System.exit(0);
		}finally {
			jdbc.closeDbConnection(c);
		}
		System.out.println("Records created successfully");
		return result;
	}

}