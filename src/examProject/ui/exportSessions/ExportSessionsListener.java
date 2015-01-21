package examProject.ui.exportSessions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFileChooser;

import examProject.logic.BackendFacade;
import examProject.transferObjects.HostSessionDataTO;

public class ExportSessionsListener {
	private BackendFacade backendFacade;
	private ExportSessionsPanel exportPanel;
	
	public ExportSessionsListener(BackendFacade backendFacade, ExportSessionsPanel exportPanel) {
		this.backendFacade = backendFacade;
		this.exportPanel = exportPanel;
	}
	
	public void createButtonListeners() {
		exportPanel.getBtnExport().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {exportSessions();}});
		exportPanel.getBtnSetPath().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {setSavePath();}});
	}
	
	private void exportSessions() {
		boolean result = false;
		if (validateDate(exportPanel.getTbFromDate().getText()) && validateDate(exportPanel.getTbToDate().getText())) {
			if (!exportPanel.getTbPath().equals("")) {
				List<HostSessionDataTO> arr = backendFacade.exportSessions(exportPanel.getTbFromDate().getText(), exportPanel.getTbToDate().getText());
				setStatusText(result);
			}
		} else
			exportPanel.getLblStatus().setText("Felaktigt datumformat!");
		
	}
	
	private void setStatusText(boolean result) {
		if (result)
			exportPanel.getLblStatus().setText("Data har exporterats!");
		else
			exportPanel.getLblStatus().setText("Data kunde inte exporterats!");
	}

	private void setSavePath(){
		JFileChooser folderChooser = new JFileChooser();
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = folderChooser.showOpenDialog(exportPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION){
			exportPanel.getTbPath().setText(folderChooser.getSelectedFile().toString());
			
		}
	}
	
	private boolean validateDate(String date) {
		boolean result = true;
		if (!(date.length() == 10))
			return false;
		else if (!date.substring(4, 5).equals("-"))
			return false;
		else if (!date.substring(7, 8).equals("-"))
			return false;
		for (int i = 0; i < date.length(); i++)
			switch (date.substring(i, i + 1).toLowerCase()) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
			case "-":
				if (date.substring(i, i + 1).equals("-"))
					switch (i){
					case 7:
					case 4:
						break;
					default : 
						return false;
					}
				break;
			default:
				return false;
			}
		return result;
	}
}
