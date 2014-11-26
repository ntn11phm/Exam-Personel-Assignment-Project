package examProject.dao;

import java.sql.Connection;

public class MainConnect {
	public static void main(String args[]) {
		JdbcConnect con = new JdbcConnect();
		//DbInsert insert = new DbInsert();
		Connection c = null;
		c = con.openDbConnection(c);
		//insert.setC(c);
		//insert.insert();
		con.closeDbConnection(c);

	}

}
