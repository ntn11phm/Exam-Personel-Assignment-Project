package examProject.transferObjects;

public class PrintSessionsTO {
	
	private String sessionTime;
	private String sessionLocation;
	private int sessionId;
	
	public PrintSessionsTO(String sessionTime, String sessionLocation, int sessionId){
		this.sessionTime = sessionTime;
		this.sessionLocation = sessionLocation;
		this.sessionId = sessionId;
		
	}
	public String getSessionTime(){
		return sessionTime;
	}
	public String getSessionLocation(){
		return sessionLocation;
	}
	public int getSessionId(){
		return sessionId;
	}
	
	public String toString() {
		return "" + sessionTime + "   " + sessionLocation;
	}

}
