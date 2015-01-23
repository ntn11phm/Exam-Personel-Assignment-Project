package examProject.ui.exportSessions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import examProject.transferObjects.HostSessionDataTO;

public class WriteCSVFile {
	private List<HostSessionDataTO> arr;
	private String fromDate;
	private String toDate;
	private String path;

	public WriteCSVFile(String fromDate, String toDate, String path, List<HostSessionDataTO> arr) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.path = path;
		this.arr = arr;
	}

	public boolean writeFile() {
		boolean result = false;
		String fileName = "Export_" + fromDate + "_" + toDate + ".csv";
		HostSessionDataTO session = new HostSessionDataTO("", "", "", "", "", false);
		if (arr!=null) {
			try {
				FileWriter fstream = new FileWriter(new File(path, fileName));
				String row = "";
				for (int i = 0; i < arr.size(); i++) {
					if (i == 0) {
						session = arr.get(i);
						row = session.getDate() + ", " + session.getTime() + ", " + session.getFirstname() + ", " + session.getLastname() + ", " + session.isResponsible(); 
					} else if (session.compareTo(arr.get(i))==0) {
						// apend data to file here......
						session = arr.get(i);
						row += ", " + session.getFirstname() + ", " + session.getLastname() + ", " + session.isResponsible();
					} else {
						session = arr.get(i);
						row = session.getDate() + ", " + session.getTime() + ", " + session.getFirstname() + ", " + session.getLastname() + ", " + session.isResponsible();
					}
				}
			} catch (IOException e) {}
		}
		return result;
	}
	
	private void gfsdfg() {
		new File("").exists();
	}
}
