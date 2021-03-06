package examProject.ui.updateUserInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import examProject.logic.BackendFacade;
import examProject.transferObjects.UpdateUserTransfere;

@SuppressWarnings("serial")
public class UI_LoadUserInformation extends JPanel {
	CheckIfTheInputIsCorrect checkStatement = new CheckIfTheInputIsCorrect();
	private BackendFacade facade;
	private JButton update = new JButton("Uppdatera");
	private JButton clearAllTextFields = new JButton("Rensa fält");
	private JCheckBox isActive = new JCheckBox(" Är aktiv");
	private JCheckBox isAdmin = new JCheckBox("Är admin");

	private JLabel firstNameLabel = new JLabel("* Förnamn");
	private JLabel lastNameLabel = new JLabel("* Efternamn");
	private JLabel addressLabel = new JLabel("Adress");
	private JLabel zipCodeLabel = new JLabel("Postnummer");
	private JLabel cityLabel = new JLabel("Ort");
	private JLabel civicNrLabel = new JLabel("personnummer (ÅÅMMDDXXXX)");
	private JLabel emailLabel = new JLabel("* E-post");
	private JLabel retypeEmailLabel = new JLabel("* Skriv om e-post");
	private JLabel phoneNrLabel = new JLabel("Telefonnummer");
	private JLabel mobilNrLabel = new JLabel("Mobilnummer");

	private JTextField firstNameTextField = new JTextField(100);
	private JTextField lastNameTextField = new JTextField(30);
	private JTextField addressTextField = new JTextField(50);
	private JTextField zipCodeTextField = new JTextField();
	private JTextField cityTextField = new JTextField(50);
	private JTextField civicNRTextField = new JTextField();
	private JTextField emailTextField = new JTextField(75);
	private JTextField retypeEmailTextField = new JTextField(75);
	private JTextField phoneNrTextField = new JTextField();
	private JTextField mobileNrTextField = new JTextField();

	public UI_LoadUserInformation(BackendFacade facade) {
		this.facade = facade;
		setLayout(null);
		setBounds();
		addCtrls();
		guiButtonListener();
		loadTextFields();
	}

	private void loadTextFields() {
		UpdateUserTransfere storedData = facade.getCurrentHostData();
		firstNameTextField.setText(storedData.getFirstName());
		lastNameTextField.setText(storedData.getLastName());
		emailTextField.setText(storedData.getEmail());
		retypeEmailTextField.setText(storedData.getEmail());
		civicNRTextField.setText(storedData.getCivic());
		cityTextField.setText(storedData.getCity());
		addressTextField.setText(storedData.getAddress());
		zipCodeTextField.setText(storedData.getZipCode());
		phoneNrTextField.setText(storedData.getPhoneNr());
		mobileNrTextField.setText(storedData.getMobileNr());
		isActive.setSelected(storedData.isActive());
		isAdmin.setSelected(storedData.isAdmin());
		if (storedData.isAdmin()) {
			isActive.setEnabled(true);
			isAdmin.setEnabled(true);
		} else {
			isActive.setEnabled(false);
			isAdmin.setEnabled(false);
		}
	}

	private void setBounds() {

		firstNameLabel.setBounds(29, 27, 180, 25);
		lastNameLabel.setBounds(300, 26, 180, 25);
		firstNameTextField.setBounds(29, 50, 180, 25);
		lastNameTextField.setBounds(300, 50, 180, 25);
		emailLabel.setBounds(29, 80, 180, 25);
		retypeEmailLabel.setBounds(300, 80, 180, 25);
		emailTextField.setBounds(29, 105, 180, 25);
		retypeEmailTextField.setBounds(300, 105, 180, 25);
		civicNrLabel.setBounds(29, 130, 300, 25);
		cityLabel.setBounds(300, 130, 180, 25);
		civicNRTextField.setBounds(29, 155, 180, 25);
		cityTextField.setBounds(300, 155, 180, 25);
		addressLabel.setBounds(29, 180, 180, 25);
		zipCodeLabel.setBounds(300, 180, 180, 25);
		addressTextField.setBounds(29, 205, 180, 25);
		zipCodeTextField.setBounds(300, 205, 180, 25);
		phoneNrLabel.setBounds(29, 230, 180, 25);
		mobilNrLabel.setBounds(300, 230, 180, 25);
		phoneNrTextField.setBounds(29, 255, 180, 25);
		mobileNrTextField.setBounds(300, 255, 180, 25);
		update.setBounds(29, 400, 180, 28);
		clearAllTextFields.setBounds(300, 400, 180, 28);
		isActive.setBounds(300, 300, 180, 25);
		isAdmin.setBounds(300, 330, 180, 25);
	}

	private void addCtrls() {

		add(firstNameLabel);
		add(lastNameLabel);
		add(firstNameTextField);
		add(lastNameTextField);
		add(emailLabel);
		add(retypeEmailLabel);
		add(emailTextField);
		add(retypeEmailTextField);
		add(civicNrLabel);
		add(cityLabel);
		add(civicNRTextField);
		add(cityTextField);
		add(addressLabel);
		add(zipCodeLabel);
		add(addressTextField);
		add(zipCodeTextField);
		add(phoneNrLabel);
		add(mobilNrLabel);
		add(phoneNrTextField);
		add(mobileNrTextField);
		add(update);
		add(clearAllTextFields);
		add(isActive);
		add(isAdmin);
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {

			Object source = event.getSource();
			if (source == update) {
				update();
			} else if (source == clearAllTextFields)
				clearAllTextFields();
		}
	}

	private void guiButtonListener() {
		ButtonListener buttonListener = new ButtonListener();
		update.addActionListener(buttonListener);
		clearAllTextFields.addActionListener(buttonListener);
		isAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		isAdmin.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});

		isActive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		isActive.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});
	}
	private void clearAllTextFields() {
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		emailTextField.setText("");
		retypeEmailTextField.setText("");
		civicNRTextField.setText("");
		addressTextField.setText("");
		cityTextField.setText("");
		zipCodeTextField.setText("");
		phoneNrTextField.setText("");
		mobileNrTextField.setText("");
	}
	private boolean checkFielts() {
		if (firstNameTextField.getText().length() > 0
				& lastNameTextField.getText().length() > 0
				& emailTextField.getText().length() > 0
				& retypeEmailTextField.getText().length() > 0) {
			return true;
		} else
			return false;
	}

	private void update() {
		UpdateUserTransfere updateUser = null;
		if (checkFielts()==true) {
			if (checkIfCivicNrISCorrect()) {
				if (checkIfPoneNrIsCorrect()) {
					if (checkIfZipCodeIsCorrect()) {
						if (checkIfMobilNrIsCorrect()) {
							if (checkIfCityNameIsCorrect()) {
								if (checkIfMailCorrect()) {
									if (checkIfFirstNameISCorrect()) {
										if (checkIfLastNameISCorrect()) {
											if (checkIfAddressIsCorrest()) {
												if (checkStatement.compareMail(retypeEmailTextField, emailTextField)) {
													updateUser = new UpdateUserTransfere(firstNameTextField.getText(),
															lastNameTextField.getText(),emailTextField.getText(),
															retypeEmailTextField.getText(),cityTextField.getText(),
															addressTextField.getText(),	mobileNrTextField.getText(),
															phoneNrTextField.getText(),zipCodeTextField.getText(),
															civicNRTextField.getText(),isActive(),isAdmin());
													facade.uppdateUser(updateUser);
													JOptionPane.showMessageDialog(null,"Din information har uppdaterat.");
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} else
			JOptionPane.showMessageDialog(null,"Du måste fylla in de fält med *");
	}

	public void buttonClickedMethod() {

		UpdateUserTransfere updateUser = new UpdateUserTransfere(
				getFirstNameTextField().getText(), getLastNameTextField()
						.getText(), getEmailTextField().getText(),
				getRetypeTextField().getText(), getCityTextField().getText(),
				getAddressTextField().getText(), getMobileNrTextField()
						.getText(), getPhoneNrTextField().getText(),
				getZipCodeTextField().getText(), getCityTextField().getText(),
				isActive.isSelected(), isAdmin.isSelected());
		facade.uppdateUser(updateUser);

	}

	public boolean checkIfFirstNameISCorrect() {
		boolean result = false;
		if (checkStatement.checkFirstName(firstNameTextField.getText(),
				firstNameTextField.getText().length()))
			result = true;
		else
			result = false;
		return result;
	}

	public boolean checkIfLastNameISCorrect() {
		boolean result = false;
		if (checkStatement.checkFirstName(lastNameTextField.getText(),
				lastNameTextField.getText().length()))
			result = true;
		return result;
	}
	/**
	 * This Method check if E-mail contain @ simbole
	 */
	public boolean checkIfMailCorrect() {
		boolean result = false;
		if (checkStatement.checkMail(emailTextField.getText(), emailTextField
				.getText().length()))
			result = true;
		else
			result = false;
		return result;
	}
	
	public boolean checkIfCityNameIsCorrect() {
		boolean result = false;
		if (checkStatement.checkCityName(cityTextField.getText(), cityTextField
				.getText().length()))
			result = true;
		else
			result = false;
		return result;
	}

	public boolean checkIfCivicNrISCorrect() {
		boolean result = false;

		if (civicNRTextField.getText().length() == 0) {
			result = true;
		} else {
			result = checkStatement.checkCivicNr(civicNRTextField.getText(),
					civicNRTextField.getText().length());
		}
		return result;
	}

	public boolean checkIfPoneNrIsCorrect() {
		boolean result = false;
		if (checkStatement.checkPhoneNr(phoneNrTextField.getText(),
				phoneNrTextField.getText().length()))
			result = true;
		else
			result = false;
		return result;
	}

	public boolean checkIfMobilNrIsCorrect() {
		boolean result = false;
		if (checkStatement.checkMobilNr(mobileNrTextField.getText(),
				mobileNrTextField.getText().length()))
			result = true;
		else
			result = false;
		return result;
	}

	public boolean checkIfZipCodeIsCorrect() {
		boolean result = false;
		if (checkStatement.checkZipCode(zipCodeTextField.getText(),
				zipCodeTextField.getText().length()))
			result = true;
		else
			result = false;
		return result;
	}

	public boolean checkIfAddressIsCorrest() {
		boolean result = false;
		if (checkStatement.checkIfAddressIsCorrest(addressTextField.getText(),
				addressTextField.getText().length()))
			result = true;
		else
			result = false;
		return result;
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(JTextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(JTextField lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	public JTextField getAddressTextField() {
		return addressTextField;
	}

	public void setAddressTextField(JTextField addressTextField) {
		this.addressTextField = addressTextField;
	}

	public JTextField getZipCodeTextField() {
		return zipCodeTextField;
	}

	public void setZipCodeTextField(JTextField zipCodeTextField) {
		this.zipCodeTextField = zipCodeTextField;
	}

	public JTextField getCityTextField() {
		return cityTextField;
	}

	public void setCityTextField(JTextField cityTextField) {
		this.cityTextField = cityTextField;
	}

	public JTextField getCivicNRTextField() {
		return civicNRTextField;
	}

	public void setCivicNRTextField(JTextField civicNRTextField) {
		this.civicNRTextField = civicNRTextField;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(JTextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	public JTextField getRetypeTextField() {
		return retypeEmailTextField;
	}

	public void setRetypeTextField(JTextField retypeTextField) {
		this.retypeEmailTextField = retypeTextField;
	}

	public JTextField getPhoneNrTextField() {
		return phoneNrTextField;
	}

	public void setPhoneNrTextField(JTextField phoneNrTextField) {
		this.phoneNrTextField = phoneNrTextField;
	}

	public JTextField getMobileNrTextField() {
		return mobileNrTextField;
	}

	public void setMobileNrTextField(JTextField mobileNrTextField) {
		this.mobileNrTextField = mobileNrTextField;
	}

	public boolean isAdmin() {
		return isAdmin.isSelected();
	}

	public boolean isActive() {
		return isActive.isSelected();
	}
}
