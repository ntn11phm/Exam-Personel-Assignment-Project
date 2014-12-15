package examProject.ui.login;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import examProject.logic.BackendFacade;
import java.awt.Color;

public class LoginPanel extends JPanel {
	private BackendFacade backendFacade;
	private JLabel lblUsername = new JLabel("Anändarnamn");
	private JLabel lblPwd = new JLabel("Lösenord");
	private JLabel lblStatus = new JLabel();
	private JTextField tbUsername = new JTextField();
	private JPasswordField tbPwd = new JPasswordField();
	private JButton btnLogin = new JButton("Logga in");
	private JButton btnCancel = new JButton("Avbryt");
	private JButton btnForgotPwd = new JButton("Gl\u00F6mt l\u00F6senordet");
	
	public LoginPanel(BackendFacade backendFacade) {
		this.backendFacade = backendFacade;
		setLayout(null);
		setBounds();
		addCtrls();
		LoginListener loginListener = new LoginListener(this, backendFacade);
		loginListener.createListeners();
	}
	
	public JLabel getStatusTextLabel() {
		return lblStatus;
	}
	
	public String getUsername() {
		return tbUsername.getText();
	}
	
	public char[] getPwd() {
		return tbPwd.getPassword();
	}
	
	public JButton getLoginBtn() {
		return btnLogin;
	}
	
	public JButton getCancelBtn() {
		return btnCancel;
	}
	
	private void setBounds() {
		lblUsername.setBounds(10, 10, 210, 15);
		tbUsername.setBounds(10, 30, 210, 25);
		lblPwd.setBounds(10, 66, 210, 15);
		tbPwd.setBounds(10, 92, 210, 25);
		btnLogin.setBounds(10, 128, 100, 30);
		btnCancel.setBounds(120, 128, 100, 31);
		lblStatus.setBounds(10, 170, 210, 25);
		btnForgotPwd.setBounds(10, 206, 210, 23);
	}
	
	private void addCtrls() {
		add(lblUsername);
		add(lblPwd);
		add(lblStatus);
		add(tbUsername);
		add(tbPwd);
		add(btnLogin);
		add(btnCancel);
		btnForgotPwd.setToolTipText("F\u00E5 anv\u00E4ndarnamn och tempor\u00E4rt l\u00F6senord skickat till din e-post adress");
		btnForgotPwd.setForeground(Color.BLUE);
		add(btnForgotPwd);
	}
}
