package examProject.ui.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import examProject.logic.BackendFacade;
import examProject.transferObjects.LoggedInUserTO;

public class LoginListener {
	private LoginUI loginUI;
	private BackendFacade backendFacade;
	
	public LoginListener(LoginUI loginUI, BackendFacade backendFacade) {
		this.loginUI = loginUI;
		this.backendFacade = backendFacade;
	}
	
	public void createListeners() {
		loginUI.getLoginBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {login();}});
		loginUI.getCancelBtn().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {close();}});
	}
	
	private void login() {
		LoggedInUserTO user = backendFacade.login(loginUI.getUsername(), loginUI.getPwd());
		if (user == null) {
			
		}
	}
	
	private void close() {
		
	}
}
