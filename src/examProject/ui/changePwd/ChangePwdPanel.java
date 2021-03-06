package examProject.ui.changePwd;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import examProject.logic.BackendFacade;

public class ChangePwdPanel extends JPanel {
	private static final long serialVersionUID = -6713688094181624949L;
	private JPasswordField newPwd = new JPasswordField();
	private JPasswordField retypeNewPwd = new JPasswordField();
	private JLabel lblNyttLsenord = new JLabel("Nytt lösenord");
	private JLabel lblRepeteraNyttLsenord = new JLabel("Repetera nytt lösenord");
	private JLabel lblCurrentPwdStatus = new JLabel("");
	private JLabel lblNewPwdStatus0 = new JLabel("");
	private JLabel lblNewPwdStatus1 = new JLabel("");
	private JLabel lblStatus = new JLabel("");
	private JButton btnBytLsenord = new JButton("Byt lösenord");
	private ChangePwdListener changePwdListener;

	public ChangePwdPanel(BackendFacade backendFacade, ChangePwdFrame frame) {
		setLayout(null);
		setBounds();
		addCtrls();
		changePwdListener = new ChangePwdListener(this, backendFacade, frame);
		changePwdListener.createButtonListeners();
	}
	
	private void setBounds() {
		lblNyttLsenord.setBounds(10, 11, 221, 14);
		newPwd.setBounds(10, 36, 221, 20);
		lblRepeteraNyttLsenord.setBounds(10, 67, 221, 14);
		lblCurrentPwdStatus.setBounds(241, 36, 75, 14);
		lblNewPwdStatus0.setBounds(241, 92, 75, 14);
		lblNewPwdStatus1.setBounds(241, 148, 75, 14);
		retypeNewPwd.setBounds(10, 89, 221, 20);
		lblStatus.setBounds(10, 207, 250, 20);
		btnBytLsenord.setBounds(10, 120, 155, 23);
	}
	
	private void addCtrls() {
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
	
	public boolean getChangedPwdResult() {
		return changePwdListener.getChangedPwdResult();
	}
}
