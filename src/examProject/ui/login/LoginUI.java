package examProject.ui.login;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import examProject.logic.BackendFacade;

public class LoginUI extends JPanel {
	private BackendFacade backendFacade;
	private JLabel lblText = new JLabel("Anändarnamn");
	private JLabel lblPwd = new JLabel("Lösenord");
	private JLabel lblStatus = new JLabel();
	private JTextField tbUsername = new JTextField();
	private JPasswordField tbPwd = new JPasswordField();
	private JButton btnLogin = new JButton("Logga in");
	private JButton btnCancel = new JButton("Avbryt");
	
	public LoginUI(BackendFacade backendFacade) {
		this.backendFacade = backendFacade;
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
		
	}
	
	private void addCtrls() {
		
	}
}
