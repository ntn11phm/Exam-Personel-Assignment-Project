package examProject.ui.print;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import examProject.logic.BackendFacade;
import examProject.transferObjects.PrintSessionsTO;

public class SessionsPrintPanel extends JPanel {
	private BackendFacade facade;
	private static final long serialVersionUID = -3121763534904494306L;
	private JList<String> sessionsList = new JList<String>();
	private JList<String> hostList = new JList<String>();
	private JScrollPane sessionsListPane = new JScrollPane(sessionsList);
	private JScrollPane hostsListPane = new JScrollPane(hostList);
	private JLabel dateLabel = new JLabel("Välj datum");
	private JTextField dateFieldText = new JTextField();
	private JButton printButton = new JButton("Skriv ut");
	private JButton loadSessionsButton = new JButton("Visa tillfälle");
	private JButton loadHostsButton = new JButton("Visa värdar");
	private List<PrintSessionsTO> printSessionsList;
	private String[] arrString;

	public SessionsPrintPanel(BackendFacade facade) {
		this.facade = facade;
		setLayout(null);
		setBounds();
		addCtrls();
		buttonListener();

	}

	private void setBounds() {
		sessionsListPane.setBounds(23, 129, 130, 156);
		sessionsListPane.setViewportView(sessionsList);
		hostsListPane.setBounds(206, 129, 130, 156);
		hostsListPane.setViewportView(hostList);
		dateLabel.setBounds(23, 11, 130, 29);
		dateFieldText.setBounds(23, 42, 130, 29);
		dateFieldText.setToolTipText("Datumformat: yyyy-mm-dd");
		loadSessionsButton.setBounds(23, 82, 130, 29);
		printButton.setBounds(23, 401, 130, 29);
		loadHostsButton.setBounds(206, 82, 130, 29);
	}

	private void addCtrls() {
		add(hostsListPane);
		add(sessionsListPane);
		add(dateLabel);
		add(dateFieldText);
		add(printButton);
		add(loadSessionsButton);
		add(loadHostsButton);
	}

	private void buttonListener() {
		loadSessionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadSessionsButtonClickedMethod();

			}
		});
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					printButtonClickedMethod();
				} catch (PrinterException e1) {
					e1.printStackTrace();
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

	private void loadSessionsButtonClickedMethod() {
		if (!dateFieldText.getText().equals("")) {
			if (validateTextFields(dateFieldText.getText())) {
				printSessionsList = facade.getSessions(dateFieldText.getText());
				int length = printSessionsList.size() - 1;
				arrString = new String[length];
				for (int i = 0; i < length; i++)
					arrString[i] = printSessionsList.get(i).toString();
				sessionsList.setListData(arrString);

			} else
				JOptionPane.showMessageDialog(null, "Felaktig inmatning");
		} else {
			JOptionPane.showMessageDialog(null, "Fyll i datum");
		}

	}

	private boolean validateTextFields(String dateInput) {
		boolean result = true;
		if (!(dateInput.length() == 10))
			return false;
		else if (!dateInput.substring(4, 5).equals("-"))
			return false;
		else if (!dateInput.substring(7, 8).equals("-"))
			return false;
		for (int i = 0; i < dateInput.length(); i++)
			switch (dateInput.substring(i, i + 1).toLowerCase()) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
			case "-":
				if (dateInput.substring(i, i + 1).equals("-"))
					switch (i) {
					case 7:
					case 4:
						break;
					default:
						return false;
					}

				break;
			default:
				return false;
			}

		return result;
	}

}
