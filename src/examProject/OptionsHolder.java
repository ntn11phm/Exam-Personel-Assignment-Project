package examProject;

public class OptionsHolder {
	private String username;
	private String databaseDriver;
	private String databasePath;
	private String databasePort;
	private String databaseName;
	private String mailServerPath;
	
	public OptionsHolder(String username, String databaseDriver, String databasePath, String databasePort, String databaseName, String mailServerPath) {
		this.username = username;
		this.databaseDriver = databaseDriver;
		this.databasePath = databasePath;
		this.databasePort = databasePort;
		this.databaseName = databaseName;
		this.mailServerPath = mailServerPath;
	}

	public String getUsername() {
		return username;
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

	public String getDatabaseName() {
		return databaseName;
	}

	public String getMailServerPath() {
		return mailServerPath;
	}
	
}
