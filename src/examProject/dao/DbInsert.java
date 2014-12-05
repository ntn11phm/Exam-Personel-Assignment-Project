package examProject.dao;

import java.sql.Statement;
import java.sql.*;


public class DbInsert {
	JdbcConnect jdbc = new JdbcConnect();
	Statement ins = null;
	Connection c = null;

	public DbInsert(Connection c) {
		this.c = c;
	}

	public boolean insert(String sqlCommand) {
		boolean result = false;
		try {
			jdbc.openDbConnection(c);
			c.setAutoCommit(false);
			ins = c.createStatement();
			//String sqlCommand = "INSERT INTO exam_occasion (exam_date, exam_time, exam_location, booking_id) " + "VALUES ('20140613', '0900', 96243, 'b14');";
			ins.executeUpdate(sqlCommand);
			ins.close();
			c.commit();
			result = true;
		} catch (Exception e) {
			//System.err.println(e.getClass().getName() + ": " + e.getMessage());
			//System.exit(0);
		}finally {
			jdbc.closeDbConnection(c);
		}
		//System.out.println("Records created successfully");
		return result;
	}

}