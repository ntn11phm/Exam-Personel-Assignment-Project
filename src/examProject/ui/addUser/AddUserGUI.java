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
import examProject.transferObjects.AddUser;


public class AddUserGUI extends JPanel {

	private static final long serialVersionUID = 2893288573784306256L;
	private BackendFacade facade;
	private JLabel userNameLabel = new JLabel("Avändarnamn");
	private JLabel firstNameLabel = new JLabel("Förnamn");
	private JLabel lastNameLabel = new JLabel("Efternamn");
	private JLabel pwdLabel = new JLabel("Lösenord");
	private static JTextField userNameText = new JTextField(30);
	private JTextField firstNameText = new JTextField(30);
	private JTextField lastNameText = new JTextField(30);
	private JPasswordField pwd = new JPasswordField();
	private JButton addUserButton = new JButton("Lägg till användare");
	private JButton clearTextFields = new JButton("Rensa fält");
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
		addUserButton.setBounds(29, 246, 170, 34);
		clearTextFields.setBounds(248, 246, 170, 34);
		getUserNameText().setBounds(29, 109, 130, 25);
		firstNameText.setBounds(29, 49, 130, 25);
		lastNameText.setBounds(169, 49, 130, 25);
		pwd.setBounds(29, 166, 130, 25);
		isAdminCheckBox.setBounds(199, 115, 130, 13);
	}

	private void addCtrls() {
		add(addUserButton);
		add(clearTextFields);
		add(userNameLabel);
		add(firstNameLabel);
		add(lastNameLabel);
		add(pwdLabel);
		add(getUserNameText());
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
		clearTextFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUserNameText().setText("");	
				firstNameText.setText("");
				lastNameText.setText("");
				pwd.setText("");
				
			}
		});
	}

	private void buttonClickedMethod() {
		if (!getUserNameText().getText().equals("")
				&& !firstNameText.getText().equals("")
				&& !lastNameText.getText().equals("")
				&& !pwd.getPassword().equals("")) {

			AddUser au = new AddUser(getUserNameText().getText(),
					firstNameText.getText(), lastNameText.getText(),
					pwd.getPassword(), isAdminCheckBox.isSelected());
			facade.addUser(au);

		} else {
			JOptionPane.showMessageDialog(null, "Fyll i alla fält!");

		}
	}

	public static JTextField getUserNameText() {
		return userNameText;
	}


}
