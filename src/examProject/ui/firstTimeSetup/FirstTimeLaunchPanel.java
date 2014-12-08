package examProject.ui.firstTimeSetup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstTimeLaunchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblText = new JLabel("Var god och fyll i dessa fält med informationen du har fått av administratören!");
	private JLabel lblUsername = new JLabel("Databasen användarnamn");
	private JLabel lblPwd = new JLabel("Databasen lösenord");
	private JTextField tbUsername = new JTextField();
	private JTextField tbPwd = new JTextField();
	private JButton btnStore = new JButton("Spara");
	private JLabel lblStatus = new JLabel();
	
	public FirstTimeLaunchPanel() {
		setLayout(null);
		setBounds();
		addCtrls();
		loadFromFile();
	}
	
	private void setBounds() {
		lblText.setBounds(10, 10, 430, 15);
		lblUsername.setBounds(10, 36, 150, 15);
		tbUsername.setBounds(10, 62, 150, 15);
		lblPwd.setBounds(10, 88, 150, 15);
		tbPwd.setBounds(10, 114, 150, 15);
		btnStore.setBounds(10, 140, 80, 24);
	}
	
	private void addCtrls() {
		add(lblText);
		add(lblUsername);
		add(tbUsername);
		add(lblPwd);
		add(tbPwd);
		add(btnStore);
	}
	
	private void loadFromFile() {
		FirstTimeLaunchLogic logic = new FirstTimeLaunchLogic();
		boolean result = logic.openFile();
		if (result)
			lblStatus.setText("Laddat från fil!");
		else {
			lblStatus.setText("Kunde inte ladda från fil!");
			// create file here?
		}
		
	}
	
	public JButton getStoreButton() {
		return btnStore;
	}
	
	public String getUsername() {
		return tbUsername.getText();
	}
	
	public String getPwd() {
		return tbPwd.getText();
	}
	
	public void setStatusText(String text) {
		lblStatus.setText(text);
	}
}
