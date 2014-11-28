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

//ändra till extends jpanel

public class UI_LoadUserInformation extends JFrame {
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

	private JTextField firstNameTextField = new JTextField();
	private JTextField lastNameTextField = new JTextField();
	private JTextField addressTextField = new JTextField();
	private JTextField zipCodeTextField = new JTextField();
	private JTextField cityTextField = new JTextField();
	private JTextField civicNRTextField = new JTextField();
	private static JTextField emailTextField = new JTextField();
	private JTextField retypeEmailTextField = new JTextField();
	private JTextField phoneNrTextField = new JTextField();
	private JTextField mobileNrTextField = new JTextField();

	private UI_LoadUserInformation(JTextField firstName, JTextField lastName,
			JTextField email, JTextField retypeEmail) {
		this.firstNameTextField = firstName;
		this.lastNameTextField = lastName;
		this.emailTextField = email;
		this.retypeEmailTextField = retypeEmail;
	}

	public UI_LoadUserInformation() {

		super("Uppdatera användarens information");
		showTheMainWindow();
		makePanelsAndLayoutComponents();
		makeAndInstallTheListeners();
		setMinimumSize(getMinimumSize());
		// setLayout(new GridBagLayout());

	}

	private void showTheMainWindow() {
		this.setVisible(true);
		this.setSize(1200, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
			System.out.println("Right and updated");
			isMailCorrect();
			compareMail(retypeEmailTextField, emailTextField);
			checkIfFirstNameISCorrect();
			checkIfLastNameISCorrect();
			checkIfCivicNrISCorrect();
			test(mobileNrTextField.getText().length(), mobileNrTextField);
		}
		else
			JOptionPane.showMessageDialog(null,	"Du måste fylla in de fält med *");
	}

	public void labelListeners() {

	}

	// metod som kollar om mailet innehåller @
		public static void isMailCorrect() {
			boolean b = false;
			int counter = 0;

			if (emailTextField.getText().length() > 1) {
				if (emailTextField.getText().contains("@")) {
					b = true;
					System.out.println("det finns @ " + b);

				} else
					System.out.println("det finns inte @ " + b);
			}
			else
				JOptionPane.showMessageDialog(null,	"Mata in rätt e-mail");
			for (int i = 0; i < emailTextField.getText().length(); i++) {

				if ((int) emailTextField.getText().charAt(i) == 45  // - tecken
						|| (int) emailTextField.getText().charAt(i) == 46 // . tecken
						|| (int) emailTextField.getText().charAt(i) == 95 // _ tecken
						|| (int) emailTextField.getText().charAt(i) > 47 // nummer
						& (int) emailTextField.getText().charAt(i) < 58
						|| (int) emailTextField.getText().charAt(i) > 63  // @ och Storabokstäver
						& (int) emailTextField.getText().charAt(i) < 91
						|| (int) emailTextField.getText().charAt(i) > 96 // småbokstäver
						& (int) emailTextField.getText().charAt(i) < 123)
							counter ++;
				}
			if (counter == emailTextField.getText().length())
				System.out.println(" done " + emailTextField.getText());
			else {
				System.out.println(" nej " + emailTextField.getText());
				JOptionPane.showMessageDialog(null,	"Du får använda bara följande tecken (- , _ , . , nummer, små och stora bokstäver )");
			}
		}		

	//metod som kollar om retypeEmail stämmer med mailet
	public static void compareMail(JTextField retypeEmail, JTextField email) {
			if (email.getText().equals(retypeEmail.getText()) == false)
				JOptionPane.showMessageDialog(null, "Mailet stämmer inte");
	}
		// MEtod kollar om den inmatade förnamn är rätt
	public void checkIfFirstNameISCorrect() {
		int counter = 0;
		for (int i = 0; i < firstNameTextField.getText().length(); i++) {
			if ((int) firstNameTextField.getText().charAt(i) > 64
					& (int) firstNameTextField.getText().charAt(i) < 91
					|| (int) firstNameTextField.getText().charAt(i) > 96
					& (int) firstNameTextField.getText().charAt(i) < 123)
				counter++;
		}
		if (counter == firstNameTextField.getText().length())
			System.out.println(" done " + firstNameTextField.getText());
		else {
			System.out.println(" nej " + firstNameTextField.getText());
			JOptionPane.showMessageDialog(null,	"Den inmatade förnamn är inte rätt");
			// använd null för att dialogrutan ska visas i mitte på skärmen
		}
	}
	public boolean checkIfSQLKomman(JTextField text){
		boolean result = false;
		String sqlKommando[] = {"SELECT", "DELETE", "UPDATE", "'"};
		for (int i = 0; i< sqlKommando.length; i++ )
		if (text.getText() == sqlKommando[i] )
			System.out.println("Du f�r inte skriva s� " + result);
			result = false;
		return result;
	}
	
	// Metod som kollar om den inmatade efternamn är rätt
		public void checkIfLastNameISCorrect() {
			if (checkIfSQLKomman(lastNameTextField) == true){
			int counter = 0;
			for (int i = 0; i < lastNameTextField.getText().length(); i++) {
				if ((int) lastNameTextField.getText().charAt(i) > 64
						& (int) lastNameTextField.getText().charAt(i) < 91
						|| (int) lastNameTextField.getText().charAt(i) > 96
						& (int) lastNameTextField.getText().charAt(i) < 123)
					counter++;
			}
			if (counter != lastNameTextField.getText().length())
				JOptionPane.showMessageDialog(null,	"Den inmatade efternamn är inte rätt");
				// använd null för att dialogrutan ska visas i mitte på skärmen
			}
		}
	
		// Metod kollar om den inmatade ort namn är rätt dvs att den tar bara bokstäver
		public void checkIfCityNameIsCorrect() {
			int counter = 0;
			for (int i = 0; i < cityTextField.getText().length(); i++) {
				if ((int) cityTextField.getText().charAt(i) > 64
						& (int) cityTextField.getText().charAt(i) < 91
						|| (int) cityTextField.getText().charAt(i) > 96
						& (int) cityTextField.getText().charAt(i) < 123)
					counter++;
			}
			if (counter != cityTextField.getText().length())
				JOptionPane.showMessageDialog(null,	"Ort namn är inte rätt");
				// använd null för att dialogrutan ska visas i mitte på skärmen
		}
			
		// Metod kollar om den inmatade personnummer är rätt
		public void checkIfCivicNrISCorrect() {
			int counter = 0;
			for (int i = 0; i < civicNRTextField.getText().length(); i++) {
				if ((int) civicNRTextField.getText().charAt(i) > 47
						& (int) civicNRTextField.getText().charAt(i) < 58){
					counter++;
				}
			}
			if (counter == civicNRTextField.getText().length())
				if (counter !=10)
					JOptionPane.showMessageDialog(null,	"Personnummer är incorrect");
			else {
				JOptionPane.showMessageDialog(null,	"Personnummer är incorrect");			
			}
		}
	
		// Metod kollar om den inmatade nummer är rätt
				public void checkIfPoneNrIsCorrect() {
					int counter = 0;
					for (int i = 0; i < phoneNrTextField.getText().length(); i++) {
						if ((int) phoneNrTextField.getText().charAt(i) > 47
								& (int) phoneNrTextField.getText().charAt(i) < 58){
							counter++;
						}
					}
					if (counter == phoneNrTextField.getText().length())
						if (counter !=10)
							JOptionPane.showMessageDialog(null,	"fonenummer är incorrect");
					else {
						JOptionPane.showMessageDialog(null,	"fonnummer är incorrect");			
					}
				}
			
				// Metod kollar om den inmatade personnummer är rätt
				public void checkIfMobilNrIsCorrect() {
					int counter = 0;
					for (int i = 0; i < mobileNrTextField.getText().length(); i++) {
						if ((int) mobileNrTextField.getText().charAt(i) > 47
								& (int) mobileNrTextField.getText().charAt(i) < 58){
							counter++;
						}
					}
					if (counter == mobileNrTextField.getText().length())
						if (counter !=10)
							JOptionPane.showMessageDialog(null,	"Mobilnummer är incorrect");
					else {
						JOptionPane.showMessageDialog(null,	"Mobilnummer är incorrect");			
					}
				}
				
				public void test(int r, JTextField t){
					int counter = 0;
					for (int i = 0; i < r; i++) {
						if ((int) t.getText().charAt(i) > 47
								& (int) t.getText().charAt(i) < 58){
							counter++;
						}
					}
					if (counter == r)
						System.out.println("mob längd " + r);
						if (counter !=10)
							JOptionPane.showMessageDialog(null,	"Mobilet är incorrect");
					else {
						JOptionPane.showMessageDialog(null,	"mobilet är incorrect");			
					}
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
