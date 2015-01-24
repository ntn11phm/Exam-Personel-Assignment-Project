package examProject.ui.editUserInfo;

import examProject.logic.BackendFacade;

public class EditUserInfoListener {
	private EditUserInfoPanel editUserPanel;
	private BackendFacade backendFacade;
	
	public EditUserInfoListener(BackendFacade backendFacade, EditUserInfoPanel editUserPanel) {
		this.backendFacade = backendFacade;
		this.editUserPanel = editUserPanel;
		setUserMode();
	}
	
	public void createButtonListeners() {
		
	}
	
	private void setUserMode() {
		if (backendFacade.getCurrentUserRole())
			editUserPanel.setAdminMode();
		else
			editUserPanel.setHostMode();
	}
}
