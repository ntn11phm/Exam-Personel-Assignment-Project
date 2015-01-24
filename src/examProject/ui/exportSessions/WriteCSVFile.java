package examProject.ui.exportSessions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class WriteCSVFile {
	private JTextArea outputArea;
	private String fromDate;
	private String toDate;
	private String path;

	public WriteCSVFile(String fromDate, String toDate, String path, JTextArea outputArea) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.path = path;
		this.outputArea = outputArea;
	}

	public boolean writeFile() {
		boolean result = false;
		String fileName = "Export_" + fromDate + "_" + toDate + ".csv";
		if (checkFileExists(fileName)) {
			fileWrite(fileName);
			result = true;
		}
		return result;
	}
	
	private void fileWrite(String fileName) {
		File file = new File(path + File.separator + fileName);
		String source = outputArea.getText();
        System.out.println(source);
        try {
        	FileWriter f2 = new FileWriter(file, false);
        	f2.write(source);
            f2.close();
        } catch (IOException e) {}           
	}
	
	private boolean checkFileExists(String fileName) {
		File tmp = new File(path + File.separator + fileName);
		if (tmp.exists()) {
			int answer = JOptionPane.showConfirmDialog(null, "Filen finns redan, skriva över ?", "Skriva över ?", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				tmp.delete();
				return true;
			} else
				return false;
		} else {
			return true;
		}
	}
}
