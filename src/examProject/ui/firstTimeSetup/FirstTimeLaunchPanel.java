package examProject.ui.firstTimeSetup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstTimeLaunchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblText = new JLabel("Fyll i dessa f\u00E4lt med informationen du har f\u00E5tt av administrat\u00F6ren!");
	private JLabel lblUsername = new JLabel("Databasen användarnamn");
	private JLabel lblPwd = new JLabel("Databasen lösenord");
	private JTextField tbUsername = new JTextField();
	private JTextField tbPwd = new JTextField();
	private JButton btnStore = new JButton("Spara");
	private JLabel lblStatus = new JLabel();
	private FirstTimeLaunchListener listener;
	
	public FirstTimeLaunchPanel() {
		setLayout(null);
		setBounds();
		addCtrls();
		listener = new FirstTimeLaunchListener(this);
		listener.createButtonListeners();
		loadFromFile();
	}
	
	private void setBounds() {
		lblText.setBounds(10, 10, 430, 15);
		lblUsername.setBounds(10, 43, 150, 15);
		tbUsername.setBounds(10, 69, 150, 24);
		lblPwd.setBounds(10, 104, 150, 15);
		tbPwd.setBounds(10, 130, 150, 24);
		btnStore.setBounds(10, 165, 80, 24);
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
		if (result) {
			lblStatus.setText("Laddat från fil!");
			tbUsername.setText(logic.getUsername());
			tbPwd.setText(logic.getPwd());
		} else {
			lblStatus.setText("Kunde inte ladda från fil!");
			// create file here?
		}
		
	}
	
	public boolean getSavedStatus() {
		return listener.getSavedStatus();
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
