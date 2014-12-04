package examProject.ui.updateUserInformation;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class UI_LoadUserInformation extends JPanel {
	
	CheckIfTheInputIsCorrect checkStatement = new CheckIfTheInputIsCorrect();
	private JButton update = new JButton("Update");

	private JCheckBox isActive = new JCheckBox("Is active");
	private JCheckBox isAdmin = new JCheckBox("Is admin");

	private JLabel firstNameLabel = new JLabel("*Förnamn");
	private JLabel lastNameLabel = new JLabel("*Efternamn");
	private JLabel addressLabel = new JLabel("Adress");
	private JLabel zipCodeLabel = new JLabel("Postnummer");
	private JLabel cityLabel = new JLabel("Ort");
	private JLabel civicNrLabel = new JLabel("Personnumer (ÅÅMMDDXXXX)");
	private JLabel emailLabel = new JLabel("*E-mail");
	private JLabel retypeEmailLabel = new JLabel("*Skriv om E-mail");
	private JLabel phoneNrLabel = new JLabel("Telefonnummer");
	private JLabel mobilNrLabel = new JLabel("Mobilnummer");

	private JTextField firstNameTextField = new JTextField(30);
	private JTextField lastNameTextField = new JTextField(30);
	private JTextField addressTextField = new JTextField(50);
	private JTextField zipCodeTextField = new JTextField();
	private JTextField cityTextField = new JTextField(50);
	private JTextField civicNRTextField = new JTextField();
	private static JTextField emailTextField = new JTextField(75);
	private JTextField retypeEmailTextField = new JTextField(75);
	private JTextField phoneNrTextField = new JTextField();
	private JTextField mobileNrTextField = new JTextField();

//	private UI_LoadUserInformation(JTextField firstName, JTextField lastName,
//			JTextField email, JTextField retypeEmail) {
//		this.firstNameTextField = firstName;
//		this.lastNameTextField = lastName;
//		this.emailTextField = email;
//		this.retypeEmailTextField = retypeEmail;
//	}
	public UI_LoadUserInformation() {
		makePanelsAndLayoutComponents();
		makeAndInstallTheListeners();
		setMinimumSize(getMinimumSize());
	}
	private void makePanelsAndLayoutComponents() {
		firstNameLabel.setPreferredSize(new Dimension(130, 40));
		firstNameLabel.setFont(new Font("ITALIC", Font.BOLD, 10));

		lastNameLabel.setPreferredSize(new Dimension(130, 40));
		lastNameLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		addressLabel.setPreferredSize(new Dimension(130, 40));
		addressLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		emailLabel.setPreferredSize(new Dimension(130, 40));
		emailLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		zipCodeLabel.setPreferredSize(new Dimension(130, 40));
		zipCodeLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		cityLabel.setPreferredSize(new Dimension(130, 40));
		cityLabel.setFont(new Font("ITALIC", Font.CENTER_BASELINE, 16));

		civicNrLabel.setPreferredSize(new Dimension(130, 40));
		civicNrLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		emailLabel.setPreferredSize(new Dimension(130, 40));
		emailLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		retypeEmailLabel.setPreferredSize(new Dimension(130, 40));
		retypeEmailLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		phoneNrLabel.setPreferredSize(new Dimension(130, 40));
		phoneNrLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		mobilNrLabel.setPreferredSize(new Dimension(130, 40));
		mobilNrLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		firstNameLabel.setPreferredSize(new Dimension(130, 40));
		firstNameLabel.setFont(new Font("ITALIC", Font.BOLD, 20));

		lastNameTextField.setPreferredSize(new Dimension(130, 40));
		lastNameTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		addressTextField.setPreferredSize(new Dimension(130, 40));
		addressTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		zipCodeTextField.setPreferredSize(new Dimension(130, 40));
		zipCodeTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		cityTextField.setPreferredSize(new Dimension(130, 20));
		cityTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		civicNRTextField.setPreferredSize(new Dimension(130, 40));
		civicNRTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		emailTextField.setPreferredSize(new Dimension(130, 40));
		emailTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		retypeEmailTextField.setPreferredSize(new Dimension(130, 40));
		retypeEmailTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		phoneNrTextField.setPreferredSize(new Dimension(130, 40));
		phoneNrTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		mobileNrTextField.setPreferredSize(new Dimension(130, 40));
		mobileNrTextField.setFont(new Font("ITALIC", Font.BOLD, 20));

		update.setPreferredSize(new Dimension(130, 40));
		update.setFont(new Font("ITALIC", Font.CENTER_BASELINE, 16));

		JPanel checkBoxPanel = new JPanel(new FlowLayout());
		checkBoxPanel.add(isActive);
		checkBoxPanel.add(isAdmin);

		JPanel mainPanel = new JPanel(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 40, 0, 0);

		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(firstNameLabel, c);

		c.gridx = 400;
		c.gridy = 0;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(lastNameLabel, c);

		c.gridx = 0;
		c.gridy = 2;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(firstNameTextField, c);

		c.gridx = 400;
		c.gridy = 2;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(lastNameTextField, c);

		c.gridx = 0;
		c.gridy = 3;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(addressLabel, c);

		c.gridx = 0;
		c.gridy = 4;
		c.ipadx = 200;
		c.ipady = 10;
		mainPanel.add(addressTextField, c);

		c.gridx = 0;
		c.gridy = 5;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(zipCodeLabel, c);

		c.gridx = 400;
		c.gridy = 5;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(cityLabel, c);

		c.gridx = 0;
		c.gridy = 6;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(zipCodeTextField, c);

		c.gridx = 400;
		c.gridy = 6;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(cityTextField, c);

		c.gridx = 0;
		c.gridy = 7;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(civicNrLabel, c);

		c.gridx = 400;
		c.gridy = 7;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(emailLabel, c);

		c.gridx = 0;
		c.gridy = 8;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(civicNRTextField, c);

		c.gridx = 400;
		c.gridy = 8;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(emailTextField, c);

		c.gridx = 0;
		c.gridy = 9;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(phoneNrLabel, c);

		c.gridx = 400;
		c.gridy = 9;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(retypeEmailLabel, c);

		c.gridx = 0;
		c.gridy = 10;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(phoneNrTextField, c);

		c.gridx = 400;
		c.gridy = 10;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(retypeEmailTextField, c);

		c.gridx = 0;
		c.gridy = 11;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(mobilNrLabel, c);

		c.gridx = 0;
		c.gridy = 12;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(mobileNrTextField, c);

		c.gridx = 400;
		c.gridy = 12;
		c.ipadx = 30;
		c.ipady = 10;
		mainPanel.add(checkBoxPanel, c);

		c.gridx = 0;
		c.gridy = 15;
		mainPanel.add(update, c);

		this.add(mainPanel, BorderLayout.CENTER);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			Object source = event.getSource();
			if (source == update) {
				update();
			} else if (source == isAdmin)
				System.out.println();

		}
	}

	@SuppressWarnings("unused")
	private void makeAndInstallTheListeners() {

		ButtonListener buttonListener = new ButtonListener();
		update.addActionListener(buttonListener);

		// }
		isAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getID() == ActionEvent.ACTION_PERFORMED ? "ACTION_PERFORMED"
						: e.getID());
			}
		});
		isAdmin.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange() == ItemEvent.SELECTED ? "SELECTED"
						: "DESELECTED");
			}
		});

		isActive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getID() == ActionEvent.ACTION_PERFORMED ? "ACTION_PERFORMED"
						: e.getID());
			}
		});
		isActive.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange() == ItemEvent.SELECTED ? "SELECTED"
						: "DESELECTED");
			}
		});
	}

	private void update() {
		if (firstNameTextField.getText().length() > 0
				& lastNameTextField.getText().length() > 0
				& emailTextField.getText().length() > 0
				& retypeEmailTextField.getText().length() > 0) {
			// new UI_LoadUserInformation();
			checkIfFirstNameISCorrect();
			checkIfLastNameISCorrect();
			checkIfMailCorrect();
			checkStatement.compareMail(retypeEmailTextField, emailTextField);
			checkIfCivicNrISCorrect();
			checkIfCityNameIsCorrect();
			checkIfMobilNrIsCorrect();
			checkIfPoneNrIsCorrect();
			checkIfAddressIsCorrest();
			checkIfZipCodeIsCorrect();
		} else
			JOptionPane.showMessageDialog(null,
					"Du måste fylla in de fält med *");
	}
	
	// MEtod kollar om den inmatade förnamn är rätt
	public void checkIfFirstNameISCorrect() {
		checkStatement.checkFirstName(firstNameTextField.getText(), firstNameTextField.getText().length());
	}
	// Metod som kollar om den inmatade efternamn är rätt
	public void checkIfLastNameISCorrect() {
		checkStatement.checkFirstName(lastNameTextField.getText(), lastNameTextField.getText().length());
	}
	// metod som kollar om mailet innehåller @
	public void checkIfMailCorrect() {
		checkStatement.checkMail(emailTextField.getText(), emailTextField.getText().length());
		}
	// Metod kollar om den inmatade ort namn är rätt dvs att den tar bara
	// bokstäver
	public void checkIfCityNameIsCorrect() {
		checkStatement.checkCityName(cityTextField.getText(), civicNRTextField.getText().length());
	}
	public void checkIfCivicNrISCorrect() {
		checkStatement.checkCivicNr(civicNRTextField.getText(), civicNRTextField.getText().length());
		}
	
	// Metod kollar om den inmatade nummer är rätt
	public void checkIfPoneNrIsCorrect() {
		checkStatement.checkPhoneNr(phoneNrTextField.getText(), phoneNrTextField.getText().length());
	}
	// Metod kollar om den inmatade personnummer är rätt
	public void checkIfMobilNrIsCorrect() {
		checkStatement.checkMobilNr(mobileNrTextField.getText(), mobileNrTextField.getText().length());
	}

	public void checkIfZipCodeIsCorrect(){
		checkStatement.checkZipCode(zipCodeTextField.getText(), zipCodeTextField.getText().length());
	}
	
	public void checkIfAddressIsCorrest(){
		checkStatement.checkIfAddressIsCorrest(addressTextField.getText());		
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

}
