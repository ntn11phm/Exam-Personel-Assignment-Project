package examProject.dao;

import java.sql.Statement;
import java.sql.*;


public class DbInsert {
	Statement ins = null;
	Connection c = null;

	public DbInsert() {
	}

	public void setC(Connection c) {
		this.c = c;
	}

	public void insert() {
		try {
			c.setAutoCommit(false);
			ins = c.createStatement();
			String sql = "INSERT INTO exam_occasion (exam_date, exam_time, exam_location, booking_id) " + "VALUES ('20140613', '0900', 96243, 'b14');";
			ins.executeUpdate(sql);
			ins.close();
			c.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}

}