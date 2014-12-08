package examProject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSelect {
	private JdbcConnect jdbc = new JdbcConnect();
	private Connection c;
	private Statement s;
	private ResultSet rs;
	
	public DbSelect(){
		this.c = jdbc.getC();
		this.s = jdbc.getS();
		this.rs = jdbc.getRs();
	}
	
	
	public ResultSet select(String selectCommand){
		ResultSet result = null;
		try{
			c = jdbc.openDbConnection(c);
			s = c.createStatement();
		    rs = s.executeQuery(selectCommand);
		    result = rs;

		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			//System.exit(0);
		}finally {
			jdbc.closeDbConnection(c);
		}
		System.out.println("Operation done successfully");
		return result;
	}
	public void close(){
	    try {
			rs.close();
			s.close();
		    c.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	    
	}

}
