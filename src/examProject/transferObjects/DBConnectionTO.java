package examProject.transferObjects;

public class DBConnectionTO {
	private String usernames;
	private String databaseDriver;
	private String databasePath;
	private String databasePort;
	private String mailServerPath;
	private String databaseName;
	private boolean firstTimeLaunch;
		
	public DBConnectionTO(){
	}
	
	public String getDatabaseName() {
		return databaseName; 
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
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
	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}

	public void setDatabaseDriver(String databaseDriver) {
		this.databaseDriver = databaseDriver;
	}

	public void setDatabasePath(String databasePath) {
		this.databasePath = databasePath;
	}

	public void setDatabasePort(String databasePort) {
		this.databasePort = databasePort;
	}

	public void setMailServerPath(String mailServerPath) {
		this.mailServerPath = mailServerPath;
	}

	public void setFirstTimeLaunch(boolean firstTimeLaunch) {
		this.firstTimeLaunch = firstTimeLaunch;
	}
}
