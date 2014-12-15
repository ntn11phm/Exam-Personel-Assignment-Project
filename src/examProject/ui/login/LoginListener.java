package examProject.ui.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import examProject.logic.BackendFacade;
import examProject.transferObjects.LoggedInUserTO;

public class LoginListener {
	private LoginPanel loginPanel;
	private BackendFacade backendFacade;
	
	public LoginListener(LoginPanel loginPanel, BackendFacade backendFacade) {
		this.loginPanel = loginPanel;
		this.backendFacade = backendFacade;
	}
	
	public void createListeners() {
		loginPanel.getLoginBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {login();}});
		loginPanel.getCancelBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {close();}});
	}
	
	private void login() {
		LoggedInUserTO user = backendFacade.login(loginPanel.getUsername(), loginPanel.getPwd());
		if (user == null) {
			
		}
	}
	
	private void close() {
		
	}
}
