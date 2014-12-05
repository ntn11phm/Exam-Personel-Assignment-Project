package examProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbSelect {
	private JdbcConnect jdbc = new JdbcConnect();
	private Connection c = null;
    private PreparedStatement sel = null;
	
	public DbSelect(){
	}
	
	public DbSelect(Connection c){
		this.c = c;
	}
	
	public void setC(Connection c) {
		this.c = c;
	}
	
	public ResultSet select(String selectCommand){
		ResultSet result = null;
		try{
			c = jdbc.openDbConnection(c);
			sel = c.prepareStatement(selectCommand);
		    ResultSet rs = sel.executeQuery();
		    result = rs;
		    rs.close();
		    sel.close();
		    c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			//System.exit(0);
		}finally {
			jdbc.closeDbConnection(c);
		}
		//System.out.println("Operation done successfully");
		return result;
	}

}
