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
		panel();
		button();
		labels();
		textFields();
		pwdField();
		checkBox();
		guiButtonListener();

	}

	private void panel() {
		panel.setVisible(true);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(100, 100, 800, 600);
		panel.setLayout(null);
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

	private void button() {
		addUserButton.setBounds(29, 514, 130, 23);
		panel.add(addUserButton);
	}

	private void labels() {
		userNameLabel.setBounds(29, 208, 72, 28);
		panel.add(userNameLabel);
		firstNameLabel.setBounds(29, 126, 72, 23);
		panel.add(firstNameLabel);
		lastNameLabel.setBounds(167, 125, 50, 25);
		panel.add(lastNameLabel);
		pwdLabel.setBounds(29, 295, 50, 25);
		panel.add(pwdLabel);
	}

	private void textFields() {
		userNameText.setBounds(28, 231, 130, 25);
		panel.add(userNameText);
		firstNameText.setBounds(29, 147, 130, 25);
		panel.add(firstNameText);
		lastNameText.setBounds(167, 146, 130, 25);
		panel.add(lastNameText);
	}

	private void pwdField() {
		pwd.setBounds(29, 317, 130, 25);
		panel.add(pwd);
	}

	private void checkBox() {
		isAdminCheckBox.setBounds(29, 387, 100, 13);
		panel.add(isAdminCheckBox);
		isAdminCheckBox.setSelected(false);
	}

}
