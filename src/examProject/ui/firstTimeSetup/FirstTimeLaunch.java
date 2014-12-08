package examProject.ui.firstTimeSetup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstTimeLaunch extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblText = new JLabel("Var god och fyll i dessa fält med informationen du har fått av administratören!");
	private JLabel lblUsername = new JLabel("Databasen användarnamn");
	private JLabel lblPwd = new JLabel("Databasen lösenord");
	private JTextField tbUsername = new JTextField();
	private JTextField tbPwd = new JTextField();
	private JButton btnStore = new JButton("Spara");
	
	public FirstTimeLaunch() {
		setLayout(null);
		setBounds();
		addCtrls();
	}
	
	private void setBounds() {
		lblText.setBounds(10, 10, 300, 50);
		lblUsername.setBounds(10, 70, 150, 10);
		tbUsername.setBounds(10, 90, 150, 10);
		lblPwd.setBounds(10, 110, 150, 10);
		tbPwd.setBounds(10, 130, 150, 10);
		btnStore.setBounds(10, 150, 80, 15);
	}
	
	private void addCtrls() {
		add(lblText);
		add(lblUsername);
		add(tbUsername);
		add(lblPwd);
		add(tbPwd);
		add(btnStore);
	}
}
