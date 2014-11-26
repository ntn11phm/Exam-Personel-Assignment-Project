package examProject.ui.forgotPwd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import examProject.logic.BackendFacade;

public class ForgotPwdListener {
	private ForgotPwdPanel forgotPwdPanel;
	private JButton btnForgotPwd;
	private BackendFacade backendFacade;
	
	public ForgotPwdListener(ForgotPwdPanel forgotPwdPanel, BackendFacade backendFacade) {
		this.forgotPwdPanel	= forgotPwdPanel;
		this.btnForgotPwd = forgotPwdPanel.getRequestPwdButton();
		this.backendFacade = backendFacade;
	}

	public void createButtonListeners() {
		btnForgotPwd.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {requestNewPwd();}});
	}
	
	private void requestNewPwd() {
		boolean result = false;
		String username = forgotPwdPanel.getUsername();
		String email = forgotPwdPanel.getEmail();
		if (email.equals("") && username.equals(""))
			forgotPwdPanel.setStatusText("Användarnamn eller epost-adress måste anges!");
		else if (!email.equals("") && !username.equals(""))
			result = backendFacade.requestNewPwdEmail(email);
		else if (email.equals("") && !username.equals(""))
			result = backendFacade.requestNewPwdUsername(username);
		else if (!email.equals("") && username.equals(""))
			result = backendFacade.requestNewPwdEmail(email);
		if (forgotPwdPanel.getStatusText().equals(""))
			forgotPwdPanel.setStatusText(result);
	}
}
