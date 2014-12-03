package examProject.ui.addUser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import examProject.logic.*;

@SuppressWarnings("serial")
public class AddUserGUI extends JPanel {
	BackendFacade facade = new BackendFacade();
	private JPanel panel = new JPanel();
	private JLabel userNameLabel = new JLabel("Avändarnamn");
	private JLabel firstNameLabel = new JLabel("Förnamn");
	private JLabel lastNameLabel = new JLabel("Efternamn");
	private JLabel pwdLabel = new JLabel("Lösenord");
	private JTextField userNameText = new JTextField(30);
	private JTextField firstNameText = new JTextField(30);
	private JTextField lastNameText = new JTextField(30);
	private JPasswordField pwd = new JPasswordField();
	private JButton addUserButton = new JButton("Lägg till användare");
	private JCheckBox isAdminCheckBox = new JCheckBox("Administratör");

	public AddUserGUI() {
		setLayout(null);
		setBounds();
		addCtrls();
		guiButtonListener();

	}

	private void setBounds() {
		userNameLabel.setBounds(29, 208, 72, 28);
		firstNameLabel.setBounds(29, 126, 72, 23);
		lastNameLabel.setBounds(167, 125, 50, 25);
		pwdLabel.setBounds(29, 295, 50, 25);
		addUserButton.setBounds(29, 514, 130, 23);
		userNameText.setBounds(28, 231, 130, 25);
		firstNameText.setBounds(29, 147, 130, 25);
		lastNameText.setBounds(167, 146, 130, 25);
		pwd.setBounds(29, 317, 130, 25);
		isAdminCheckBox.setBounds(29, 387, 100, 13);
	}

	private void addCtrls() {
		add(addUserButton);
		add(userNameLabel);
		add(firstNameLabel);
		add(lastNameLabel);
		add(pwdLabel);
		add(userNameText);
		add(firstNameText);
		add(lastNameText);
		add(pwd);
		add(isAdminCheckBox);
		isAdminCheckBox.setSelected(false);
	}

	private void guiButtonListener() {
		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClickedMethod();
			}
		});
	}

	private void buttonClickedMethod() {
		if (userNameText.getText().equals("")
				|| firstNameText.getText().equals("")
				|| lastNameText.getText().equals("")
				|| pwd.getPassword().equals("")) {
			JOptionPane.showMessageDialog(null, "Fyll i alla fält");
		}
		if (userNameText.getText().equals("Kolla användarnamn från Db")) {
			JOptionPane.showMessageDialog(null, "Användarnamnet är upptaget");
		} else {
			AddUser au = new AddUser(userNameText.getText(),
					firstNameText.getText(), lastNameText.getText(),
					pwd.getPassword(), isAdminCheckBox.isSelected());
		}
	}

}
