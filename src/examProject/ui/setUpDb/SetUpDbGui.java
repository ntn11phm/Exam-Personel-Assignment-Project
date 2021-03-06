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
	private JLabel dBDriverLabel = new JLabel("Databasedriver:");
	private JLabel dBPathLabel = new JLabel("Databasepath:");
	private JLabel dBPortLabel = new JLabel("Database-PortNr:");
	private JLabel dBNameLabel = new JLabel("Databasename:");
	private JCheckBox firstTimeLaunchCb = new JCheckBox("First time launch");
	private JTextField dBDriverText = new JTextField(30);
	private JTextField dBPathText = new JTextField(30);
	private JTextField dBPortText = new JTextField(30);
	private JTextField dBNameText = new JTextField(30);
	private JButton currentSetupButton = new JButton("View Setup file");
	private JButton saveButton = new JButton("Save");
	private JButton clearFieldsButton = new JButton("Clear Fields");
	private boolean isNotSaved = true;

	public SetUpDbGui() {
		setLayout(null);
		setBounds();
		addCtrls();
		guiButtonListener();
		currentButtonClickedMethod();
	}

	private void setBounds() {
		dBDriverLabel.setBounds(10, 11, 130, 20);
		dBPathLabel.setBounds(10, 104, 130, 20);
		dBPortLabel.setBounds(10, 73, 130, 20);
		dBNameLabel.setBounds(10, 42, 130, 20);
		dBDriverText.setBounds(112, 11, 160, 20);
		dBPathText.setBounds(112, 104, 160, 20);
		dBPortText.setBounds(112, 73, 160, 20);
		dBNameText.setBounds(112, 42, 160, 20);
		firstTimeLaunchCb.setBounds(112, 190, 130, 20);
		saveButton.setBounds(10, 185, 90, 30);
		clearFieldsButton.setBounds(149, 145, 129, 29);
		currentSetupButton.setBounds(10, 145, 129, 29);
	}

	private void addCtrls() {
		add(dBDriverLabel);
		add(dBPathLabel);
		add(dBPortLabel);
		add(dBNameLabel);
		add(dBDriverText);
		add(dBPathText);
		add(dBPortText);
		add(dBNameText);
		add(firstTimeLaunchCb);
		add(saveButton);
		add(clearFieldsButton);
		add(currentSetupButton);

	}
	
	public boolean getSavedStatus() {
		return isNotSaved;
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
				dBDriverText.setText("");
				dBPathText.setText("");
				dBPortText.setText("");
				dBNameText.setText("");
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
			save.write("firstTimeLaunch=false");
			save.close();
			isNotSaved = false;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (save != null)
				try {
					save.close();
				} catch (IOException e) {}
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
				else
					if (split[0].equalsIgnoreCase("databaseDriver")) {
						dBDriverText.setText(split[1]);
					} else if (split[0].equalsIgnoreCase("databasePath")) {
						dBPathText.setText(split[1]);
					} else if (split[0].equalsIgnoreCase("databasePort")) {
						dBPortText.setText(split[1]);
					} else if (split[0].equalsIgnoreCase("databaseName")) {
						dBNameText.setText(split[1]);
					}
			}
		} catch (Exception e) { }
	}
}
