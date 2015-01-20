package examProject.ui.exportSessions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import examProject.logic.BackendFacade;

public class ExportSessionsListener {
	private BackendFacade backendFacade;
	private ExportSessions exportPanel;
	
	public ExportSessionsListener(BackendFacade backendFacade, ExportSessions exportPanel) {
		this.backendFacade = backendFacade;
		this.exportPanel = exportPanel;
	}
	
	public void createButtonListeners() {
		exportPanel.getBtnExport().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {exportSessions();}});
		exportPanel.getBtnSetPath().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {setSavePath();}});
	}
	
	private void exportSessions() {
		
	}
	
	private void setSavePath(){
		JFileChooser folderChooser = new JFileChooser();
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = folderChooser.showOpenDialog(exportPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION){
			exportPanel.getTbPath().setText(folderChooser.getSelectedFile().toString());
			
		}
	}
}
