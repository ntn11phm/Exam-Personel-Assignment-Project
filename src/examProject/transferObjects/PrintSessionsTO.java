package examProject.transferObjects;
/**
 * Transferobject for the printing of sessions
 * @author Magnus Eklund
 *
 */
public class PrintSessionsTO {
	private String sessionTime;
	private String sessionLocation;
	private int sessionId;
	/**
	 * Constructor.
	 * @param sessionTime {@link String} valid values: "08:00" or "15:00".
	 * @param sessionLocation {@link String}
	 * @param sessionId {@link int}
	 */
	public PrintSessionsTO(String sessionTime, String sessionLocation, int sessionId){
		this.sessionTime = sessionTime;
		this.sessionLocation = sessionLocation;
		this.sessionId = sessionId;
		
	}
	/**
	 * Getter for the session time.
	 * @return {@link String}
	 */
	public String getSessionTime(){
		return sessionTime;
	}
	/**
	 * Getter for the session location.
	 * @return {@link String}
	 */
	public String getSessionLocation(){
		return sessionLocation;
	}
	/**
	 * Getter for the session id.
	 * @return {@link int}
	 */
	public int getSessionId(){
		return sessionId;
	}
	/**
	 * Prints: sessiontime   sessionlocation
	 */
	@Override
	public String toString() {
		return "" + sessionTime + "   " + sessionLocation;
	}
}
