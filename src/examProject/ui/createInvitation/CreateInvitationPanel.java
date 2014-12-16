package examProject.ui.createInvitation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import examProject.logic.BackendFacade;
import examProject.transferObjects.HsiTO;

public class CreateInvitationPanel extends JPanel {
	private static final long serialVersionUID = -1887688398933276294L;
	private BackendFacade facade;
	private JList<String> occasionsList = new JList<String>();
	private JButton createInvitationButton = new JButton("Skapa inbjudan");
	private JButton loadPeriodButton = new JButton("Visa Period");
	private JLabel fromDateLabel = new JLabel("Datum från:");
	private JLabel toDateLabel = new JLabel("Datum till");
	private JTextField fromDateText = new JTextField();
	private JTextField toDateText = new JTextField();

	public CreateInvitationPanel() {
		this(new BackendFacade());

	}

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

	}

	private void LoadButtonClickedMethod() {
		if (!fromDateText.getText().equals("")
				&& toDateText.getText().equals("")) {
			HsiTO hsiTo = new HsiTO(fromDateText.getText(),
					toDateText.getText());
			List<HsiTO> sessionsList = facade.getSessions();
		}

	}

}