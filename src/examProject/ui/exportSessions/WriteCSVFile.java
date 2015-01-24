package examProject.ui.exportSessions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WriteCSVFile {
	private JPanel panel;
	private JTextArea outputArea;
	private String fromDate;
	private String toDate;
	private String path;
	private boolean writeMode = true;

	public WriteCSVFile(String fromDate, String toDate, String path, JTextArea outputArea, JPanel panel) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.path = path;
		this.outputArea = outputArea;
		this.panel = panel;
	}

	public boolean writeFile() {
		boolean result = false;
		String fileName = "Export_" + fromDate + "_" + toDate + ".csv";
		
		return result;
	}
	
	private void fileWrite(FileWriter fstream, String row) {
		try {
			fstream.write(row + "\n");
			fstream.flush();
			fstream.close();
		} catch (IOException e) {}
	}
	
	private boolean checkFileExists(String fileName) {
		File tmp = new File(path + fileName); 
		if (tmp.exists()) {
			JOptionPane optionPane = new JOptionPane ("Filen finns redan, skriva över ?", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
			if (Integer.parseInt(optionPane.getValue().toString()) == JOptionPane.YES_OPTION) {
				
//			} else if (optionPane.getValue() == JOptionPane.NO_OPTION) {
				
			}
		} else {
			try {
				tmp.createNewFile();
			} catch (IOException e) {}
		}
		
		return true;
	}
}
