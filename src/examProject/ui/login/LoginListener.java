package examProject.ui.login;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import examProject.logic.BackendFacade;
import examProject.transferObjects.LoggedInUserTO;
import examProject.ui.forgotPwd.ForgotPwdPanel;

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
			Thread.currentThread().interrupt();
			close();
		}
	}
	
	private void close() {
		frame.dispose();
	}
	
	private void forgotPwd() {
		JFrame nextFrame = new JFrame();
		ForgotPwdPanel fpp = new ForgotPwdPanel(backendFacade);
		nextFrame.setContentPane(fpp);
		nextFrame.setSize(new Dimension(400, 300));
		nextFrame.setVisible(true);
	}
	
	public LoggedInUserTO getUser() {
		return user;
	}
}
