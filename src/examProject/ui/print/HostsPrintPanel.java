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
import javax.swing.UIManager;

public class HostsPrintPanel extends JPanel {
	private static final long serialVersionUID = 60477093723435356L;
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

	public HostsPrintPanel() {
		setLayout(null);
		setBounds();
		addCtrls();
		buttonListener();

	}

	private void setBounds() {
		firstName.setBounds(50, 50, 98, 20);
		lastName.setBounds(50, 80, 98, 20);
		civicNr.setBounds(50, 110, 118, 20);
		address.setBounds(50, 140, 98, 20);
		zipcode.setBounds(50, 170, 118, 20);
		city.setBounds(50, 200, 83, 20);
		email.setBounds(50, 230, 92, 20);
		phone.setBounds(50, 260, 92, 20);
		mobile.setBounds(50, 290, 98, 20);
		printButton.setBounds(50, 336, 130, 29);

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
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		JFrame f = new JFrame("Tillfällen");
		JList<String> printList = new JList<String>();
		printList.setListData(arrString);
		printList.setPreferredSize(new Dimension(500, 500));
		f.add("Center", printList);
		JButton printWindowButton = new JButton("Skriv ut");
		printWindowButton.addActionListener(new Printer(f));
		f.add("South", printWindowButton);
		f.pack();
		f.setVisible(true);

	}

}
