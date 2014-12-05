package examProject.ui.addUser;

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
	private BackendFacade facade;
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
		this(new BackendFacade());
	}

	public AddUserGUI(BackendFacade facade) {
		this.facade = facade;
		setLayout(null);
		setBounds();
		addCtrls();
		guiButtonListener();

	}

	private void setBounds() {
		userNameLabel.setBounds(29, 85, 130, 28);
		firstNameLabel.setBounds(29, 27, 130, 23);
		lastNameLabel.setBounds(169, 26, 130, 25);
		pwdLabel.setBounds(29, 145, 130, 25);
		addUserButton.setBounds(29, 246, 170, 23);
		userNameText.setBounds(29, 109, 130, 25);
		firstNameText.setBounds(29, 49, 130, 25);
		lastNameText.setBounds(169, 49, 130, 25);
		pwd.setBounds(29, 166, 130, 25);
		isAdminCheckBox.setBounds(199, 115, 130, 13);
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
		if (!userNameText.getText().equals("")
				&& !firstNameText.getText().equals("")
				&& !lastNameText.getText().equals("")
				&& !pwd.getPassword().equals("")) {

			AddUser au = new AddUser(userNameText.getText(),
					firstNameText.getText(), lastNameText.getText(),
					pwd.getPassword(), isAdminCheckBox.isSelected());
			facade.addUser(au);

		} else {
			JOptionPane.showMessageDialog(null, "Fyll i alla fält!");

		}
	}

}
