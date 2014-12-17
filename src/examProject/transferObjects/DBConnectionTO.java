package examProject.transferObjects;

public class DBConnectionTO {
	private String usernames;
	private String databaseDriver;
	private String databasePath;
	private String databasePort;
	private String mailServerPath;
	private boolean firstTimeLaunch;
	
	public DBConnectionTO(String username, String databaseDriver, String databasePath, String databasePort, String mailServerPath, boolean firstTimeLaunch){
		this.usernames = username;
		this.databaseDriver = databaseDriver;
		this.databasePath = databasePath;
		this.databasePort = databasePort;
		this.mailServerPath = mailServerPath;
		this.firstTimeLaunch = firstTimeLaunch;
	}

	public String getUsernames() {
		return usernames;
	}

	public String getDatabaseDriver() {
		return databaseDriver;
	}

	public String getDatabasePath() {
		return databasePath;
	}

	public String getDatabasePort() {
		return databasePort;
	}

	public String getMailServerPath() {
		return mailServerPath;
	}

	public boolean isFirstTimeLaunch() {
		return firstTimeLaunch;
	}



}
