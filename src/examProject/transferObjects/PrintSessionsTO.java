package examProject.transferObjects;

import java.util.List;

public class PrintSessionsTO {
	
	private String sessionTime;
	private String sessionLocation;
	
	public PrintSessionsTO(String sessionTime, String sessionLocation){
		this.sessionTime = sessionTime;
		this.sessionLocation = sessionLocation;
		
	}
	public String getSessionTime(){
		return sessionTime;
	}
	public String getSessionLocation(){
		return sessionLocation;
	}
	
	public String toString(List<PrintSessionsTO> printSessionsList) {
		return "" + sessionTime + "   " + sessionLocation;
	}

}
