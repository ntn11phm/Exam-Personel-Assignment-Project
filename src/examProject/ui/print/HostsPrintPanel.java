package examProject.ui.print;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import examProject.logic.BackendFacade;
import examProject.transferObjects.UpdateUserTransfere;

public class HostsPrintPanel extends JPanel {
	private static final long serialVersionUID = 60477093723435356L;
	private BackendFacade facade;
	private JList<String> hostList = new JList<String>();
	private JCheckBox firstName = new JCheckBox("Förnamn");
	private JCheckBox lastName = new JCheckBox("Efternamn");
	private JCheckBox civicNr = new JCheckBox("Personnummer");
	private JCheckBox address = new JCheckBox("Adress");
	private JCheckBox zipcode = new JCheckBox("Postnummer");
	private JCheckBox city = new JCheckBox("Ort");
	private JCheckBox email = new JCheckBox("E-post");
	private JCheckBox phone = new JCheckBox("Telefon");
	private JCheckBox mobile = new JCheckBox("Mobil");
	private JButton printButton = new JButton("Skriv ut");
	private JTextArea hosts = new JTextArea();
	private String[] arrString;
	private UpdateUserTransfere uTo;

	public HostsPrintPanel(BackendFacade facade) {
		setLayout(null);
		setBounds();
		addCtrls();
		buttonListener();
	}

	private void setBounds() {
		firstName.setBounds(396, 179, 98, 20);
		lastName.setBounds(396, 201, 98, 20);
		civicNr.setBounds(396, 224, 118, 20);
		address.setBounds(396, 247, 98, 20);
		zipcode.setBounds(396, 270, 118, 20);
		city.setBounds(396, 293, 83, 20);
		email.setBounds(396, 316, 92, 20);
		phone.setBounds(396, 339, 92, 20);
		mobile.setBounds(396, 362, 98, 20);
		printButton.setBounds(396, 389, 130, 29);
	}

	private void addCtrls() {
		add(firstName);
		add(lastName);
		add(civicNr);
		add(address);
		add(zipcode);
		add(city);
		add(email);
		add(phone);
		add(mobile);
		add(printButton);
		// add(sHi);
		// add(hostsListPane);
	}

	private void buttonListener() {
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					printButtonClickedMethod();
				} catch (PrinterException e) {
					e.printStackTrace();
				}

			}
		});
	}

	private void printButtonClickedMethod() throws PrinterException {

		isCheckBoxSelected();
		hostsToPrint();

		UIManager.put("swing.boldMetal", Boolean.FALSE);
		JFrame f = new JFrame("VärdInfo");
		JList<String> printList = new JList<String>();
		printList.setListData(arrString);
		printList.setPreferredSize(new Dimension(500, 500));
		f.getContentPane().add("Center", printList);
		JButton printWindowButton = new JButton("Skriv ut");
		printWindowButton.addActionListener(new Printer(f));
		f.getContentPane().add("South", printWindowButton);
		f.pack();
		f.setVisible(true);
	}

	private void isCheckBoxSelected() {
		//uTo = facade.getCurrentHostData();

		if (firstName.isSelected() && !uTo.getFirstName().isEmpty()) {
			hostList.add(firstName, uTo.getFirstName());
		}
		if (lastName.isSelected() && !uTo.getLastName().isEmpty()) {
			hostList.add(lastName, uTo.getLastName());
		}
		if (civicNr.isSelected() && !uTo.getCivic().isEmpty()) {
			hostList.add(civicNr, uTo.getCivic());
		}
		if (address.isSelected() && !uTo.getAddress().isEmpty()) {
			hostList.add(address, uTo.getAddress());
		}
		if (zipcode.isSelected() && !uTo.getZipCode().isEmpty()) {
			hostList.add(zipcode, uTo.getZipCode());
		}
		if (city.isSelected() && !uTo.getCity().isEmpty()) {
			hostList.add(city, uTo.getCity());
		}
		if (email.isSelected() && !uTo.getEmail().isEmpty()) {
			hostList.add(email, uTo.getEmail());
		}
		if (phone.isSelected() && !uTo.getPhoneNr().isEmpty()) {
			hostList.add(phone, uTo.getPhoneNr());
		}
		if (mobile.isSelected() && !uTo.getMobileNr().isEmpty()) {
			hostList.add(mobile, uTo.getMobileNr());
		}

		 //hosts.setText();
	}

	private void hostsToPrint() {
		uTo = facade.getCurrentHostData();
		String currentHostList = hosts.getText();
		if (!currentHostList.isEmpty()) {
			currentHostList += "/n";
			hosts.setText(currentHostList);
		}
	}
}
