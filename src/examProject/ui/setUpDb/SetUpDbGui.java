package examProject.ui.setUpDb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		userNameText.setBounds(131, 72, 130, 20);
		dBDriverText.setBounds(131, 32, 130, 20);
		dBPathText.setBounds(131, 191, 130, 20);
		dBPortText.setBounds(131, 151, 130, 20);
		dBNameText.setBounds(131, 111, 130, 20);
		mailServPathText.setBounds(131, 231, 130, 20);
		firstTimeLaunchCb.setBounds(29, 271, 130, 20);
		saveButton.setBounds(29, 322, 90, 30);
		clearFieldsButton.setBounds(131, 323, 129, 29);
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

	}

	private void guiButtonListener() {
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClickedMethod();

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

	private void buttonClickedMethod() {
		//gör nåt..

	}

}
