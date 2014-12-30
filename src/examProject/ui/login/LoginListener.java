package examProject.ui.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import examProject.logic.BackendFacade;
import examProject.transferObjects.LoggedInUserTO;

public class LoginListener {
	private LoginPanel loginPanel;
	private BackendFacade backendFacade;
	private LoggedInUserTO user;
	private LoginFrame frame;
	
	public LoginListener(LoginPanel loginPanel, BackendFacade backendFacade, LoginFrame frame) {
		this.loginPanel = loginPanel;
		this.backendFacade = backendFacade;
		this.frame = frame;
	}
	
	public void createListeners() {
		loginPanel.getLoginBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {login();}});
		loginPanel.getCancelBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {close();}});
		loginPanel.getForgotPwdBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {forgotPwd();}});
	}
	
	private void login() {
		user = backendFacade.login(loginPanel.getUsername(), loginPanel.getPwd());
		if (user == null) {
			loginPanel.getStatusTextLabel().setText("Fel användarnamn eller lösenord!");
		} else {
			loginPanel.getStatusTextLabel().setText("Inloggad!");
			close();
		}
	}
	
	private void close() {
		frame.dispose();
	}
	
	private void forgotPwd() {
		
	}
	
	public LoggedInUserTO getUser() {
		return user;
	}
}
