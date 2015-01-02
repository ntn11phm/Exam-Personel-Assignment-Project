package examProject.ui.changePwd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import examProject.logic.BackendFacade;

public class ChangePwdListener {
	private JButton changePwdButton;
	private ChangePwdPanel changePwdPanel;
	private BackendFacade backendFacade;
	private boolean result;
	private ChangePwdFrame frame;

	public ChangePwdListener(ChangePwdPanel changePwdPanel, BackendFacade backendFacade, ChangePwdFrame frame) {
		this.changePwdButton = changePwdPanel.getChangePwdButton();
		this.changePwdPanel = changePwdPanel;
		this.backendFacade = backendFacade;
		this.frame = frame;
		this.result = true;
	}
	
	public void createButtonListeners() {
		changePwdButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {validatePwd();}});
	}
	
	private void validatePwd() {
		boolean result = false;
		if (validateNewPwd())
				result = backendFacade.changePwd(changePwdPanel.getNewPwd().getPassword());
		if (result) {
			changePwdPanel.updatePwdSuccessfulStatusText();
			this.result = false;
			Thread.currentThread().interrupt();
			frame.dispose();
		}
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
	
	public boolean getChangedPwdResult() {
		return result;
	}
}
