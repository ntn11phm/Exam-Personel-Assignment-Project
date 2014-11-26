package examProject.ui.changePwd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import examProject.logic.BackendFacade;

public class ChangePwdListener {
	private JButton changePwdButton;
	private ChangePwdPanel changePwdPanel;
	private BackendFacade backendFacade;

	public ChangePwdListener(ChangePwdPanel changePwdPanel, BackendFacade backendFacade) {
		this.changePwdButton = changePwdPanel.getChangePwdButton();
		this.changePwdPanel = changePwdPanel;
		this.backendFacade = backendFacade;
	}
	
	public void createButtonListeners() {
		changePwdButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {validatePwd();}});
	}
	
	private void validatePwd() {
		boolean result = false;
		if (validateCurrentPwd())
			if (validateNewPwd())
				result = backendFacade.changePwd(changePwdPanel.getNewPwd().getPassword());
		if (result)
			changePwdPanel.updatePwdSuccessfulStatusText();
	}
	
	private boolean validateCurrentPwd() {
		boolean result = false;
		if (changePwdPanel.getCurrentPwd().getPassword() != null)
			result = backendFacade.validateCurrentPwd(changePwdPanel.getCurrentPwd().getPassword());
		changePwdPanel.updatePwdStatus(result);
		return result;
	}
	
	private boolean validateNewPwd() {
		boolean result = false;
		char[] newPwd = changePwdPanel.getNewPwd().getPassword();
		char[] retypePwd = changePwdPanel.getRetypeNewPwd().getPassword();
		if (newPwd.length == retypePwd.length)
			for (int i = 0; i < changePwdPanel.getNewPwd().getPassword().length; i++) {
				result = (newPwd[i]==retypePwd[i]);
				if (!result)
					break;
			}
		changePwdPanel.updateNewPwdStatus(result);
		return result;
	}
}
