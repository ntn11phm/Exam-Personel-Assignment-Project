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
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import e.xamProject.ui.showInformationAboutHosts.ShowHostsInformation;
import examProject.logic.BackendFacade;
import examProject.transferObjects.UpdateUserTransfere;
import examProject.ui.updateUserInformation.UI_LoadUserInformation;

public class HostsPrintPanel extends JPanel {
	private static final long serialVersionUID = 60477093723435356L;
	private BackendFacade facade;
	private JList<String> hostList = new JList<String>();
	private JScrollPane hostsListPane = new JScrollPane(hostList);
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
	private String[] arrString;
	private ShowHostsInformation sHi;
	private UI_LoadUserInformation loadUI;

	public HostsPrintPanel(BackendFacade facade) {
		sHi = new ShowHostsInformation(facade);
		loadUI = new UI_LoadUserInformation(facade);
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
		sHi.setBounds(0, 0, 590, 182);
		hostsListPane.setBounds(241, 211, 130, 156);
		hostsListPane.setViewportView(hostList);

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
		add(sHi);
		add(hostsListPane);

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
		UpdateUserTransfere uTo = facade.getCurrentHostData();
		
		if (firstName.isSelected()
				&& !uTo.firstName.isEmpty()) {
			hostList.add(firstName, uTo.firstName);
		}
		if (lastName.isSelected()
				&& !uTo.lastName.isEmpty()) {
			hostList.add(lastName, uTo.lastName);
		}
		if (civicNr.isSelected()
				&& !uTo.civic.isEmpty()) {
			hostList.add(civicNr,uTo.civic);
		}
		if (address.isSelected()
				&& !uTo.Address.isEmpty()) {
			hostList.add(address, uTo.Address);
		}
		if (zipcode.isSelected()
				&& !uTo.zipCode.isEmpty()) {
			hostList.add(zipcode, uTo.zipCode);
		}
		if (city.isSelected() 
				&& !uTo.city.isEmpty()) {
			hostList.add(city, uTo.city);
		}
		if (email.isSelected()
				&& !uTo.email.isEmpty()) {
			hostList.add(email, uTo.email);
		}
		if (phone.isSelected()
				&& !uTo.phoneNr.isEmpty()) {
			hostList.add(phone, uTo.phoneNr);
		}
		if (mobile.isSelected()
				&& !uTo.mobileNr.isEmpty()) {
			hostList.add(mobile, uTo.mobileNr);
		}
		//printHostsList = facade.(firstName, lastName, email, civicNr, mobile, phone, city, address, zipcode);

		hostList.setListData(arrString);
	}

}
