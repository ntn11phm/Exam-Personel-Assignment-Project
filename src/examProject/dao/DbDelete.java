package examProject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbDelete {

	Statement del = null;
	Connection c = null;

	public DbDelete() {
	}

	public void setC(Connection c) {
		this.c = c;
	}

	public void delete() {
		try {
			del = c.createStatement();
			String sql = "DELETE from ? where ?;";
			del.executeUpdate(sql);
			c.commit();

			ResultSet rs = del.executeQuery("SELECT * FROM ?;");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				System.out.println("blablabla");

			}
			rs.close();
			del.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation completeted successfully");
	}

}
