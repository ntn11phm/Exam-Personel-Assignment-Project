package examProject.ui.createInvitation;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;
import java.util.Date;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import examProject.logic.BackendFacade;

public class CreateInvitationPanel extends JPanel {
	private static final long serialVersionUID = -1887688398933276294L;
	private BackendFacade facade;
	private UtilDateModel dateModel = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, null);
	private JDatePicker fromDate = new JDatePickerImpl(datePanel, null);
	private JDatePicker toDate = new JDatePickerImpl(datePanel, null);
	private JButton createInvitationButton = new JButton("Skapa inbjudan");
	private JLabel fromDateLabel = new JLabel("Datum från:");
	private JLabel toDateLabel = new JLabel("Datum till");

	public CreateInvitationPanel() {
		this(new BackendFacade());

	}

	public CreateInvitationPanel(BackendFacade facade) {
		this.facade = facade;
		setLayout(null);
		setBounds();
		addCtrls();
	}

	private void setBounds() {
		((Component) fromDate).setBounds(10,68,120,30);
		((Component) toDate).setBounds(231,68,120,30);
		createInvitationButton.setBounds(29, 246, 170, 34);
		fromDateLabel.setBounds(28, 44, 130, 28);
		toDateLabel.setBounds(257, 44, 130, 28);
		
		

	}

	private void addCtrls() {
		add(createInvitationButton);
		add(fromDateLabel);
		add(toDateLabel);
		add((Component) fromDate);
		add((Component) toDate);

	}

	private void buttonListener() {

	}

}