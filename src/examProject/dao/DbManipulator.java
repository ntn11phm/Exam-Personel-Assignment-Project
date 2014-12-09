package examProject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManipulator {
	private JdbcConnect jdbc = new JdbcConnect();
	private Connection con;
	private ResultSet rs;
	private Statement state;

	public DbManipulator() {
		this.state = jdbc.getS();
		this.con = jdbc.getC();
		this.rs = jdbc.getRs();
	}

	public ResultSet select(String selectCommand) {
		ResultSet result = null;
		try {
			state = con.createStatement();
			rs = state.executeQuery(selectCommand);
			result = rs;
			System.out.println("Operation done successfully");
		} catch (Exception e) {}
		return result;
	}

	public boolean insert(String sqlCommand) {
		boolean result = false;
		try {
			con.setAutoCommit(false);
			state = con.createStatement();
			state.executeUpdate(sqlCommand);
			con.commit();
			result = true;
			System.out.println("Records created successfully");
		} catch (Exception e) {}
		return result;
	}

	public boolean update() {
		boolean result = false;

		return result;
	}

	public boolean openDb() {
		boolean open = false;
		con = jdbc.openDbConnection();
		if (con != null)
			open = true;
		return open;
	}

	public boolean closeDb() {
		try {
			rs.close();
			state.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		boolean close = jdbc.closeDbConnection(con);

		return close;
	}

}
