package examProject.ui.changePwd;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import examProject.logic.BackendFacade;

public class ChangePwdPanel extends JPanel {
	private static final long serialVersionUID = -6713688094181624949L;
	private JPasswordField currentPwd = new JPasswordField();
	private JPasswordField newPwd = new JPasswordField();
	private JPasswordField retypeNewPwd = new JPasswordField();
	private JLabel lblNuvarandeLsenord = new JLabel("Nuvarande lösenord");
	private JLabel lblNyttLsenord = new JLabel("Nytt lösenord");
	private JLabel lblRepeteraNyttLsenord = new JLabel("Repetera nytt lösenord");
	private JLabel lblCurrentPwdStatus = new JLabel("");
	private JLabel lblNewPwdStatus0 = new JLabel("");
	private JLabel lblNewPwdStatus1 = new JLabel("");
	private JLabel lblStatus = new JLabel("");
	private JButton btnBytLsenord = new JButton("Byt lösenord");

	public ChangePwdPanel(BackendFacade backendFacade) {
		setLayout(null);
		setBounds();
		addCtrls();
		ChangePwdListener changePwdListener = new ChangePwdListener(this, backendFacade);
		changePwdListener.createButtonListeners();
	}
	
	private void setBounds() {
		lblNuvarandeLsenord.setBounds(66, 8, 97, 14);
		currentPwd.setBounds(76, 33, 155, 20);
		lblNyttLsenord.setBounds(66, 64, 65, 14);
		newPwd.setBounds(76, 89, 155, 20);
		lblRepeteraNyttLsenord.setBounds(66, 120, 112, 14);
		lblCurrentPwdStatus.setBounds(241, 36, 75, 14);
		lblNewPwdStatus0.setBounds(241, 92, 75, 14);
		lblNewPwdStatus1.setBounds(241, 148, 75, 14);
		retypeNewPwd.setBounds(76, 145, 155, 20);
		lblStatus.setBounds(66, 222, 250, 14);
		btnBytLsenord.setBounds(76, 188, 155, 23);
	}
	
	private void addCtrls() {
		add(lblNuvarandeLsenord);
		add(currentPwd);
		add(lblNyttLsenord);
		add(newPwd);
		add(lblRepeteraNyttLsenord);
		add(retypeNewPwd);
		add(lblCurrentPwdStatus);
		add(lblNewPwdStatus0);
		add(lblNewPwdStatus1);
		add(lblStatus);
		add(btnBytLsenord);
	}
	
	public JButton getChangePwdButton() {
		return this.btnBytLsenord;
	}

	public JPasswordField getCurrentPwd() {
		return currentPwd;
	}

	public JPasswordField getNewPwd() {
		return newPwd;
	}

	public JPasswordField getRetypeNewPwd() {
		return retypeNewPwd;
	}
	
	public void updatePwdStatus(boolean input) {
		if (input) {
			lblCurrentPwdStatus.setText("Ok");
			lblCurrentPwdStatus.setForeground(Color.GREEN);
		} else {
			lblCurrentPwdStatus.setText("Fel");
			lblCurrentPwdStatus.setForeground(Color.RED);
		}
	}
	
	public void updateNewPwdStatus(boolean input) {
		if (input) {
			lblNewPwdStatus0.setText("Ok");
			lblNewPwdStatus0.setForeground(Color.GREEN);
			lblNewPwdStatus1.setText("Ok");
			lblNewPwdStatus1.setForeground(Color.GREEN);
		} else {
			lblNewPwdStatus0.setText("Fel");
			lblNewPwdStatus0.setForeground(Color.RED);
			lblNewPwdStatus1.setText("Fel");
			lblNewPwdStatus1.setForeground(Color.RED);
		}
	}
	
	public void updatePwdSuccessfulStatusText() {
		lblStatus.setText("Nytt lösenord sparat!");
	}
}
