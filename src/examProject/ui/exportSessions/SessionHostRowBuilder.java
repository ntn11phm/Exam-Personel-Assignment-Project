package examProject.ui.exportSessions;

import java.util.List;
import javax.swing.JTextArea;
import examProject.transferObjects.HostSessionDataTO;

public class SessionHostRowBuilder {
	private JTextArea output;
	
	public SessionHostRowBuilder(JTextArea output) {
		this.output = output;
	}
	
	public void addSessionsToTextArea(List<HostSessionDataTO> arr) {
		HostSessionDataTO session = new HostSessionDataTO("", "", "", "", "", false);
		if (arr!=null || arr.size()!=0) {
				String row = "";
				for (int i = 0; i < arr.size(); i++)
					if (i == 0) {
						session = arr.get(i);
						row = session.getDate() + ", " + session.getTime() + ", " + session.getFirstname() + ", " + session.getLastname() + ", " + session.isResponsible(); 
					} else if (session.compareTo(arr.get(i))==0) {
						session = arr.get(i);
						row += ", " + session.getFirstname() + ", " + session.getLastname() + ", " + session.isResponsible();
					} else {
						output.setText(output.getText() + row + "\n");
						row = "";
						session = arr.get(i);
						row = session.getDate() + ", " + session.getTime() + ", " + session.getFirstname() + ", " + session.getLastname() + ", " + session.isResponsible();
					}
		}
	}
}
