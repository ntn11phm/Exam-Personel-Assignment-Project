package examProject.ui.populateSessions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import examProject.logic.BackendFacade;

public class PopulateSessionsListener {
	private PopulateSessionsPanel psPanel;
	private BackendFacade backendFacade;
	
	public PopulateSessionsListener(PopulateSessionsPanel psPanel, BackendFacade backendFacade) {
		this.psPanel = psPanel;
		this.backendFacade = backendFacade;
	}
	
	public void createListeners() {
		psPanel.getBtnLoadSessions().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {loadSessions();}});
		psPanel.getBtnCommitSession();
		psPanel.getHost1_btn();
		psPanel.getHost2_btn();
		psPanel.getHost2_btn();
		psPanel.getHost2_btn();
	}
	
	private void loadSessions() {
		
	}
}
