package examProject.ui.setUpDb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import examProject.ui.updateUserInformation.SetupIncompleteException;

public class SetUpDbGui extends JPanel {

	private static final long serialVersionUID = -1574987717437001835L;
	private JLabel userNameLabel = new JLabel("Username:");
	private JLabel dBDriverLabel = new JLabel("Databasedriver:");
	private JLabel dBPathLabel = new JLabel("Databasepath:");
	private JLabel dBPortLabel = new JLabel("Database-PortNr:");
	private JLabel dBNameLabel = new JLabel("Databasename:");
	private JLabel mailServPathLabel = new JLabel("Mailserverpath:");
	private JCheckBox firstTimeLaunchCb = new JCheckBox("First time launch");
	private JTextField userNameText = new JTextField(30);
	private JTextField dBDriverText = new JTextField(30);
	private JTextField dBPathText = new JTextField(30);
	private JTextField dBPortText = new JTextField(30);
	private JTextField dBNameText = new JTextField(30);
	private JTextField mailServPathText = new JTextField(30);
	private JButton currentSetupButton = new JButton("View Setup");
	private JButton saveButton = new JButton("Save");
	private JButton clearFieldsButton = new JButton("Clear Fields");

	public SetUpDbGui() {
		setLayout(null);
		setBounds();
		addCtrls();
		guiButtonListener();

	}

	private void setBounds() {
		userNameLabel.setBounds(29, 72, 130, 20);
		dBDriverLabel.setBounds(29, 32, 130, 20);
		dBPathLabel.setBounds(29, 191, 130, 20);
		dBPortLabel.setBounds(29, 151, 130, 20);
		dBNameLabel.setBounds(29, 111, 130, 20);
		mailServPathLabel.setBounds(29, 231, 130, 20);
		userNameText.setBounds(131, 72, 160, 20);
		dBDriverText.setBounds(131, 32, 160, 20);
		dBPathText.setBounds(131, 191, 160, 20);
		dBPortText.setBounds(131, 151, 160, 20);
		dBNameText.setBounds(131, 111, 160, 20);
		mailServPathText.setBounds(131, 231, 160, 20);
		firstTimeLaunchCb.setBounds(29, 271, 130, 20);
		saveButton.setBounds(29, 345, 90, 30);
		clearFieldsButton.setBounds(163, 346, 129, 29);
		currentSetupButton.setBounds(162, 306, 129, 29);
	}

	private void addCtrls() {
		add(userNameLabel);
		add(dBDriverLabel);
		add(dBPathLabel);
		add(dBPortLabel);
		add(dBNameLabel);
		add(mailServPathLabel);
		add(userNameText);
		add(dBDriverText);
		add(dBPathText);
		add(dBPortText);
		add(dBNameText);
		add(mailServPathText);
		add(firstTimeLaunchCb);
		add(saveButton);
		add(clearFieldsButton);
		add(currentSetupButton);

	}

	private void guiButtonListener() {
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveButtonClickedMethod();

			}
		});
		currentSetupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButtonClickedMethod();
			}
		});
		clearFieldsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNameText.setText("");
				dBDriverText.setText("");
				dBPathText.setText("");
				dBPortText.setText("");
				dBNameText.setText("");
				mailServPathText.setText("");
			}
		});

	}

	private void saveButtonClickedMethod() {
		BufferedWriter save = null;
		try {
			save = new BufferedWriter(new FileWriter("Options.txt"));
			save.write("databaseDriver=" + dBDriverText.getText() + "\n");
			save.write("databasePath=" + dBPathText.getText() + "\n");
			save.write("databasePort=" + dBPortText.getText() + "\n");
			save.write("databaseName=" + dBNameText.getText() + "\n");
			save.write("mailServerPath=" + mailServPathText.getText() + "\n");
			save.write("firstTimeLaunch=" + firstTimeLaunchCb.isSelected());
			save.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (save != null)
				try {
					save.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}

	}

	private void currentButtonClickedMethod() {
		Scanner scan = new Scanner(System.in);
		try {
			File getFile = new File("Options.txt");
			scan = new Scanner(getFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while (scan.hasNextLine()) {
				String[] split = new String[2];
				String line = scan.nextLine();
				split = line.split("=");
				if (split.length != 2)
					throw new SetupIncompleteException();
				else {
					if (split[0].equalsIgnoreCase("databaseDriver")) {
						dBDriverText.setText(split[1]);
					} else if (split[0].equalsIgnoreCase("databasePath")) {
						dBPathText.setText(split[1]);
					} else if (split[0].equalsIgnoreCase("databasePort")) {
						dBPortText.setText(split[1]);
					} else if (split[0].equalsIgnoreCase("databaseName")) {
						dBNameText.setText(split[1]);
					} else if (split[0].equalsIgnoreCase("mailServerPath")) {
						mailServPathText.setText(split[1]);

					}
				}

			}
		} catch (Exception e) {

		}
	}
}
