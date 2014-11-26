package examProject.ui.forgotPwd;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import examProject.logic.BackendFacade;

public class ForgotPwdPanel extends JPanel {
	private static final long serialVersionUID = -3300329971221520973L;
	private JLabel lblHeader1 = new JLabel("Om du har glömt ditt användarnamn eller lösenord ");
	private JLabel lblHeader2 = new JLabel("fyll i  ditt användarnamn eller e-post adress");
	private JTextField tbUsername = new JTextField();;
	private JTextField tbEmail = new JTextField();
	private JLabel lblUsername = new JLabel("Användarnamn");
	private JLabel lblEpostAdress = new JLabel("E-post adress");
	private JButton btnRequestPwd = new JButton("Glömt lösenord");
	private JLabel lblStatusText = new JLabel("");
	
	public ForgotPwdPanel(BackendFacade backendFacade) {
		setLayout(null);
		setBounds();
		addCtrls();
		ForgotPwdListener forgotPwdListener = new ForgotPwdListener(this, backendFacade);
		forgotPwdListener.createButtonListeners();
	}
	
	public ForgotPwdPanel() {
		this(new BackendFacade());
	}
	
	private void setBounds() {
		lblHeader1.setBounds(58, 5, 275, 14);
		lblHeader2.setBounds(58, 30, 275, 14);
		lblUsername.setBounds(58, 55, 130, 14);
		tbUsername.setBounds(58, 80, 275, 20);
		lblEpostAdress.setBounds(58, 111, 130, 14);
		tbEmail.setBounds(58, 136, 275, 20);
		btnRequestPwd.setBounds(58, 167, 130, 23);
		lblStatusText.setBounds(58, 201, 275, 14);
	}
	
	private void addCtrls() {
		add(lblHeader1);
		add(lblHeader2);
		add(lblUsername);
		add(tbUsername);
		tbUsername.setColumns(20);
		add(lblEpostAdress);
		add(tbEmail);
		tbEmail.setColumns(50);
		add(btnRequestPwd);
		add(lblStatusText);
	}
	
	public JButton getRequestPwdButton() {
		return this.btnRequestPwd;
	}

	public String getEmail() {
		return tbEmail.getText();
	}

	public String getUsername() {
		return tbUsername.getText();
	}
	
	public void setStatusText(String input) {
		lblStatusText.setText(input);
	}

	public void setStatusText(boolean input) {
		if (input)
			lblStatusText.setText("Ett epost meddelande has skickats!");
		else
			lblStatusText.setText("Kunde ej skicka uppgifter!");
	}
	
	public String getStatusText() {
		return lblStatusText.getText();
	}
}
