package examProject.logic.exportSessions;

import java.sql.ResultSet;
import java.sql.SQLException;

import examProject.dao.DbManipulator;

public class ExportSessions {
	private DbManipulator dbManipulator;
	
	public ExportSessions(DbManipulator dbManipulator) {
		this.dbManipulator = dbManipulator;
	}
	
	public boolean exportSessions(String fromDate, String toDate, String path) {
		boolean result = false;
		String selectCommand = "SELECT ";
		ResultSet rs = dbManipulator.select(selectCommand);
		try {
			while(rs.next()) {
				
			}
			rs.close();
		} catch (SQLException e) {}
		return result;
	}
}
