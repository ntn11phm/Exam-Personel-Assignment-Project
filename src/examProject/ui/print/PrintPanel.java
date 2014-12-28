package examProject.ui.print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import examProject.logic.BackendFacade;

public class PrintPanel extends JPanel {
	private BackendFacade facade;
	private static final long serialVersionUID = -3121763534904494306L;
	private JScrollPane listPane = new JScrollPane();
	private JList<String> sessionsList = new JList<String>();
	private JLabel dateLabel = new JLabel("Välj datum");
	private JTextField dateFieldText = new JTextField();
	private JButton printButton = new JButton("Skriv ut");
	private JButton loadButton = new JButton("Visa tillfällen");

	public PrintPanel(BackendFacade facade) {
		this.facade = facade;
		setLayout(null);
		setBounds();
		addCtrls();
		buttonListener();

	}

	private void setBounds() {
		listPane.setBounds(23, 129, 130, 156);
		dateLabel.setBounds(23, 11, 130, 29);
		dateFieldText.setBounds(23, 42, 130, 29);
		dateFieldText.setToolTipText("Datumformat: yyyy-mm-dd");
		loadButton.setBounds(23, 82, 130, 29);
		printButton.setBounds(23, 296, 130, 29);
	}

	private void addCtrls() {
		add(listPane);
		add(dateLabel);
		add(dateFieldText);
		add(printButton);
		add(loadButton);
	}

	private void buttonListener() {
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadButtonClickedMethod();

			}
		});
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void loadButtonClickedMethod() {
		if (!dateFieldText.getText().equals("")) {
			if (validateTextFields(dateFieldText.getText())) {

				// CreateInvitationTO cTo = new CreateInvitationTO(
				// dateFieldText.getText());
				// sessionsList = facade.getSessions(cTo);
				//
				// int lenght = sessionsList.size() - 1;
				// String[] arrString = new String[lenght];
				// for (int i = 0; i < lenght; i++)
				// arrString[i] = sessionsList.get(i).toString();
				// occasionsList.setListData(arrString);

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
