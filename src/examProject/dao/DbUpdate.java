package examProject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUpdate {
	Statement upd = null;
	Connection c = null;

	public DbUpdate() {
	}

	public void setC(Connection c) {
		this.c = c;
	}

	public void update() {
		try {
			upd = c.createStatement();
			String sql = "UPDATE ? set ?=?where ?;";
			upd.executeUpdate(sql);
			c.commit();

			ResultSet rs = upd.executeQuery("SELECT * FROM ?;");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				System.out.println("blablabla");
			}
			rs.close();
			upd.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}

}
