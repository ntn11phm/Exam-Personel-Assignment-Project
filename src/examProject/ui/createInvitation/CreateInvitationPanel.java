package examProject.ui.createInvitation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import examProject.logic.BackendFacade;
import examProject.transferObjects.CreateInvitationTO;
import examProject.transferObjects.HsiTO;

public class CreateInvitationPanel extends JPanel {
	private static final long serialVersionUID = -1887688398933276294L;
	private BackendFacade facade;
	private JList<String> occasionsList = new JList<String>();
	private JButton createInvitationButton = new JButton("Skapa inbjudan");
	private JButton loadPeriodButton = new JButton("Visa Period");
	private JLabel fromDateLabel = new JLabel("Datum från:");
	private JLabel toDateLabel = new JLabel("Datum till:");
	private JTextField fromDateText = new JTextField();
	private JTextField toDateText = new JTextField();
	private List<HsiTO> sessionList;

	public CreateInvitationPanel(BackendFacade facade) {
		this.facade = facade;
		setLayout(null);
		setBounds();
		addCtrls();
		buttonListener();
	}

	private void setBounds() {

		createInvitationButton.setBounds(28, 421, 143, 34);
		loadPeriodButton.setBounds(28, 156, 130, 29);
		fromDateLabel.setBounds(28, 21, 130, 28);
		toDateLabel.setBounds(28, 90, 130, 28);
		occasionsList.setBounds(10, 196, 177, 214);
		fromDateText.setToolTipText("Datumformat: yyyy-mm-dd");
		fromDateText.setBounds(28, 50, 130, 29);
		toDateText.setToolTipText("Datumformat: yyyy-mm-dd");
		toDateText.setBounds(28, 116, 130, 29);

	}

	private void addCtrls() {
		add(createInvitationButton);
		add(loadPeriodButton);
		add(fromDateLabel);
		add(toDateLabel);
		add(occasionsList);
		add(fromDateText);
		add(toDateText);

	}

	private void buttonListener() {
		loadPeriodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadButtonClickedMethod();
			}
		});
		createInvitationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createInvitationButtonClickedMethod();
			}
		});

	}

	private void LoadButtonClickedMethod() {
		if (!fromDateText.getText().equals("")
				&& !toDateText.getText().equals("")) {
			if (validateTextFields(fromDateText.getText())
					&& validateTextFields(toDateText.getText())) {

				CreateInvitationTO cTo = new CreateInvitationTO(
						fromDateText.getText(), toDateText.getText());
				sessionList = facade.getSessions(cTo);

				int lenght = sessionList.size() - 1;
				String[] arrString = new String[lenght];
				for (int i = 0; i < lenght; i++)
					arrString[i] = sessionList.get(i).toString();
				occasionsList.setListData(arrString);

			} else
				JOptionPane.showMessageDialog(null, "Felaktig inmatning");
		} else {
			JOptionPane.showMessageDialog(null, "Fyll i datum");
		}

	}

	private boolean createInvitationButtonClickedMethod() {
		boolean result = facade.createHsi(sessionList);
		if(result )
			result = true;
		
		return result;

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