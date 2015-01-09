package examProject.transferObjects;
/**
 * Transferobject containing data needed to create the connection-string
 * @author Per Hedblom
 * @author Silvana Yacob
 */
public class DBConnectionTO {
	private String databaseDriver;
	private String databasePath;
	private String databasePort;
	private String databaseName;
	private boolean firstTimeLaunch;
	/**
	 * Getter for the database name.
	 * @return {@link String}
	 */
	public String getDatabaseName() {
		return databaseName; 
	}
	/**
	 * Setter for the database name.
	 * @param databaseName {@link String}
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	/**
	 * Getter for the database driver.
	 * @return {@link String}
	 */
	public String getDatabaseDriver() {
		return databaseDriver;
	}
	/**
	 * Getter for the database URL.
	 * @return {@link String}
	 */
	public String getDatabasePath() {
		return databasePath;
	}
	/**
	 * Getter for the port to the database.
	 * @return {@link String}
	 */
	public String getDatabasePort() {
		return databasePort;
	}
	/**
	 * Getter for the flag checking if the setup has been done before.
	 * @return {@link boolean}
	 */
	public boolean isFirstTimeLaunch() {
		return firstTimeLaunch;
	}
	/**
	 * Setter for the database driver.
	 * @param databaseDriver {@link String}
	 */
	public void setDatabaseDriver(String databaseDriver) {
		this.databaseDriver = databaseDriver;
	}
	/**
	 * Setter for the URL to the database.
	 * @param databasePath {@link String}
	 */
	public void setDatabasePath(String databasePath) {
		this.databasePath = databasePath;
	}
	/**
	 * Setter of the port to the database.
	 * @param databasePort {@link String}
	 */
	public void setDatabasePort(String databasePort) {
		this.databasePort = databasePort;
	}
	/**
	 * Setter for the flag  checking if the setup has been done before.
	 * @param firstTimeLaunch {@link boolean}
	 */
	public void setFirstTimeLaunch(boolean firstTimeLaunch) {
		this.firstTimeLaunch = firstTimeLaunch;
	}
}
