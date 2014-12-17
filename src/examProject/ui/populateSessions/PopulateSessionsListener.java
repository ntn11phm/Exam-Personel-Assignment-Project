package examProject.ui.populateSessions;

import examProject.logic.BackendFacade;

public class PopulateSessionsListener {
	private PopulateSessionsPanel psPanel;
	private BackendFacade backendFacade;
	
	public PopulateSessionsListener(PopulateSessionsPanel psPanel, BackendFacade backendFacade) {
		this.psPanel = psPanel;
		this.backendFacade = backendFacade;
	}
	
	public void createListeners() {
		psPanel.getBtnLoadSessions();
		psPanel.getBtnCommitSession();
		psPanel.getHost1_btn();
		psPanel.getHost2_btn();
		psPanel.getHost2_btn();
		psPanel.getHost2_btn();
	}
	
}
