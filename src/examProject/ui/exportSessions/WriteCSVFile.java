package examProject.ui.exportSessions;

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

	public void writeFile() {
		
	}
}
