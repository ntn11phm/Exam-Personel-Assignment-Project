package examProject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import examProject.transferObjects.DBConnectionTO;

public class DbManipulator {
	private JdbcConnect jdbc;
	private Connection con;
	private ResultSet rs;
	private Statement state;

	public DbManipulator(DBConnectionTO dbConnectionTo) {
		this.jdbc = new JdbcConnect(dbConnectionTo);
		this.con = jdbc.getC();
	} 

	public ResultSet select(String selectCommand) {
		ResultSet result = null;
		try {
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = state.executeQuery(selectCommand);
			result = rs;
			System.out.println("Operation done successfully");
		} catch (Exception e) {}
		return result;
	}

	public boolean insert(String insertCommand) {
		boolean result = false;
		try {
			con.setAutoCommit(true);
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate(insertCommand);
			result = true;
			System.out.println("Records created successfully");
		} catch (Exception e) {System.out.println(e);}
		return result;
	}

	public boolean update(String updateCommand) {
		boolean result = false;
		try {
			con.setAutoCommit(true);
			state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate(updateCommand);
			result = true;
			System.out.println("Update successful");
		} catch (Exception e) {System.out.println(e);}

		return result;
	}
	
	public boolean delete(String deleteCommand) {
		boolean result = false;
		try {
			con.setAutoCommit(true);
			state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate(deleteCommand);
			result = true;
			System.out.println("Delete successfully done!");
		} catch (Exception e) {System.out.println(e);}
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
